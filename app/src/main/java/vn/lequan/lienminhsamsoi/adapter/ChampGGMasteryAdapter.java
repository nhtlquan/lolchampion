package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.championgg.Mastery;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ChampGGMasteryAdapter extends Adapter<ChampGGMasteryAdapter.Viewholder> {
    private Context context;
    private IClickMastery iClickMastery;
    private List<Mastery> mList;

    public interface IClickMastery {
        void onClickMastery(Mastery mastery);
    }

    class Viewholder extends ViewHolder {
        View containerView;
        ImageView imageView;
        TextView tvPoint;

        Viewholder(View itemView) {
            super(itemView);
            this.containerView = itemView.findViewById(R.id.container);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_item);
            this.tvPoint = (TextView) itemView.findViewById(R.id.tv_point_matery);
        }
    }

    public ChampGGMasteryAdapter(Context context, List<Mastery> mList, IClickMastery iClickMastery) {
        this.context = context;
        this.mList = mList;
        this.iClickMastery = iClickMastery;
    }

    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mastery, parent, false));
    }

    public void onBindViewHolder(Viewholder holder, int position) {
        int img;
        String url;
        final Mastery mastery = (Mastery) this.mList.get(position);
        int point = mastery.getPoint();
        String id = mastery.getId();
        String version = Utils.getCurrentVersion(this.context);
        if (point > 0) {
            img = Utils.getImageItem(this.context, mastery.getId());
            url = "http://ddragon.leagueoflegends.com/cdn/" + version + "/img/mastery/" + id + ".png";
            holder.tvPoint.setText(point + "/" + point);
            holder.tvPoint.setVisibility(0);
        } else {
            img = Utils.getImageMasteryGray(this.context, mastery.getId());
            url = "http://ddragon.leagueoflegends.com/cdn/" + version + "/img/mastery/gray_" + id + ".png";
            holder.tvPoint.setVisibility(8);
        }
        if (id.isEmpty() || id.equals("")) {
            holder.containerView.setVisibility(8);
        } else if (img != 0) {
            holder.containerView.setVisibility(0);
            Glide.with(this.context).load(Integer.valueOf(img)).into(holder.imageView);
        } else {
            holder.containerView.setVisibility(0);
            Glide.with(this.context).load(url).error((int) R.drawable.untitled).into(holder.imageView);
        }
        holder.imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ChampGGMasteryAdapter.this.iClickMastery.onClickMastery(mastery);
            }
        });
    }

    public int getItemCount() {
        return this.mList.isEmpty() ? 0 : this.mList.size();
    }
}
