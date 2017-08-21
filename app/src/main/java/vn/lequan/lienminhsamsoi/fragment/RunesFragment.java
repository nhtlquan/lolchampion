package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.RuneListAdapter;
import vn.lequan.lienminhsamsoi.adapter.RuneListAdapter.IRunesSelect;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Runes;
import vn.lequan.lienminhsamsoi.ultis.SpacesItemDecoration;
import java.util.List;

public class RunesFragment extends Fragment implements IRunesSelect {
    static final /* synthetic */ boolean $assertionsDisabled = (!RunesFragment.class.desiredAssertionStatus());
    private String SQLQuery = "SELECT * FROM runes WHERE tier = '3'";
    private Activity activity;
    private RuneListAdapter adapter;
    private List<Runes> mList;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_runes, container, false);
        ((AppCompatActivity) this.activity).getSupportActionBar().setTitle(ChampDao.getInstant(this.activity).getLanguage().getCategoryRune());
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rcl_list_rune);
        LayoutManager manager = new LinearLayoutManager(this.activity, 1, false);
        if ($assertionsDisabled || recyclerView != null) {
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.spacing1)));
            try {
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.adapter = new RuneListAdapter(this.activity, this.mList, this);
            recyclerView.setAdapter(this.adapter);
            setHasOptionsMenu(true);
            return v;
        }
        throw new AssertionError();
    }

    public void onRunesSelected(View v, Runes itemId) {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_runes_fragment, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_all:
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery, null);
                this.adapter.filter(this.mList);
                item.setChecked(true);
                break;
            case R.id.item_rune_red:
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery + " AND type = 'red'", null);
                this.adapter.filter(this.mList);
                item.setChecked(true);
                break;
            case R.id.item_rune_yellow:
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery + " AND type = 'yellow'", null);
                this.adapter.filter(this.mList);
                item.setChecked(true);
                break;
            case R.id.item_rune_blue:
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery + " AND type = 'blue'", null);
                this.adapter.filter(this.mList);
                item.setChecked(true);
                break;
            case R.id.item_rune_purple:
                this.mList = ChampDao.getInstant(this.activity).getListRunes(this.SQLQuery + " AND type = 'black'", null);
                this.adapter.filter(this.mList);
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }
}
