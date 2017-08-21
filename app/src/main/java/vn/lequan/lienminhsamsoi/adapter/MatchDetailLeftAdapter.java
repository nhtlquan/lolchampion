package vn.lequan.lienminhsamsoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.Interface_Detail;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Lore;
import vn.lequan.lienminhsamsoi.models.MatchDetail.MatchParticipant;
import vn.lequan.lienminhsamsoi.models.MatchDetail.Stats;

/**
 * Created by admin on 16/08/2016.
 */
@SuppressLint("ParcelCreator")
public class MatchDetailLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Parcelable {

    private Context context;
    private List<MatchParticipant> lstData;
    private int numberColmns = 0;
    private int size;
    public Interface_Detail interface_detail;

    public void setList(Interface_Detail interfacedetail) {
        interface_detail = interfacedetail;
    }


    public MatchDetailLeftAdapter(Context context, List<MatchParticipant> lstData, int numberColmns) {
        this.context = context;
        this.lstData = lstData;
        this.numberColmns = numberColmns;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_match_history_detail, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Debug.e(String.valueOf(position));
        myViewHolder.init(lstData.get(position), position);
        interface_detail.setDetailt(lstData.get(0));
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void addAll(List<MatchParticipant> data) {
        this.lstData.addAll(data);
        notifyItemRangeInserted(size, getItemCount());
    }

    public void add(MatchParticipant data) {
        this.lstData.add(data);
        notifyItemRangeInserted(size, getItemCount());
    }


    public void clean() {
        lstData.clear();
        notifyDataSetChanged();
    }

    public MatchParticipant getItemAtPosition(int position) {
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

        private ImageView img_spellD_1, img_spellF_1;
        private CircleImageView img_champion_team_1;
        private RecyclerView rcl_item_build;
        private ItemHistoryAdapterSub itemHistoryAdapter;
        private TextView tv_lever_team_1, tv_champion_name_team_1, tv_player_name_team_1, tv_kda_1, tv_count_gold, tv_count_minion;

        public MyViewHolder(View view) {
            super(view);
            img_spellD_1 = view.findViewById(R.id.img_spellD_1);
            img_spellF_1 = view.findViewById(R.id.img_spellF_1);
            rcl_item_build = view.findViewById(R.id.rcl_item_build);
            img_champion_team_1 = view.findViewById(R.id.img_champion_team_1);
            tv_champion_name_team_1 = view.findViewById(R.id.tv_champion_name_team_1);
            tv_player_name_team_1 = view.findViewById(R.id.tv_player_name_team_1);
            tv_kda_1 = view.findViewById(R.id.tv_kda_1);

        }

        @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
        public void init(final MatchParticipant item, int po) {
            try {
                Stats stats = item.getParticipants().getStats();
                rcl_item_build.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                rcl_item_build.setHasFixedSize(true);
                itemHistoryAdapter = new ItemHistoryAdapterSub(context, new ArrayList<String>(), 1);
                rcl_item_build.setAdapter(itemHistoryAdapter);
                ArrayList<String> listItem = new ArrayList<>();
                listItem.add(String.valueOf(stats.getItem0()));
                listItem.add(String.valueOf(stats.getItem1()));
                listItem.add(String.valueOf(stats.getItem2()));
                listItem.add(String.valueOf(stats.getItem3()));
                listItem.add(String.valueOf(stats.getItem4()));
                listItem.add(String.valueOf(stats.getItem5()));
                listItem.add(String.valueOf(stats.getItem6()));
                itemHistoryAdapter.addAll(listItem);
//            itemHistoryAdapter.addAll(item.getParticipants().get);
                Debug.e(item.getParticipantIdentities().getPlayer().getSummonerName());
                tv_player_name_team_1.setText(String.valueOf(item.getParticipantIdentities().getPlayer().getSummonerName()));
                String kda = stats.getKills() + "/" + stats.getDeaths() + "/" + stats.getAssists();
                tv_kda_1.setText(kda);
                Lore lore = ChampDao.getInstant(context).getOverviewFromkey(String.valueOf(item.getParticipants().getChampionId()));
                String champion = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/champion/" + lore.getName() + ".png";
                tv_champion_name_team_1.setText(lore.getName());
                champion = champion.replace(" ", "");
                Glide.with(context)
                        .load(champion)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_champion_team_1);
                String spellD = ChampDao.getInstant(context).getSummoner(String.valueOf(item.getParticipants().getSpell1Id()));
                spellD = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/spell/" + spellD + ".png";
                String spellF = ChampDao.getInstant(context).getSummoner(String.valueOf(item.getParticipants().getSpell2Id()));
                spellF = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/spell/" + spellF + ".png";

                Glide.with(context)
                        .load(spellD)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_spellD_1);
                Glide.with(context)
                        .load(spellF)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_spellF_1);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        interface_detail.setDetailt(item);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
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
