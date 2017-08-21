package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.ModelGridView;


/**
 * Created by admin on 18/08/2016.
 */
public class ChampionHistoryAdapter extends BaseAdapter {

    private Context context;
    private List<ModelGridView> lstData;
    private MyViewHolder myViewHolder;
    private int poAnInt;

    public ChampionHistoryAdapter(Context context, List<ModelGridView> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    public void addAll(List<ModelGridView> data) {
        this.lstData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lstData.size();
    }

    @Override
    public Object getItem(int position) {
        return lstData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_spiner_champion, viewGroup, false);
            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) view.getTag();
        }
        myViewHolder.init(lstData.get(position), position);
        return view;
    }

    public void clean() {
        this.lstData.clear();
        notifyDataSetChanged();
    }

    public void setPosition(int position) {
        poAnInt = position;
        notifyDataSetChanged();
    }

    private class MyViewHolder {
        CircleImageView imgImage;
        TextView tvName;
        View view_line;

        public MyViewHolder(View view) {
            this.tvName = (TextView) view.findViewById(R.id.title);
            this.imgImage = (CircleImageView) view.findViewById(R.id.thumb);
            view_line = view.findViewById(R.id.view_line);
        }

        public void init(ModelGridView item, int position) {
            if (poAnInt == position) {
                view_line.setVisibility(View.GONE);
            } else {
                view_line.setVisibility(View.VISIBLE);
            }
            tvName.setText(((ModelGridView) lstData.get(position)).getName());
            Glide.with(context)
                    .load("http://ddragon.leagueoflegends.com/cdn/7.13.1/img/champion/" + ((ModelGridView) lstData.get(position)).getId() + ".png")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error((int) R.drawable.unchampion).into(imgImage);
        }
    }
}
