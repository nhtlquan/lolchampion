package vn.lequan.lienminhsamsoi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.models.SkinModel;

public class ChampSkinAdapter extends Adapter<ChampSkinAdapter.Viewholder> {
    private Iclick iclick;
    private Context mContext;
    private List<SkinModel> mList;
    Bitmap theBitmap;
    private AsyncTask asyncTask;

    private interface OnCompleteListener {
        void onComplete();
    }

    public interface Iclick {
        void onClickDownloadButton(Bitmap bitmap, String name);

    }

    class Viewholder extends ViewHolder {
        ImageView imgImage;
        TextView tvName;

        Viewholder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.item_skins_textview);
            this.imgImage = (ImageView) itemView.findViewById(R.id.item_skins_imageview);
        }
    }

    public ChampSkinAdapter(Context context, List<SkinModel> mList, Iclick iclick) {
        this.mList = mList;
        this.mContext = context;
        this.iclick = iclick;
    }

    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skin, parent, false));
    }

    public void onBindViewHolder(final Viewholder holder, final int position) {

        holder.tvName.setText(((SkinModel) this.mList.get(position)).getName());
        holder.imgImage.getLayoutParams().height = (this.mContext.getResources().getDisplayMetrics().widthPixels * 9) / 16;
        Glide.with(this.mContext).load(((SkinModel) this.mList.get(position)).getImage()).placeholder((int) R.drawable.holder).error((int) R.drawable.holder).into(holder.imgImage);
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                try {
                    theBitmap = Glide.
                            with(mContext)
                            .load(((SkinModel) mList.get(position)).getImage())
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(-1, -1)
                            .get();
                } catch (final ExecutionException | InterruptedException e) {
                    Debug.e(e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void dummy) {
            }
        }.execute();
        holder.tvName.setOnClickListener(new OnClickListener() {
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
                                ChampSkinAdapter.this.iclick.onClickDownloadButton(theBitmap, ChampSkinAdapter.this.mList.get(holder.getAdapterPosition()).getName());
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

    public int getItemCount() {
        return this.mList.size();
    }
}
