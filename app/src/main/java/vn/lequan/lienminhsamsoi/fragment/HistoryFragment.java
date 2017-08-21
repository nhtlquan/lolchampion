package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.lequan.lienminhsamsoi.API.Face.Face_AccountID;
import vn.lequan.lienminhsamsoi.API.Model.AccountID;
import vn.lequan.lienminhsamsoi.API.Model.History.History;
import vn.lequan.lienminhsamsoi.API.Model.History.Player;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.GlobalApp;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.HistoryActivity;
import vn.lequan.lienminhsamsoi.adapter.ItemHistoryPlayerAdapter;
import vn.lequan.lienminhsamsoi.dao.model.HistoryHome;

public class HistoryFragment extends Fragment implements SearchView.OnQueryTextListener {
    private Activity activity;
    private SearchView search_summoner;
    private ImageView img_icon_player;
    private TextView tv_name_player, tv_not_found;
    private ProgressBar progress_bar;
    private int AccountID = 0;
    private RecyclerView rcl_history;
    private String name = "";
    private String TAG = "history";
    private ItemHistoryPlayerAdapter matchHistoryAdapter;
    private ArrayList<HistoryHome> arrayList;
    private SharedPreferences sharedPrefs;
    private Gson gson;
    private int id_icon;
    private static ProgressDialog pDialog;


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_summoner, container, false);
        ((AppCompatActivity) this.activity).getSupportActionBar().setTitle("Lịch Sử");
        search_summoner = v.findViewById(R.id.search_summoner);
        img_icon_player = v.findViewById(R.id.img_icon_player);
        tv_name_player = v.findViewById(R.id.tv_name_player);
        tv_not_found = v.findViewById(R.id.tv_not_found);
        rcl_history = v.findViewById(R.id.rcl_history);
        progress_bar = v.findViewById(R.id.progress_bar);
        search_summoner.setQueryHint("Tìm Kiếm");
        search_summoner.setOnQueryTextListener(this);
        search_summoner.setMaxWidth(Integer.MAX_VALUE);
        pDialog = new ProgressDialog(getActivity());
        search_summoner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_summoner.setIconified(false);
            }
        });
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        gson = new Gson();
        String jsonnew = sharedPrefs.getString(TAG, null);
        Type type = new TypeToken<ArrayList<HistoryHome>>() {
        }.getType();
        arrayList = gson.fromJson(jsonnew, type);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 4, LinearLayoutManager.VERTICAL, true);
        rcl_history.setLayoutManager(layout);
        rcl_history.setHasFixedSize(true);
        matchHistoryAdapter = new ItemHistoryPlayerAdapter(getActivity(), new ArrayList<HistoryHome>(), 1);
        if (arrayList != null)
            matchHistoryAdapter.addAll(arrayList);
        rcl_history.setAdapter(matchHistoryAdapter);
        img_icon_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog.setMessage("Vui Lòng Chờ Giây Lát....");
                pDialog.setCancelable(true);
                pDialog.show();
                if (AccountID != 0) {
                    if (arrayList != null) {
                        arrayList.add(new HistoryHome(AccountID, name, id_icon));
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        String json = gson.toJson(arrayList);
                        editor.putString(TAG, json);
                        editor.apply();
                    } else {
                        arrayList = new ArrayList<>();
                        arrayList.add(new HistoryHome(AccountID, name, id_icon));
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        String json = gson.toJson(arrayList);
                        editor.putString(TAG, json);
                        editor.apply();
                    }
                    Intent intent = new Intent(activity, HistoryActivity.class);
                    intent.putExtra("AccountID", AccountID);
                    intent.putExtra("Name", name);
                    activity.startActivity(intent);
                }
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (arrayList != null) {
            matchHistoryAdapter.clean();
            matchHistoryAdapter.addAll(arrayList);
        }

    }

    public static void closeDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_runes_fragment, menu);
    }


    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        progress_bar.setVisibility(View.VISIBLE);
        img_icon_player.setVisibility(View.GONE);
        tv_name_player.setVisibility(View.GONE);
        getIdAccount(query);
        return false;
    }

    private void getIdAccount(String query) {
        Debug.e(query);
        Call<AccountID> call = GlobalApp.getInstance().retrofit.create(Face_AccountID.class).getAccountID(query, GlobalApp.getInstance().region);
        call.enqueue(new Callback<AccountID>() {
            @Override
            public void onResponse(Call<AccountID> call, Response<AccountID> response) {
                try {
                    AccountID value = response.body();
                    getAvatar(value.getAccountId());
                    AccountID = value.getAccountId();
                } catch (Exception e) {
                    tv_not_found.setVisibility(View.VISIBLE);
                    progress_bar.setVisibility(View.GONE);
                    img_icon_player.setVisibility(View.GONE);
                    tv_name_player.setVisibility(View.GONE);
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<AccountID> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }

    private void getAvatar(Integer accountId) {
        Debug.e(String.valueOf(accountId));
        Call<History> call = GlobalApp.getInstance().retrofit.create(Face_AccountID.class).getHistory(GlobalApp.getInstance().region, accountId, 0, 1);
        call.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                progress_bar.setVisibility(View.GONE);
                img_icon_player.setVisibility(View.VISIBLE);
                tv_name_player.setVisibility(View.VISIBLE);

                try {
                    History value = response.body();
                    Player player = value.getGames().getGames().get(0).getParticipantIdentities().get(0).getPlayer();
                    tv_name_player.setText(player.getSummonerName());
                    id_icon = player.getProfileIcon();
                    Glide.with(activity)
                            .load("http://ddragon.leagueoflegends.com/cdn/7.13.1/img/profileicon/" + player.getProfileIcon() + ".png")
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(img_icon_player);
                    name = player.getSummonerName();
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

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
