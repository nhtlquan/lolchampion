package vn.lequan.lienminhsamsoi.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.API.Face.Face_AccountID;
import vn.lequan.lienminhsamsoi.API.Model.History.Game;
import vn.lequan.lienminhsamsoi.API.Model.History.History;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.GlobalApp;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampionHistoryAdapter;
import vn.lequan.lienminhsamsoi.adapter.MatchHistoryAdapter;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.fragment.HistoryFragment;
import vn.lequan.lienminhsamsoi.models.ModelGridView;
import vn.lequan.lienminhsamsoi.models.SkinModel;

public class HistoryActivity extends AppCompatActivity {
    private int AccountID;
    private RecyclerView layout_container_history;
    private ProgressBar progress_bar;
    private ImageView img_icon_player;
    private Spinner spinner;
    List<ModelGridView> mList;
    private int accountid;
    private ChampionHistoryAdapter champHistoryAdapter;
    private MatchHistoryAdapter matchHistoryAdapter;
    private TextView txt_champion, txt_count, textview;
    private static ProgressDialog pDialog;

    class C08161 implements View.OnClickListener {
        C08161() {
        }

        public void onClick(View view) {
            HistoryActivity.this.onBackPressed();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_match_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("Name"));
        toolbar.setNavigationOnClickListener(new HistoryActivity.C08161());
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        txt_champion = (TextView) findViewById(R.id.txt_champion);
        txt_count = (TextView) findViewById(R.id.txt_count);
        textview = (TextView) findViewById(R.id.textview);
        pDialog = new ProgressDialog(this);
        img_icon_player = (ImageView) findViewById(R.id.img_icon_player);
        spinner = (Spinner) findViewById(R.id.spinner);
        try {
            this.mList = ChampDao.getInstant(this).getListModels();
        } catch (Exception e) {
            e.printStackTrace();
        }
        matchHistoryAdapter = new MatchHistoryAdapter(this, new ArrayList<Game>(), 1);
        ModelGridView modelGridView = new ModelGridView("Tất Cả", "Tất Cả", "http://i.imgur.com/qZ8QHRT.png", "Tất Cả");
        mList.add(0, modelGridView);
        champHistoryAdapter = new ChampionHistoryAdapter(this, this.mList);
        spinner.setAdapter(champHistoryAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                progress_bar.setVisibility(View.VISIBLE);
                matchHistoryAdapter.clean();
                champHistoryAdapter.setPosition(position);
                ModelGridView liveChannel = (ModelGridView) spinner.getItemAtPosition(spinner.getSelectedItemPosition());
                txt_champion.setText("Tướng: " + liveChannel.getId());
                if (liveChannel.getId().equals("all")) {
                    getData(accountid);
                }
                getDatawithChampionID(AccountID, liveChannel.getId(), liveChannel.getKey());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        GridLayoutManager layout = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        layout_container_history = (RecyclerView) findViewById(R.id.layout_container_history);
        layout_container_history.setLayoutManager(layout);
        layout_container_history.setHasFixedSize(true);

        layout_container_history.setAdapter(matchHistoryAdapter);
        AccountID = getIntent().getExtras().getInt("AccountID");
        accountid = AccountID;
        getData(AccountID);
        txt_champion.setText("Tướng: Tất cả");
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void getData(Integer accountId) {
        Debug.e(String.valueOf(accountId));
        Call<History> call = GlobalApp.getInstance().retrofit.create(Face_AccountID.class).getHistory(GlobalApp.getInstance().region, accountId, 0, 50);
        call.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                try {
                    History value = response.body();
                    List<Game> games = value.getGames().getGames();
                    Collections.reverse(games);
                    matchHistoryAdapter.addAll(games);
                    if (value.getGames().getGameCount() == 0) {
                        textview.setVisibility(View.VISIBLE);
                    } else {
                        textview.setVisibility(View.GONE);
                    }
                    txt_count.setText("Số trận: " + String.valueOf(value.getGames().getGameCount()));
                    progress_bar.setVisibility(View.GONE);
                    layout_container_history.scrollToPosition(0);
                } catch (Exception e) {
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }

    private void getDatawithChampionID(Integer accountId, final String name, String championID) {
        if (championID.equals("Tất Cả"))
            championID = "";
        Debug.e(String.valueOf(accountId));
        Call<History> call = GlobalApp.getInstance().retrofit.create(Face_AccountID.class).getHistoryWithChampion(GlobalApp.getInstance().region, accountId, championID, 0, 50);
        final String finalChampionID = championID;
        call.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                try {
                    matchHistoryAdapter.clean();
                    History value = response.body();
                    List<Game> games = value.getGames().getGames();
                    Collections.reverse(games);
                    if (value.getGames().getGameCount() == 0) {
                        textview.setVisibility(View.VISIBLE);
                    } else {
                        textview.setVisibility(View.GONE);
                    }
                    matchHistoryAdapter.addAll(games);
                    txt_count.setText("Số trận: " + String.valueOf(value.getGames().getGameCount()));
                    progress_bar.setVisibility(View.GONE);
                    List<SkinModel> skinModels = ChampDao.getInstant(getApplicationContext()).getLinkSkin(name);
                    Glide.with(getApplicationContext()).load("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + name + "_0.jpg").diskCacheStrategy(DiskCacheStrategy.ALL).placeholder((int) R.drawable.holder).error((int) R.drawable.holder).into(img_icon_player);
                    Debug.e("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + name + "_0.jpg");
                    layout_container_history.scrollToPosition(0);
                    HistoryFragment.closeDialog();
                } catch (Exception e) {
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }


}
