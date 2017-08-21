package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampGGMasteryAdapter.IClickMastery;
import vn.lequan.lienminhsamsoi.championgg.Masteries;
import vn.lequan.lienminhsamsoi.championgg.Mastery;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.ultis.SpacesItemDecoration;

public class ChampGGMasteriesAdapter extends Adapter<ChampGGMasteriesAdapter.Viewholder> {
    private Context context;
    private IClickMastery iClickMastery;
    private Language language;
    private Masteries masteries;

    class Viewholder extends ViewHolder {
        View containerView;
        RecyclerView recyclerView;
        TextView tvPoint;

        public Viewholder(View itemView) {
            super(itemView);
            this.tvPoint = (TextView) itemView.findViewById(R.id.tv_count_point);
            this.containerView = itemView.findViewById(R.id.container_view);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.recycle_view);
        }
    }

    public ChampGGMasteriesAdapter(Masteries masteries, Context context, IClickMastery iClickMastery) {
        this.masteries = masteries;
        this.context = context;
        this.iClickMastery = iClickMastery;
        this.language = ChampDao.getInstant(context).getLanguage();
    }

    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_mastery, parent, false));
    }

    public void onBindViewHolder(Viewholder holder, int position) {
        List<Mastery> list = new ArrayList();
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.context, 3);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.addItemDecoration(new SpacesItemDecoration(this.context.getResources().getDimensionPixelSize(R.dimen.spacing)));
        if (position == 0) {
            list = this.masteries.getCuongBao();
            holder.containerView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.background_cuongbao));
            holder.tvPoint.setText(this.language.getMasteryFerocity().toUpperCase() + " - " + getPoint(list));
        } else if (position == 1) {
            list = this.masteries.getKheoLeo();
            holder.containerView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.background_kheoleo));
            holder.tvPoint.setText(this.language.getMasteryCunning().toUpperCase() + " - " + getPoint(list));
        } else if (position == 2) {
            list = this.masteries.getKienDinh();
            holder.containerView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.background_kiendinh));
            holder.tvPoint.setText(this.language.getMasteryResolve().toUpperCase() + " - " + getPoint(list));
        }
        holder.recyclerView.setAdapter(new ChampGGMasteryAdapter(this.context, list, this.iClickMastery));
    }

    private int getPoint(List<Mastery> list) {
        int point = 0;
        for (Mastery mastery : list) {
            point += mastery.getPoint();
        }
        return point;
    }

    public int getItemCount() {
        return 3;
    }
}
