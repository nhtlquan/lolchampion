package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import vn.lequan.lienminhsamsoi.Interface_Detail;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.NewsWebview;
import vn.lequan.lienminhsamsoi.models.News;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<News> lstData;
    private int numberColmns = 0;
    private int size = 0;
    public Interface_Detail interface_detail;

    public void setList(Interface_Detail interfacedetail) {
        interface_detail = interfacedetail;
    }


    public NewsAdapter(Context context, List<News> lstData, int numberColmns) {
        this.context = context;
        this.lstData = lstData;
        this.numberColmns = numberColmns;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.init(lstData.get(position));
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void addAll(List<News> data) {
        this.lstData.addAll(data);
        notifyDataSetChanged();
//        notifyItemRangeInserted(size, getItemCount());
    }



    private class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_image;
        private TextView tv_title,tv_description, tv_date;

        public MyViewHolder(View view) {
            super(view);
            img_image = view.findViewById(R.id.img_image);
            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_description);
            tv_date = view.findViewById(R.id.tv_date);

        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final News item) {
            Glide.with(context)
                    .load("https://lienminh.garena.vn/"+ item.getImage_url())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error((int) R.drawable.unchampion).into(img_image);
            tv_title.setText(item.getTitle());
            tv_description.setText(item.getDescription());
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
                                    Intent intent = new Intent(context, NewsWebview.class);
                                    intent.putExtra("link", item.getUrl());
                                    context.startActivity(intent);
                                }

                                @Override
                                public void onAnimationEnd(final View view) {
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

        private class CycleInterpolator implements android.view.animation.Interpolator {

            private final float mCycles = 0.5f;

            @Override
            public float getInterpolation(final float input) {
                return (float) Math.sin(2.0f * mCycles * Math.PI * input);
            }
        }
    }

}
