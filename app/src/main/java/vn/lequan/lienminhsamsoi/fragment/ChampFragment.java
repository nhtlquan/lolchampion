package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import vn.lequan.lienminhsamsoi.App;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.ChampionsDetailActivity;
import vn.lequan.lienminhsamsoi.adapter.ChampAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampAdapter.IActionClick;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.models.ModelGridView;
import vn.lequan.lienminhsamsoi.ultis.Const;

public class ChampFragment extends Fragment implements IActionClick {
    private Activity activity;
    private ChampAdapter adapter;
    private List<ModelGridView> list;
    List<ModelGridView> mList;
    private ProgressBar progress_bar;
    private static ProgressDialog pDialog;

    class C14751 implements OnQueryTextListener {
        C14751() {
        }

        public boolean onQueryTextSubmit(String query) {
            return true;
        }

        public boolean onQueryTextChange(String newText) {
            ChampFragment.this.list = ChampDao.getInstant(ChampFragment.this.activity).searchChampion(newText);
            ChampFragment.this.adapter.filter(ChampFragment.this.list);
            return false;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid_champions, container, false);
        ((AppCompatActivity) this.activity).getSupportActionBar().setTitle(ChampDao.getInstant(this.activity).getLanguage().getCategoryChampion());
        try {
            this.mList = ChampDao.getInstant(this.activity).getListModels();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pDialog = new ProgressDialog(getActivity());
        progress_bar = v.findViewById(R.id.progress_bar);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rclview);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.activity, 4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        if (this.mList != null && this.mList.size() > 0) {
            this.adapter = new ChampAdapter(this.mList, this.activity, this);
            recyclerView.setAdapter(this.adapter);
        }
        setHasOptionsMenu(true);
        return v;
    }

    public void onResume() {
        super.onResume();
        App.getInstance().trackScreenView("Champ Screen");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }

    public void onChampionCick(ModelGridView champion) {
        pDialog.setMessage("Vui Lòng Chờ Giây Lát....");
        pDialog.setCancelable(true);
        pDialog.show();
        Intent intent = new Intent(this.activity, ChampionsDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", champion.getName());
        bundle.putString(Const.CHAMPION_KEY, champion.getId());
        bundle.putString("KEY", champion.getKey());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public static void closeDialog(){
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menumain, menu);
        ((SearchView) menu.findItem(R.id.action_search).getActionView()).setOnQueryTextListener(new C14751());
        Language language = ChampDao.getInstant(this.activity).getLanguage();
        menu.findItem(R.id.action_all).setTitle("All");
        menu.findItem(R.id.action_xathu).setTitle(language.getMarksman());
        menu.findItem(R.id.action_satthu).setTitle(language.getAssassin());
        menu.findItem(R.id.action_dausi).setTitle(language.getFighter());
        menu.findItem(R.id.action_dodon).setTitle(language.getTank());
        menu.findItem(R.id.action_phapsu).setTitle(language.getMage());
        menu.findItem(R.id.action_hotro).setTitle(language.getSupport());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_all:
                try {
                    this.list = ChampDao.getInstant(this.activity).getListModels();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_satthu:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Assassin");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_dausi:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Fighter");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_phapsu:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Mage");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_xathu:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Marksman");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_hotro:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Support");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            case R.id.action_dodon:
                this.list = ChampDao.getInstant(this.activity).getListChampionTag("Tank");
                this.adapter.filter(this.list);
                item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
