package vn.lequan.lienminhsamsoi.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.championgg.Role;

public class ChampGGRoleAdapter extends Adapter<ChampGGRoleAdapter.Viewholder> {
    private int focusItem = 0;
    private IChampGGListener listener;
    private List<Role> mList;

    public interface IChampGGListener {
        void onPickLane(Role role);
    }

    class Viewholder extends ViewHolder {
        View mView;
        TextView tvRole;
        TextView tvRoleRate;

        public Viewholder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            this.mView = itemView.findViewById(R.id.mView);
            this.tvRole = (TextView) itemView.findViewById(R.id.item_role_lane);
            this.tvRoleRate = (TextView) itemView.findViewById(R.id.item_role_lane_rate);
        }
    }

    public ChampGGRoleAdapter(List<Role> mList, IChampGGListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_role_champ, parent, false));
    }

    public void onBindViewHolder(final Viewholder holder, int position) {
        final Role role = (Role) this.mList.get(holder.getAdapterPosition());
        holder.itemView.setSelected(this.focusItem == holder.getAdapterPosition());
        if (holder.itemView.isSelected()) {
            holder.mView.setBackground(holder.mView.getResources().getDrawable(R.drawable.background_selected));
        } else {
            holder.mView.setBackgroundColor(holder.mView.getResources().getColor(R.color.colorPrimary));
        }
        holder.tvRole.setText(role.getRole().toUpperCase());
        holder.tvRoleRate.setText(role.getRoleRate());
        holder.mView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ChampGGRoleAdapter.this.listener.onPickLane(role);
                ChampGGRoleAdapter.this.notifyItemChanged(ChampGGRoleAdapter.this.focusItem);
                ChampGGRoleAdapter.this.focusItem = holder.getAdapterPosition();
                ChampGGRoleAdapter.this.notifyItemChanged(ChampGGRoleAdapter.this.focusItem);
            }
        });
    }

    public int getItemCount() {
        return this.mList.size();
    }
}
