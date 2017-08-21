package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ItemListAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemListAdapter.IActionItemSelect;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.SQLConst;
import vn.lequan.lienminhsamsoi.dialog.ItemsDetailDialog;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Const;

public class ItemListFragment extends Fragment implements IActionItemSelect {
    public static ItemListAdapter adapter;
    private static ItemListFragment instant = new ItemListFragment();
    public static RecyclerView listView;
    private Activity activity;

    public static ItemListFragment getInstance() {
        return instant;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_item, container, false);
        listView = (RecyclerView) v.findViewById(R.id.lv_item);
        List<Item> mList = ChampDao.getInstant(this.activity).getListItem(SQLConst.SQL_SELECT_LIST_ITEM, Const.MAP_SUMMONER_RIFT);
        LinearLayoutManager llm = new LinearLayoutManager(this.activity);
        llm.setOrientation(1);
        listView.setLayoutManager(llm);
        adapter = new ItemListAdapter(this.activity, mList, this);
        listView.setAdapter(adapter);
        Debug.e(String.valueOf(adapter.getItemCount()));
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
