package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.lequan.lienminhsamsoi.API.Model.History.Game;
import vn.lequan.lienminhsamsoi.API.Model.History.Stats;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.MatchDetailActivity;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Lore;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class MatchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Parcelable {

    private Context context;
    private static ProgressDialog pDialog;
    private List<Game> lstData;
    private int numberColmns = 0;
    private int size;


    public MatchHistoryAdapter(Context context, List<Game> lstData, int numberColmns) {
        this.context = context;
        this.lstData = lstData;
        this.numberColmns = numberColmns;
        pDialog = new ProgressDialog(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_match, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.init(lstData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void addAll(List<Game> data) {
        this.lstData.addAll(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }

    public void add(Game data) {
        this.lstData.add(data);
        size = getItemCount();
        notifyItemRangeInserted(size, getItemCount());
    }


    public void clean() {
        lstData.clear();
        notifyDataSetChanged();
    }

    public Game getItemAtPosition(int position) {
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

        private ImageView img_spellF, img_spellD, minion;
        private ItemHistoryAdapter itemIntoHistoryAdapter;
        private CircleImageView img_champion;
        private TextView tv_lever, tv_count_gold, tv_duration_create, tv_duration_game, tv_result, tv_kda, tv_type_match;
        private RecyclerView rcl_item_build;

        public MyViewHolder(View view) {
            super(view);
            img_spellF = view.findViewById(R.id.img_spellF);
            img_spellD = view.findViewById(R.id.img_spellD);
            img_champion = view.findViewById(R.id.img_champion);
            tv_lever = view.findViewById(R.id.tv_lever);
            tv_count_gold = view.findViewById(R.id.tv_count_gold);
            minion = view.findViewById(R.id.minion);
            tv_duration_create = view.findViewById(R.id.tv_duration_create);
            tv_duration_game = view.findViewById(R.id.tv_duration_game);
            tv_result = view.findViewById(R.id.tv_result);
            tv_kda = view.findViewById(R.id.tv_kda);
            tv_type_match = view.findViewById(R.id.tv_type_match);
            rcl_item_build = view.findViewById(R.id.rcl_item_build);

        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final Game item, int po) {
            try {
                Stats stats = item.getParticipants().get(0).getStats();
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pDialog.setMessage("Vui Lòng Chờ Giây Lát....");
                        pDialog.setCancelable(true);
                        pDialog.show();
                        ViewCompat.animate(view)
                                .setDuration(200)
                                .scaleX(0.9f)
                                .scaleY(0.9f)
                                .setInterpolator(new CycleInterpolator())
                                .setListener(new ViewPropertyAnimatorListener() {
                                    @Override
                                    public void onAnimationStart(final View view) {
                                        Intent intent = new Intent(context, MatchDetailActivity.class);
                                        intent.putExtra("MatchID", String.valueOf(item.getGameId()));
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
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MatchDetailActivity.class);
                        intent.putExtra("MatchID", String.valueOf(item.getGameId()));
                        context.startActivity(intent);
                    }
                });
                tv_lever.setText(String.valueOf(stats.getChampLevel()));
                tv_count_gold.setText(String.valueOf(stats.getGoldEarned()));
                tv_duration_create.setText(converteTimestamp(item.getGameCreation()));
                tv_duration_game.setText((new SimpleDateFormat("ss:SS")).format(new Date(item.getGameDuration() * 60)));
                if (stats.getWin()) {
                    tv_result.setTextColor(Color.GREEN);
                    tv_result.setText("THẮNG");
                } else {
                    tv_result.setTextColor(Color.RED);
                    tv_result.setText("THUA");
                }
                String kda = stats.getKills() + "/" + stats.getDeaths() + "/" + stats.getAssists();
                tv_kda.setText(kda);
                Lore lore = ChampDao.getInstant(context).getOverviewFromkey(String.valueOf(item.getParticipants().get(0).getChampionId()));
                String champion = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/champion/" + lore.getName() + ".png";
                tv_type_match.setText(lore.getName());
                champion = champion.replace(" ", "");
                Glide.with(context)
                        .load(champion)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_champion);
                String spellD = ChampDao.getInstant(context).getSummoner(String.valueOf(item.getParticipants().get(0).getSpell1Id()));
                spellD = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/spell/" + spellD + ".png";
                String spellF = ChampDao.getInstant(context).getSummoner(String.valueOf(item.getParticipants().get(0).getSpell2Id()));
                spellF = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/spell/" + spellF + ".png";

                Glide.with(context)
                        .load(spellD)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_spellD);
                Glide.with(context)
                        .load(spellF)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_spellF);
                rcl_item_build.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                rcl_item_build.setHasFixedSize(true);
                itemIntoHistoryAdapter = new ItemHistoryAdapter(context, new ArrayList<String>(), 1);
                rcl_item_build.setAdapter(itemIntoHistoryAdapter);
                ArrayList<String> listItem = new ArrayList<>();
                listItem.add(String.valueOf(stats.getItem0()));
                listItem.add(String.valueOf(stats.getItem1()));
                listItem.add(String.valueOf(stats.getItem2()));
                listItem.add(String.valueOf(stats.getItem3()));
                listItem.add(String.valueOf(stats.getItem4()));
                listItem.add(String.valueOf(stats.getItem5()));
                listItem.add(String.valueOf(stats.getItem6()));
                itemIntoHistoryAdapter.addAll(listItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private class CycleInterpolator implements android.view.animation.Interpolator {

        private final float mCycles = 0.5f;

        @Override
        public float getInterpolation(final float input) {
            return (float) Math.sin(2.0f * mCycles * Math.PI * input);
        }
    }

    private CharSequence converteTimestamp(long mileSegundos) {
        return DateUtils.getRelativeTimeSpanString(mileSegundos, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
    }

}
