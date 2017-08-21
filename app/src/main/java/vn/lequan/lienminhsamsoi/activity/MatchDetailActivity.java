package vn.lequan.lienminhsamsoi.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.API.Face.Face_AccountID;
import vn.lequan.lienminhsamsoi.API.Model.History.Rune;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.Cunning;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.Ferocity;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.Resolve;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.GlobalApp;
import vn.lequan.lienminhsamsoi.Interface_Detail;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampGGMasteriesAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampGGRuneAdapter;
import vn.lequan.lienminhsamsoi.adapter.MatchDetailLeftAdapter;
import vn.lequan.lienminhsamsoi.adapter.MatchDetailRightAdapter;
import vn.lequan.lienminhsamsoi.adapter.MatchHistoryAdapter;
import vn.lequan.lienminhsamsoi.championgg.Masteries;
import vn.lequan.lienminhsamsoi.championgg.Mastery;
import vn.lequan.lienminhsamsoi.championgg.Runes;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Lore;
import vn.lequan.lienminhsamsoi.models.MatchDetail.MatchDetail;
import vn.lequan.lienminhsamsoi.models.MatchDetail.MatchParticipant;
import vn.lequan.lienminhsamsoi.models.MatchDetail.Participant;
import vn.lequan.lienminhsamsoi.models.MatchDetail.ParticipantIdentity;
import vn.lequan.lienminhsamsoi.models.MatchDetail.Stats;

public class MatchDetailActivity extends AppCompatActivity {
    private String MatchID;
    private RecyclerView recycle_view_left, recycle_view_right, ngoibotro, bangbotro;
    private MatchDetailLeftAdapter matchDetailLeftAdapter;
    private MatchDetailRightAdapter matchDetailRightAdapter;
    private ChampGGRuneAdapter champGGRuneAdapter;
    private TextView tv_result_team_1, tv_result_team_2, tv_gold_team_2, tv_gold_team_1;
    private TextView tv_player_name, tv_kda, tv_champion_name, tv_creep, tv_gold;
    private ImageView img_ranked;
    private ProgressBar progress_bar;
    private int gold_team1, gold_team2;
    private ArrayList<Runes> runes = new ArrayList<Runes>();
    List<List<Ferocity>> ferocities = GlobalApp.getInstance().masteryTree.getTree().getFerocity();
    List<List<Cunning>> cunnings = GlobalApp.getInstance().masteryTree.getTree().getCunning();
    List<List<Resolve>> resolves = GlobalApp.getInstance().masteryTree.getTree().getResolve();
    List<Mastery> cuongBao = new ArrayList<>();
    List<Mastery> kheoLeo = new ArrayList<>();
    List<Mastery> kienDinh = new ArrayList<>();
    private int count_cuongbao, count_kheoLeo, count_kienDinh;
    private static ProgressDialog pDialog;

    private CircleImageView img_champion_view;

    class C08161 implements View.OnClickListener {
        C08161() {
        }

