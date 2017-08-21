package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ItemFromAdapter extends Adapter<ItemFromAdapter.ViewHolder> {
    private Context context;
    private IActionItemFromSelect itemSelect;
    private List<Item> list;

    public interface IActionItemFromSelect {
        void onItemFromSelect(String str);
    }

    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView textView;

        ViewHolder(View view) {
            super(view);
            this.imgItem = (ImageView) view.findViewById(R.id.img_item);
            this.textView = (TextView) view.findViewById(R.id.tv_item_gold);
        }
    }

    public ItemFromAdapter(Context context, List<Item> list, IActionItemFromSelect itemSelect) {
        this.list = list;
        this.context = context;
        this.itemSelect = itemSelect;
    }

    public void filter(List<Item> paramList) {
        this.list.clear();
        this.list.addAll(paramList);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_item, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(((Item) this.list.get(position)).getGoldTotal());
        int img = Utils.getImageItem(this.context, ((Item) this.list.get(position)).getId());
        if (img != 0) {
            Glide.with(this.context).load(Integer.valueOf(img)).placeholder((int) R.drawable.untitled).error((int) R.drawable.untitled).into(holder.imgItem);
        } else {
            Glide.with(this.context).load(Utils.getUrlImageItem(this.context, ((Item) this.list.get(position)).getId())).error((int) R.drawable.untitled).into(holder.imgItem);
        }
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ItemFromAdapter.this.itemSelect != null) {
                    ItemFromAdapter.this.itemSelect.onItemFromSelect(((Item) ItemFromAdapter.this.list.get(holder.getAdapterPosition())).getId());
                }
            }
        });
    }

    public int getItemCount() {
        return this.list.size();
    }
}
