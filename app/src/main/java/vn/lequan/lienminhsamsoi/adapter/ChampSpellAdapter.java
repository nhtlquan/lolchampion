package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.NativeExpressAdView;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.Spell;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ChampSpellAdapter extends Adapter<ViewHolder> {
    private Context activity;
    private String languageCode;
    private List<Spell> mList;
    private ISpellChamp spellChamp;

    public interface ISpellChamp {
        void onBtnVideoClick(int i);
    }

    private class AdViewholder extends ViewHolder {
        NativeExpressAdView adView;

        AdViewholder(View itemView) {
            super(itemView);
            this.adView = (NativeExpressAdView) itemView.findViewById(R.id.adView);
        }
    }

    private class Viewholder extends ViewHolder {
        ImageButton btnVideoQ;
        ImageView imgSpellQ;
        TextView tvCooldownQ;
        TextView tvCostQ;
        TextView tvDetailQ;
        TextView tvNameQ;
        TextView tvRangeQ;

        public Viewholder(View view) {
            super(view);
            this.imgSpellQ = (ImageView) view.findViewById(R.id.abilities_q_image);
            this.tvRangeQ = (TextView) view.findViewById(R.id.abilities_q_range);
            this.tvDetailQ = (TextView) view.findViewById(R.id.abilities_q_detail);
            this.tvNameQ = (TextView) view.findViewById(R.id.abilities_q_name);
            this.tvCooldownQ = (TextView) view.findViewById(R.id.abilities_q_cooldown);
            this.tvCostQ = (TextView) view.findViewById(R.id.abilities_q_cost);
            this.btnVideoQ = (ImageButton) view.findViewById(R.id.abilities_q_video);
        }
    }

    public ChampSpellAdapter(List<Spell> mList, Context activity, ISpellChamp iSpellChamp) {
        this.mList = mList;
        this.activity = activity;
        this.spellChamp = iSpellChamp;
        this.languageCode = Utils.getLanguageCode(activity);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_champ_spell, parent, false));
            case 1:
                return new AdViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ad_navite_unit, parent, false));
            default:
                return null;
        }
    }

    public void onBindViewHolder(ViewHolder viewholder, final int position) {
        switch (viewholder.getItemViewType()) {
            case 0:
                Viewholder holder = (Viewholder) viewholder;
                Spell spell = (Spell) this.mList.get(position);
                if (position == 0) {
                    int imageP = this.activity.getResources().getIdentifier(spell.getImage(), null, null);
                    if (imageP != 0) {
                        Glide.with(this.activity).load(Integer.valueOf(imageP)).into(holder.imgSpellQ);
                    } else {
                        Glide.with(this.activity).load("http://ddragon.leagueoflegends.com/cdn/" + Utils.getCurrentVersion(this.activity) + "/img/passive/" + spell.getSpellId()).error((int) R.drawable.unchampion).into(holder.imgSpellQ);
                    }
                    setSpellNameTextView(holder.tvNameQ, spell);
                    holder.tvCooldownQ.setText(spell.getDetail());
                    holder.tvCooldownQ.setTextSize(2, 14.0f);
                    holder.tvCostQ.setVisibility(8);
                    holder.tvRangeQ.setVisibility(8);
                    holder.tvDetailQ.setVisibility(8);
                    holder.btnVideoQ.setVisibility(8);
                } else {
                    holder.tvCooldownQ.setTextSize(2, 12.0f);
                    holder.tvCostQ.setVisibility(0);
                    holder.tvRangeQ.setVisibility(0);
                    holder.tvDetailQ.setVisibility(0);
                    holder.btnVideoQ.setVisibility(0);
                    setSpellNameTextView(holder.tvNameQ, spell);
                    setImageSpell(holder.imgSpellQ, spell);
                    setRangeTextView(holder.tvRangeQ, spell);
                    setCooldownTextView(holder.tvCooldownQ, spell);
                    setCostTextView(holder.tvCostQ, spell);
                    setDetailSpell(holder.tvDetailQ, spell);
                }
                holder.btnVideoQ.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        ChampSpellAdapter.this.spellChamp.onBtnVideoClick(position);
                    }
                });
                return;
            case 1:
                AdViewholder adViewholder = (AdViewholder) viewholder;
                adViewholder.adView.loadAd(new Builder().build());
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int position) {
        if (position == 4 && Utils.isNetworkAvailable(this.activity)) {
            return 1;
        }
        return 0;
    }

    public int getItemCount() {
        return this.mList.size();
    }

    private void setSpellNameTextView(TextView tv, Spell spell) {
        Typeface typeface = Typeface.createFromAsset(this.activity.getAssets(), "font/times.ttf");
        tv.setText(spell.getName());
        tv.setTypeface(typeface);
    }

    private void setCooldownTextView(TextView tv, Spell spell) {
        if (this.languageCode.equals("vn_VN")) {
            tv.setText(new StringBuilder().append(this.activity.getString(R.string.hoichieu)).append(spell.getCooldown()).append(" s"));
        } else {
            tv.setText(new StringBuilder().append("Cooldown: ").append(spell.getCooldown()).append(" s"));
        }
    }

    private void setCostTextView(TextView tv, Spell spell) {
        if (this.languageCode.equals("vn_VN")) {
            tv.setText(new StringBuilder().append(this.activity.getString(R.string.tieuhao)).append(spell.getCost()));
        } else {
            tv.setText(new StringBuilder().append("Cost: ").append(spell.getCost()));
        }
    }

    private void setRangeTextView(TextView tv, Spell spell) {
        if (this.languageCode.equals("vn_VN")) {
            tv.setText(new StringBuilder().append(this.activity.getString(R.string.khoangcach)).append(spell.getRange()));
        } else {
            tv.setText(new StringBuilder().append("Range: ").append(spell.getRange()));
        }
    }

    private void setImageSpell(ImageView imageView, Spell spell) {
        int idResource = this.activity.getResources().getIdentifier(spell.getImage(), null, null);
        if (idResource != 0) {
            Glide.with(this.activity).load(Integer.valueOf(idResource)).into(imageView);
            return;
        }
        Glide.with(this.activity).load(Utils.getUrlSpell(this.activity, spell.getSpellId())).error((int) R.drawable.unchampion).into(imageView);
    }

    private void setDetailSpell(TextView tv, Spell spell) {
        tv.setText(Html.fromHtml(spell.getDetail()));
    }
}
