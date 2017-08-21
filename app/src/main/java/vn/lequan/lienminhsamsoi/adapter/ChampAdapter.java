package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import vn.lequan.lienminhsamsoi.AndroidDeviceInfo;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.ModelGridView;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class ChampAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Parcelable {
    private ChampAdapter.IActionClick actionClick;
    private Context mContext;
    private List<ModelGridView> lstData;
    private Point point;
    private int size = 0;

    public interface IActionClick {
        void onChampionCick(ModelGridView modelGridView);
    }


    public ChampAdapter(List<ModelGridView> lstData, Context mContext, ChampAdapter.IActionClick actionClick) {
        this.lstData = lstData;
        this.mContext = mContext;
        this.actionClick = actionClick;
        point = AndroidDeviceInfo.getScreenSize(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_champ, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(point.x / 4, point.x * 8 / 16));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.init(lstData.get(position), position);
    }


    public void addAll(List<ModelGridView> data) {
        this.lstData.addAll(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }

    public int getItemCount() {
        return lstData.size();
    }

    public void filter(List<ModelGridView> paramList) {
        this.lstData.clear();
        this.lstData.addAll(paramList);
        notifyDataSetChanged();
    }

    public void add(ModelGridView data) {
        this.lstData.add(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }


    public void clean() {
        lstData.clear();
        notifyDataSetChanged();
    }

    public ModelGridView getItemAtPosition(int position) {
        return lstData.get(position);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgImage;
        TextView tvName;

        public MyViewHolder(View view) {
            super(view);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_champion);
            this.imgImage = (ImageView) itemView.findViewById(R.id.img_champion);

        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final ModelGridView item, int position) {
            tvName.setText(((ModelGridView) lstData.get(position)).getName());
            int src = mContext.getResources().getIdentifier(((ModelGridView) lstData.get(position)).getImage(), null, null);
            if (src != 0) {
                Glide.with(mContext).load(src).into(imgImage);
            } else {

                Glide.with(mContext)
                        .load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + ((ModelGridView) lstData.get(position)).getId() + "_0.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error(R.color.placehoder).into(imgImage);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewCompat.animate(view)
                            .setDuration(200)
                            .scaleX(0.9f)
                            .scaleY(0.9f)
                            .setInterpolator(new CycleInterpolator())
                            .setListener(new ViewPropertyAnimatorListener() {
                                @Override
                                public void onAnimationStart(final View view) {

                                }

                                @Override
                                public void onAnimationEnd(final View view) {
                                    actionClick.onChampionCick(lstData.get(getAdapterPosition()));
                                }

                                @Override
                                public void onAnimationCancel(final View view) {

                                }
                            })
                            .withLayer()
                            .start();
                }
            });

        }

        public class CycleInterpolator implements android.view.animation.Interpolator {

            private final float mCycles = 0.5f;

            @Override
            public float getInterpolation(final float input) {
                return (float) Math.sin(2.0f * mCycles * Math.PI * input);
            }
        }


    }
}
