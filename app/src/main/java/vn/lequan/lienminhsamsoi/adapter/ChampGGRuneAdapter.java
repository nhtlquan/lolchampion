package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.championgg.Runes;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ChampGGRuneAdapter extends Adapter<ChampGGRuneAdapter.Viewholder> {
    private Context context;
    private Language language;
    private List<Runes> mList;
    private int size;

    class Viewholder extends ViewHolder {
        ImageView imageView;
        TextView tvCount;
        TextView tvDetail;

        Viewholder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_runes);
            this.tvDetail = (TextView) itemView.findViewById(R.id.tv_runes_detail);
            this.tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }

    public ChampGGRuneAdapter(List<Runes> mList, Context context) {
        this.mList = mList;
        this.context = context;
        this.language = ChampDao.getInstant(context).getLanguage();
    }

    public void addAll(List<Runes> data) {
        this.mList.addAll(data);
        notifyDataSetChanged();
    }
    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_runes, parent, false));
    }

    public void onBindViewHolder(Viewholder holder, int position) {
        Runes runes = (Runes) this.mList.get(position);
        Glide.with(this.context).load(Utils.getImageRunne(this.context, runes.getImage())).into(holder.imageView);
        holder.tvDetail.setText(translate(runes.getDetail()));
        holder.tvCount.setText(String.format("%s  ", new Object[]{runes.getCount()}));
    }

    public int getItemCount() {
        return this.mList.size();
    }

    private String translate(String detail) {
        if (detail.contains("+0.87 magic")) {
            return "+0.87 " + this.language.getMagicPenetration();
        }
        if (detail.contains("+1.34 magic")) {
            return "+1.34 " + this.language.getSpellBlock();
        }
        if (detail.contains("+1 armor")) {
            return "+1 " + this.language.getArmor();
        }
        if (detail.contains("+4.95 ability")) {
            return "+4.95 " + this.language.getSpellDamage();
        }
        if (detail.contains("+0.95 attack")) {
            return "+0.95 " + this.language.getDamage();
        }
        if (detail.contains("+4.5% attack")) {
            return "+4.5% " + this.language.getAttackSpeed();
        }
        if (detail.contains("+4.26 armor")) {
            return "+4.26 " + this.language.getArmor();
        }
        if (detail.contains("+8 health")) {
            return "+8 " + this.language.getHealth();
        }
        if (detail.contains("+2.25 attack")) {
            return "+2.25 " + this.language.getDamage();
        }
        if (detail.contains("+1.19 ability")) {
            return "+1.19 " + this.language.getSpellDamage();
        }
        if (detail.contains("+1.33 health")) {
            return "+1.33 " + this.language.getHealth() + " (+24 " + this.language.getrFlatHPModPerLevel() + ")";
        }
        if (detail.contains("+1.5% movement")) {
            return "+1.5% " + this.language.getFlatMovementSpeedMod();
        }
        if (detail.contains("+0.91 armor")) {
            return "+0.91 " + this.language.getArmor();
        }
        return detail;
    }
}
