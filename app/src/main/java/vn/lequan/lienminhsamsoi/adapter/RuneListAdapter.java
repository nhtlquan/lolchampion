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
import vn.lequan.lienminhsamsoi.models.Runes;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class RuneListAdapter extends Adapter<RuneListAdapter.ViewHolder> {
    private Context context;
    private IRunesSelect itemSelect;
    private List<Runes> list;

    public interface IRunesSelect {
        void onRunesSelected(View view, Runes runes);
    }

    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView tvDescription;
        TextView tvName;

        ViewHolder(View view) {
            super(view);
            this.imgItem = (ImageView) view.findViewById(R.id.img_rune_list);
            this.tvName = (TextView) view.findViewById(R.id.tv_name_rune);
            this.tvDescription = (TextView) view.findViewById(R.id.tv_description_rune);
        }
    }

    public RuneListAdapter(Context context, List<Runes> list, IRunesSelect itemSelect) {
        this.list = list;
        this.context = context;
        this.itemSelect = itemSelect;
    }

    public void filter(List<Runes> paramList) {
        this.list.clear();
        this.list.addAll(paramList);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rune, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvName.setText(((Runes) this.list.get(position)).getName());
        holder.tvDescription.setText(((Runes) this.list.get(position)).getDescription());
        Glide.with(this.context).load(Utils.getImageRunne(this.context, ((Runes) this.list.get(position)).getImage())).placeholder((int) R.drawable.untitled).error((int) R.drawable.untitled).into(holder.imgItem);
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RuneListAdapter.this.itemSelect != null) {
                    RuneListAdapter.this.itemSelect.onRunesSelected(v, (Runes) RuneListAdapter.this.list.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    public int getItemCount() {
        return this.list.size();
    }
}
