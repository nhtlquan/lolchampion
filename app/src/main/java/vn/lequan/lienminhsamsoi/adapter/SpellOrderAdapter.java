package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.championgg.SpellOrder;

public class SpellOrderAdapter extends Adapter<SpellOrderAdapter.Viewholder> {
    private Context context;
    private SpellOrder spellOrder;

    public class Viewholder extends ViewHolder {
        ImageView spellE;
        ImageView spellQ;
        ImageView spellR;
        ImageView spellW;
        TextView tvLever;

        public Viewholder(View itemView) {
            super(itemView);
            this.tvLever = (TextView) itemView.findViewById(R.id.tv_lever);
            this.spellQ = (ImageView) itemView.findViewById(R.id.img_Q);
            this.spellW = (ImageView) itemView.findViewById(R.id.img_W);
            this.spellE = (ImageView) itemView.findViewById(R.id.img_E);
            this.spellR = (ImageView) itemView.findViewById(R.id.img_R);
        }
    }

    public SpellOrderAdapter(SpellOrder spellOrder, Context context) {
        this.spellOrder = spellOrder;
        this.context = context;
    }

    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(this.context).inflate(R.layout.item_spell_order, parent, false));
    }

    public void onBindViewHolder(Viewholder holder, int position) {
        String urlQ = (String) this.spellOrder.getUrlSkin().get(0);
        String urlW = (String) this.spellOrder.getUrlSkin().get(1);
        String urlE = (String) this.spellOrder.getUrlSkin().get(2);
        String urlR = (String) this.spellOrder.getUrlSkin().get(3);
        String[] lever = this.spellOrder.getLever();
        boolean spellQ = ((Boolean) this.spellOrder.getSpellQ().get(position)).booleanValue();
        boolean spellW = ((Boolean) this.spellOrder.getSpellW().get(position)).booleanValue();
        boolean spellE = ((Boolean) this.spellOrder.getSpellE().get(position)).booleanValue();
        boolean spellR = ((Boolean) this.spellOrder.getSpellR().get(position)).booleanValue();
        if (position == 0) {
            Glide.with(this.context).load(urlQ).into(holder.spellQ);
            Glide.with(this.context).load(urlW).into(holder.spellW);
            Glide.with(this.context).load(urlE).into(holder.spellE);
            Glide.with(this.context).load(urlR).into(holder.spellR);
            return;
        }
        Glide.with(this.context).load("").into(holder.spellQ);
        Glide.with(this.context).load("").into(holder.spellW);
        Glide.with(this.context).load("").into(holder.spellE);
        Glide.with(this.context).load("").into(holder.spellR);
        holder.tvLever.setText(lever[position]);
        if (spellQ) {
            holder.spellQ.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white));
        } else {
            holder.spellQ.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorPrimary));
        }
        if (spellW) {
            holder.spellW.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white));
        } else {
            holder.spellW.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorPrimary));
        }
        if (spellE) {
            holder.spellE.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white));
        } else {
            holder.spellE.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorPrimary));
        }
        if (spellR) {
            holder.spellR.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white));
        } else {
            holder.spellR.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorPrimary));
        }
    }

    public int getItemCount() {
        return this.spellOrder.getLever().length;
    }
}
