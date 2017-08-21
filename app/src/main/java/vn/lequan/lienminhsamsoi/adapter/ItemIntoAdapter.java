package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ItemIntoAdapter extends Adapter<ItemIntoAdapter.ViewHolder> {
    private Context context;
    private IActionItemSelect itemSelect;
    private List<Item> list;

    public interface IActionItemSelect {
        void onItemSelect(String str);
    }

    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        ImageView imgItem;

        ViewHolder(View view) {
            super(view);
            this.imgItem = (ImageView) view.findViewById(R.id.img_item);
        }
    }

    public ItemIntoAdapter(Context context, List<Item> list, IActionItemSelect itemSelect) {
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
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_into_item, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        int img = Utils.getImageItem(this.context, ((Item) this.list.get(position)).getId());
        Debug.e(list.get(position).getId());
        if (img != 0) {
            Glide.with(this.context).load(Integer.valueOf(img)).placeholder((int) R.drawable.untitled).error((int) R.drawable.untitled).into(holder.imgItem);
        } else {
            Glide.with(this.context).load(Utils.getUrlImageItem(this.context, ((Item) this.list.get(position)).getId())).error((int) R.drawable.untitled).into(holder.imgItem);
        }
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ItemIntoAdapter.this.itemSelect != null) {
                    ItemIntoAdapter.this.itemSelect.onItemSelect(((Item) ItemIntoAdapter.this.list.get(holder.getAdapterPosition())).getId());
                }
            }
        });
    }

    public int getItemCount() {
        return this.list.size();
    }
}
