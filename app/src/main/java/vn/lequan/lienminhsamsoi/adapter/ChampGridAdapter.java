package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import vn.lequan.lienminhsamsoi.AndroidDeviceInfo;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.ModelGridView;

public class ChampGridAdapter extends Adapter<ChampGridAdapter.Viewhoder> {
    private IActionClick actionClick;
    private Context mContext;
    private List<ModelGridView> mList;
    private Point point;

    public interface IActionClick {
        void onChampionCick(ModelGridView modelGridView);
    }

    class Viewhoder extends ViewHolder {
        ImageView imgImage;
        TextView tvName;

        Viewhoder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_champion);
            this.imgImage = (ImageView) itemView.findViewById(R.id.img_champion);
        }
    }

    public ChampGridAdapter(List<ModelGridView> mList, Context mContext, IActionClick actionClick) {
        this.mList = mList;
        this.mContext = mContext;
        this.actionClick = actionClick;
        point = AndroidDeviceInfo.getScreenSize(mContext);
    }

    public Viewhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewhoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_champ, parent, false));
    }

    public void onBindViewHolder(final Viewhoder holder, int position) {
        holder.itemView.setLayoutParams(new ViewGroup.LayoutParams(point.x, point.x * 9 / 16));
        holder.tvName.setText(((ModelGridView) this.mList.get(position)).getName());
        int src = this.mContext.getResources().getIdentifier(((ModelGridView) this.mList.get(position)).getImage(), null, null);
        if (src != 0) {
            Glide.with(this.mContext).load(src).into(holder.imgImage);
        } else {

            Glide.with(this.mContext)
                    .load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + ((ModelGridView) this.mList.get(position)).getId() + "_0.jpg")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.color.placehoder).into(holder.imgImage);
        }
        holder.imgImage.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ChampGridAdapter.this.actionClick != null) {
                    ChampGridAdapter.this.actionClick.onChampionCick((ModelGridView) ChampGridAdapter.this.mList.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public void filter(List<ModelGridView> paramList) {
        this.mList.clear();
        this.mList.addAll(paramList);
        notifyDataSetChanged();
    }
}
