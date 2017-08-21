package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ItemListAdapter.IActionItemSelect;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ItemGridAdapter extends ArrayAdapter<Item> {
    private Context context;
    private IActionItemSelect iActionItemSelect;
    private List<Item> list;

    private class Viewhoder {
        ImageView imgItem;
        TextView tvGold;

        private Viewhoder() {
        }
    }

    public ItemGridAdapter(Context context, List<Item> list, IActionItemSelect itemSelect) {
        super(context, 0, list);
        this.list = list;
        this.context = context;
        this.iActionItemSelect = itemSelect;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        Viewhoder holder;
        if (convertView == null) {
            convertView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.item_grid_item, parent, false);
            holder = new Viewhoder();
            holder.tvGold = (TextView) convertView.findViewById(R.id.tv_item_gold);
            holder.imgItem = (ImageView) convertView.findViewById(R.id.img_item);
            convertView.setTag(holder);
        } else {
            holder = (Viewhoder) convertView.getTag();
        }
        holder.tvGold.setText(((Item) this.list.get(position)).getGoldTotal());
        int img = Utils.getImageItem(this.context, ((Item) this.list.get(position)).getId());
        if (img != 0) {
            Glide.with(this.context).load(Integer.valueOf(img)).into(holder.imgItem);
        } else {
            Glide.with(this.context).load(Utils.getUrlImageItem(this.context, ((Item) this.list.get(position)).getId())).error((int) R.drawable.untitled).into(holder.imgItem);
        }
        holder.imgItem.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ItemGridAdapter.this.iActionItemSelect.onItemSelect(((Item) ItemGridAdapter.this.list.get(position)).getId());
            }
        });
        return convertView;
    }

    public void filter(List<Item> paramList) {
        this.list.clear();
        this.list.addAll(paramList);
        notifyDataSetChanged();
    }
}
