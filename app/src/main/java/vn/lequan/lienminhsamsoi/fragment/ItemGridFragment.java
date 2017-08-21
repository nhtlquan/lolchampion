package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ItemGridAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemListAdapter.IActionItemSelect;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.SQLConst;
import vn.lequan.lienminhsamsoi.dialog.ItemsDetailDialog;
import vn.lequan.lienminhsamsoi.ultis.Const;

public class ItemGridFragment extends Fragment implements IActionItemSelect {
    public static ItemGridAdapter adapter;
    public static GridView gridView;
    private static ItemGridFragment instant = new ItemGridFragment();
    private Activity activity;

    public static ItemGridFragment getInstance() {
        return instant;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid_item, container, false);
        gridView = (GridView) v.findViewById(R.id.grv_item);
        adapter = new ItemGridAdapter(this.activity, ChampDao.getInstant(this.activity).getListItem(SQLConst.SQL_SELECT_LIST_ITEM, Const.MAP_SUMMONER_RIFT), this);
        gridView.setAdapter(adapter);
        return v;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }

    public void onItemSelect(String itemId) {
        Intent intent = new Intent(this.activity, ItemsDetailDialog.class);
        intent.putExtra(Const.ITEM_ID, itemId);
        startActivity(intent);
    }
}
