package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.HistoryActivity;
import vn.lequan.lienminhsamsoi.dao.model.HistoryHome;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class ItemHistoryPlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Parcelable {

    private Context context;
    private List<HistoryHome> lstData;
    private int numberColmns = 0;
    private int size;


    public ItemHistoryPlayerAdapter(Context context, List<HistoryHome> lstData, int numberColmns) {
        this.context = context;
        this.lstData = lstData;
        this.numberColmns = numberColmns;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_player, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.init(lstData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void addAll(List<HistoryHome> data) {
        this.lstData.addAll(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }

    public void add(HistoryHome data) {
        this.lstData.add(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }


    public void clean() {
        lstData.clear();
        notifyDataSetChanged();
    }

    public HistoryHome getItemAtPosition(int position) {
        return lstData.get(position);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgItem;
        TextView tv_name_player;

        public MyViewHolder(View view) {
            super(view);
            imgItem = view.findViewById(R.id.img_icon_player);
            tv_name_player = view.findViewById(R.id.tv_name_player);
        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final HistoryHome item, int position) {
            Glide.with(context)
                    .load("http://ddragon.leagueoflegends.com/cdn/7.13.1/img/profileicon/" + item.getId_icon() + ".png")
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgItem);
            tv_name_player.setText(item.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, HistoryActivity.class);
                    intent.putExtra("AccountID", item.getId());
                    intent.putExtra("Name", item.getName());
                    context.startActivity(intent);
                }
            });
        }

    }

    private CharSequence converteTimestamp(long mileSegundos) {
        return DateUtils.getRelativeTimeSpanString(mileSegundos, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
    }

}
