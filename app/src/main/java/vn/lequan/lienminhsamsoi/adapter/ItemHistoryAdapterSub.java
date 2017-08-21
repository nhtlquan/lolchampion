package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.ultis.Utils;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class ItemHistoryAdapterSub extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Parcelable {

    private Context context;
    private List<String> lstData;
    private int numberColmns = 0;
    private int size;


    public ItemHistoryAdapterSub(Context context, List<String> lstData, int numberColmns) {
        this.context = context;
        this.lstData = lstData;
        this.numberColmns = numberColmns;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_into_history_item_sub, parent, false);
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

    public void addAll(List<String> data) {
        this.lstData.addAll(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }

    public void add(String data) {
        this.lstData.add(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }


    public void clean() {
        lstData.clear();
        notifyDataSetChanged();
    }

    public String getItemAtPosition(int position) {
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
        ImageView imgItem;

        public MyViewHolder(View view) {
            super(view);
            this.imgItem = (ImageView) view.findViewById(R.id.img_item);

        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final String item, int position) {
            int img = Utils.getImageItem(context, ((String) lstData.get(position)));
            if (img != 0) {
                Glide.with(context).load(Integer.valueOf(img)) .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder((int) R.drawable.untitled).error((int) R.drawable.untitled).into(imgItem);
            } else {
                Glide.with(context).load(Utils.getUrlImageItem(context, ((String) lstData.get(position)))) .diskCacheStrategy(DiskCacheStrategy.ALL).error((int) R.drawable.untitled).into(imgItem);
            }
        }

    }

    private CharSequence converteTimestamp(long mileSegundos) {
        return DateUtils.getRelativeTimeSpanString(mileSegundos, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
    }

}
