package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.ModelGridView;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ChampCounterAdapter extends ArrayAdapter<ModelGridView> {
    private Context context;
    private IItemClick iItemClick;
    private List<ModelGridView> list;

    public interface IItemClick {
        void onChampClick(ModelGridView modelGridView);
    }

    private class ViewHolder {
        ImageView imgImage;
        TextView tvName;

        private ViewHolder() {
        }
    }

    public ChampCounterAdapter(Context context, List<ModelGridView> objects, IItemClick iItemClick) {
        super(context, 0, objects);
        this.list = objects;
        this.context = context;
        this.iItemClick = iItemClick;
    }

    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.item_grid_champ_counter, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_champion);
            viewHolder.imgImage = (ImageView) convertView.findViewById(R.id.img_champion);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(((ModelGridView) this.list.get(position)).getName());
        int img = Utils.getImageDrawble(this.context, ((ModelGridView) this.list.get(position)).getImage());
        if (img != 0) {
            Glide.with(this.context).load(Integer.valueOf(img)).into(viewHolder.imgImage);
            viewHolder.imgImage.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ChampCounterAdapter.this.iItemClick.onChampClick((ModelGridView) ChampCounterAdapter.this.list.get(position));
                }
            });
        } else {
            viewHolder.imgImage.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ChampCounterAdapter.this.iItemClick.onChampClick((ModelGridView) ChampCounterAdapter.this.list.get(position));
                }
            });
        }
        return convertView;
    }
}