        public void onClick(View view) {
            MatchDetailActivity.this.onBackPressed();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_history_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Thông tin trận");
        pDialog = new ProgressDialog(this);
        toolbar.setNavigationOnClickListener(new MatchDetailActivity.C08161());
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        recycle_view_left = (RecyclerView) findViewById(R.id.recycle_view_left);
        recycle_view_right = (RecyclerView) findViewById(R.id.recycle_view_right);
        tv_result_team_1 = (TextView) findViewById(R.id.tv_result_team_1);
        tv_result_team_2 = (TextView) findViewById(R.id.tv_result_team_2);
        tv_gold_team_2 = (TextView) findViewById(R.id.tv_gold_team_2);
        tv_gold_team_1 = (TextView) findViewById(R.id.tv_gold_team_1);

        ngoibotro = (RecyclerView) findViewById(R.id.ngoibotro);
        champGGRuneAdapter = new ChampGGRuneAdapter(new ArrayList<Runes>(), this);
        ngoibotro.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        ngoibotro.setHasFixedSize(true);
        ngoibotro.setNestedScrollingEnabled(false);
        ngoibotro.setAdapter(champGGRuneAdapter);


        tv_player_name = (TextView) findViewById(R.id.tv_player_name);
        tv_kda = (TextView) findViewById(R.id.tv_kda);
        tv_champion_name = (TextView) findViewById(R.id.tv_champion_name);
        tv_creep = (TextView) findViewById(R.id.tv_creep);
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        img_ranked = (ImageView) findViewById(R.id.img_ranked);
        img_champion_view = (CircleImageView) findViewById(R.id.img_champion_view);

        matchDetailLeftAdapter = new MatchDetailLeftAdapter(this, new ArrayList<MatchParticipant>(), 1);
        matchDetailRightAdapter = new MatchDetailRightAdapter(this, new ArrayList<MatchParticipant>(), 1);
        recycle_view_left.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        recycle_view_left.setHasFixedSize(true);
        recycle_view_left.setNestedScrollingEnabled(false);
        matchDetailLeftAdapter.setList(new Interface_Detail() {
            @Override
            public void setDetailt(MatchParticipant matchParticipant) {
                try {
                    Stats stats = matchParticipant.getParticipants().getStats();
                    tv_player_name.setText(matchParticipant.getParticipantIdentities().getPlayer().getSummonerName());
                    String kda = stats.getKills() + "/" + stats.getDeaths() + "/" + stats.getAssists();
                    tv_kda.setText(kda);
                    Lore lore = ChampDao.getInstant(getApplicationContext()).getOverviewFromkey(String.valueOf(matchParticipant.getParticipants().getChampionId()));
                    String champion = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/champion/" + lore.getName() + ".png";
                    tv_champion_name.setText(lore.getName());
                    champion = champion.replace(" ", "");
                    Glide.with(getApplicationContext())
                            .load(champion)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .error((int) R.drawable.unchampion).into(img_champion_view);
                    tv_creep.setText(String.valueOf(stats.getTotalMinionsKilled()));
                    tv_gold.setText(String.valueOf(stats.getGoldEarned()));
                    Resources res = getResources();
                    String mDrawableName = matchParticipant.getParticipants().getHighestAchievedSeasonTier().toLowerCase();
                    int resID = res.getIdentifier(mDrawableName, "drawable", getPackageName());
                    Drawable drawable = res.getDrawable(resID);
                    img_ranked.setImageDrawable(drawable);
                    List<Rune> runeList = matchParticipant.getParticipants().getRunes();
                    runes.clear();
                    champGGRuneAdapter.clear();
                    for (Rune rune : runeList) {
                        runes.add(new Runes(ChampDao.getInstant(getApplicationContext()).getRune(getApplicationContext(), String.valueOf(rune.getRuneId())).getImage(), ChampDao.getInstant(getApplicationContext()).getRune(getApplicationContext(), String.valueOf(rune.getRuneId())).getDescription(), String.valueOf(rune.getRank())));
                    }
                    champGGRuneAdapter.addAll(runes);
                    setbangbotro(matchParticipant.getParticipants().getMasteries());
                } catch (Exception e) {
                    Debug.e(e.toString());
                    e.printStackTrace();
                }
            }
        });
        matchDetailRightAdapter.setList(new Interface_Detail() {
            @Override
            public void setDetailt(MatchParticipant matchParticipant) {
                Stats stats = matchParticipant.getParticipants().getStats();
                tv_player_name.setText(matchParticipant.getParticipantIdentities().getPlayer().getSummonerName());
                String kda = stats.getKills() + "/" + stats.getDeaths() + "/" + stats.getAssists();
                tv_kda.setText(kda);
                Lore lore = ChampDao.getInstant(getApplicationContext()).getOverviewFromkey(String.valueOf(matchParticipant.getParticipants().getChampionId()));
                String champion = "http://ddragon.leagueoflegends.com/cdn/7.13.1/img/champion/" + lore.getName() + ".png";
                tv_champion_name.setText(lore.getName());
                champion = champion.replace(" ", "");
                Glide.with(getApplicationContext())
                        .load(champion)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error((int) R.drawable.unchampion).into(img_champion_view);
                tv_creep.setText(String.valueOf(stats.getTotalMinionsKilled()));
                tv_gold.setText(String.valueOf(stats.getGoldEarned()));
                Resources res = getResources();
                String mDrawableName = matchParticipant.getParticipants().getHighestAchievedSeasonTier().toLowerCase();
                Debug.e(mDrawableName);
                int resID = res.getIdentifier(mDrawableName, "drawable", getPackageName());
                Drawable drawable = res.getDrawable(resID);
                img_ranked.setImageDrawable(drawable);
                List<Rune> runeList = matchParticipant.getParticipants().getRunes();
                runes.clear();
                champGGRuneAdapter.clear();
                for (Rune rune : runeList) {
                    runes.add(new Runes(ChampDao.getInstant(getApplicationContext()).getRune(getApplicationContext(), String.valueOf(rune.getRuneId())).getImage(), ChampDao.getInstant(getApplicationContext()).getRune(getApplicationContext(), String.valueOf(rune.getRuneId())).getDescription(), String.valueOf(rune.getRank())));
                }
                champGGRuneAdapter.addAll(runes);
                setbangbotro(matchParticipant.getParticipants().getMasteries());
            }
        });
        recycle_view_right.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        recycle_view_right.setHasFixedSize(true);
        recycle_view_right.setNestedScrollingEnabled(false);
        MatchID = getIntent().getExtras().getString("MatchID");
        getData(MatchID);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void setbangbotro(List<vn.lequan.lienminhsamsoi.models.MatchDetail.Mastery> masteryList) {
        count_cuongbao = 0;
        count_kienDinh = 0;
        count_kheoLeo = 0;
        cuongBao.clear();
        kienDinh.clear();
        kheoLeo.clear();
        for (List<Ferocity> ferocityList : ferocities) {
            for (Ferocity ferocity : ferocityList) {
                int rank = 0;
                for (vn.lequan.lienminhsamsoi.models.MatchDetail.Mastery mastery : masteryList) {
                    if (String.valueOf(mastery.getMasteryId()).equals(ferocity.getMasteryId())) {
                        rank = mastery.getRank();
                        count_cuongbao = count_cuongbao++;
                    }
                }
                cuongBao.add(new Mastery(ferocity.getMasteryId(), rank));
            }
        }
        for (List<Cunning> cunningList : cunnings) {
            for (Cunning cunning : cunningList) {
                int rank = 0;
                for (vn.lequan.lienminhsamsoi.models.MatchDetail.Mastery mastery : masteryList) {
                    if (String.valueOf(mastery.getMasteryId()).equals(cunning.getMasteryId())) {
                        rank = mastery.getRank();
                        count_kheoLeo = count_kheoLeo++;
                    }
                }
                kheoLeo.add(new Mastery(cunning.getMasteryId(), rank));

            }
        }
        for (List<Resolve> resolveList : resolves) {
            for (Resolve resolve : resolveList) {
                int rank = 0;
                for (vn.lequan.lienminhsamsoi.models.MatchDetail.Mastery mastery : masteryList) {
                    if (String.valueOf(mastery.getMasteryId()).equals(resolve.getMasteryId())) {
                        rank = mastery.getRank();
                        count_kienDinh = count_kienDinh++;

                    }
                }
                kienDinh.add(new Mastery(resolve.getMasteryId(), rank));
            }
        }
        cuongBao.add(1, new Mastery("", 0));
        cuongBao.add(7, new Mastery("", 0));
        cuongBao.add(13, new Mastery("", 0));
        kheoLeo.add(1, new Mastery("", 0));
        kheoLeo.add(7, new Mastery("", 0));
        kheoLeo.add(13, new Mastery("", 0));
        kienDinh.add(1, new Mastery("", 0));
        kienDinh.add(7, new Mastery("", 0));
        kienDinh.add(13, new Mastery("", 0));
        Masteries masteries = new Masteries(cuongBao, kheoLeo, kienDinh, count_cuongbao, count_kheoLeo, count_kienDinh);
        bangbotro = (RecyclerView) findViewById(R.id.bangbotro);
        bangbotro.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        ChampGGMasteriesAdapter adapter = new ChampGGMasteriesAdapter(masteries, this, null);
        bangbotro.setLayoutManager(linearLayoutManager);
        bangbotro.setAdapter(adapter);
    }

    private void getData(String matchID) {

        Call<MatchDetail> call = GlobalApp.getInstance().retrofit.create(Face_AccountID.class).getMatcDhetail(matchID);
        call.enqueue(new Callback<MatchDetail>() {
            @Override
            public void onResponse(Call<MatchDetail> call, Response<MatchDetail> response) {
                try {
                    MatchDetail matchDetail = response.body();
                    if (response.body().getTeams().get(0).getWin().equals("Fail")) {
                        tv_result_team_1.setText("THUA");
                        tv_result_team_1.setTextColor(getResources().getColor(R.color.holo_red_dark));
                        tv_result_team_2.setTextColor(getResources().getColor(R.color.holo_green_dark));
                        tv_result_team_2.setText("THẮNG");
                    } else {
                        tv_result_team_1.setTextColor(getResources().getColor(R.color.holo_green_dark));
                        tv_result_team_2.setTextColor(getResources().getColor(R.color.holo_red_dark));
                        tv_result_team_2.setText("THUA");
                        tv_result_team_1.setText("THẮNG");
                    }
                    ArrayList<MatchParticipant> listmatchParticipantsleft = new ArrayList<MatchParticipant>();
                    ArrayList<MatchParticipant> listmatchParticipantsright = new ArrayList<MatchParticipant>();
                    for (Participant participant : matchDetail.getParticipants()) {
                        if (participant.getTeamId() == 100) {
                            gold_team1 = gold_team1 + participant.getStats().getGoldEarned();
                            for (ParticipantIdentity participantIdentity : matchDetail.getParticipantIdentities()) {
                                if (participantIdentity.getParticipantId().equals(participant.getParticipantId())) {
                                    MatchParticipant matchParticipant = new MatchParticipant(participant, participantIdentity);
                                    listmatchParticipantsleft.add(matchParticipant);
                                }
                            }
                        }
                    }
                    tv_gold_team_1.setText(String.valueOf(gold_team1));
                    matchDetailLeftAdapter.addAll(listmatchParticipantsleft);
                    recycle_view_left.setAdapter(matchDetailLeftAdapter);
//
                    for (Participant participant : matchDetail.getParticipants()) {
                        if (participant.getTeamId() == 200) {
                            gold_team2 = gold_team2 + participant.getStats().getGoldEarned();
                            for (ParticipantIdentity participantIdentity : matchDetail.getParticipantIdentities()) {
                                if (participantIdentity.getParticipantId().equals(participant.getParticipantId())) {
                                    MatchParticipant matchParticipant = new MatchParticipant(participant, participantIdentity);
                                    listmatchParticipantsright.add(matchParticipant);
                                }
                            }
                        }
                    }
                    tv_gold_team_2.setText(String.valueOf(gold_team2));
                    matchDetailRightAdapter.addAll(listmatchParticipantsright);
                    recycle_view_right.setAdapter(matchDetailRightAdapter);
                    progress_bar.setVisibility(View.GONE);
//                    MatchHistoryAdapter.closeDialog();
                } catch (Exception e) {
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<MatchDetail> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }


}
