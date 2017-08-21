package vn.lequan.lienminhsamsoi.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampGGMasteriesAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampGGMasteryAdapter.IClickMastery;
import vn.lequan.lienminhsamsoi.adapter.ChampGGRuneAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemIntoAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemIntoAdapter.IActionItemSelect;
import vn.lequan.lienminhsamsoi.adapter.SpellOrderAdapter;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.championgg.ItemFrequent;
import vn.lequan.lienminhsamsoi.championgg.Masteries;
import vn.lequan.lienminhsamsoi.championgg.Mastery;
import vn.lequan.lienminhsamsoi.championgg.Runes;
import vn.lequan.lienminhsamsoi.dialog.ItemsDetailDialog;
import vn.lequan.lienminhsamsoi.dialog.MasteryDetailDialog;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ChampBuildChildFragment extends BaseFragment implements IActionItemSelect, IClickMastery {
    private ImageView imgSpellD;
    private ImageView imgSpellF;
    private ImageView imgTricket;
    private RecyclerView rclCoreItem;
    private RecyclerView rclRunes;
    private RecyclerView rclSpellOrder;
    private RecyclerView rclStartItem;
    private RecyclerView recyclerView;
    private TextView titleTrangbi;
    private TextView tvCongskill;
    private TextView tvCoreItemTitle;
    private TextView tvNgocbotro;
    private TextView tvStartItemTitle;
    private TextView tvTitleSpell;

    public int getLayoutId() {
        return R.layout.fragment_champ_build_child;
    }

    public void initView(View v) {
        this.recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        this.rclStartItem = (RecyclerView) v.findViewById(R.id.rcl_start_build);
        this.tvStartItemTitle = (TextView) v.findViewById(R.id.tv_start_item_build);
        this.imgTricket = (ImageView) v.findViewById(R.id.img_item);
        this.imgSpellD = (ImageView) v.findViewById(R.id.img_spellD);
        this.imgSpellF = (ImageView) v.findViewById(R.id.img_spellF);
        this.tvTitleSpell = (TextView) v.findViewById(R.id.title_phepbotro);
        this.rclCoreItem = (RecyclerView) v.findViewById(R.id.rcl_core_build);
        this.tvCoreItemTitle = (TextView) v.findViewById(R.id.tv_core_item_build);
        this.rclRunes = (RecyclerView) v.findViewById(R.id.rcl_build_runes);
        this.rclSpellOrder = (RecyclerView) v.findViewById(R.id.rcl_spell_order);
        this.titleTrangbi = (TextView) v.findViewById(R.id.title_trangbi);
        this.tvNgocbotro = (TextView) v.findViewById(R.id.tv_ngocbotro);
        this.tvCongskill = (TextView) v.findViewById(R.id.tv_congskill);
    }

    public void initAction() {
    }

    public void initData() {
        Debug.e(getArguments().getString("html"));
        initChampionGG((ItemFrequent) new Gson().fromJson(getArguments().getString("html"), ItemFrequent.class));
        initAds();
    }

    private void initChampionGG(ItemFrequent itemFrequent) {
        this.tvNgocbotro.setText(this.language.getCategoryRune().toUpperCase());
        this.titleTrangbi.setText(this.language.getCategoryItem().toUpperCase() + " & " + this.language.getCategorySummoner().toUpperCase());
        this.tvCongskill.setText("UP SKILL");
        List<String> lstSpell = itemFrequent.getListSummoner();
        if (lstSpell != null) {
            this.tvTitleSpell.setText(String.format("%s:", new Object[]{this.language.getCategorySummoner()}));
            String urlSpellD = Utils.getUrlSpell(this.activity, (String) lstSpell.get(0));
            String urlSpellF = Utils.getUrlSpell(this.activity, (String) lstSpell.get(1));
            Glide.with(this.activity).load(urlSpellD).into(this.imgSpellD);
            Glide.with(this.activity).load(urlSpellF).into(this.imgSpellF);
        }
        List<String> lstStartBuild = itemFrequent.getListStartBuild();
        if (lstStartBuild.size() != 0) {
            this.tvStartItemTitle.setText(this.language.getRecommendedStarting() + ":");
            List<Item> lstItemStart = new ArrayList();
            for (String start : lstStartBuild) {
                Item item = new Item();
                item.setId(start);
                lstItemStart.add(item);
            }
            ItemIntoAdapter adapterStart = new ItemIntoAdapter(this.activity, lstItemStart, this);
            this.rclStartItem.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
            this.rclStartItem.setNestedScrollingEnabled(false);
            this.rclStartItem.setAdapter(adapterStart);
        }
        String trinketId = itemFrequent.getTrinketStats();
        Glide.with(this.activity).load(Integer.valueOf(Utils.getImageItem(this.activity, trinketId))).into(this.imgTricket);
        final String str = trinketId;
        this.imgTricket.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChampBuildChildFragment.this.activity, ItemsDetailDialog.class);
                intent.putExtra(Const.ITEM_ID, str);
                ChampBuildChildFragment.this.startActivity(intent);
            }
        });
        List<String> lstCoreBuild = itemFrequent.getListCoreBuild();
        if (lstCoreBuild.size() != 0) {
            this.tvCoreItemTitle.setText(this.language.getRecommendedItems() + ":");
            List<Item> lstItem = new ArrayList();
            for (String core : lstCoreBuild) {
                Item item = new Item();
                item.setId(core);
                lstItem.add(item);
            }
            ItemIntoAdapter adapters = new ItemIntoAdapter(this.activity, lstItem, this);
            this.rclCoreItem.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
            this.rclCoreItem.setNestedScrollingEnabled(false);
            this.rclCoreItem.setAdapter(adapters);
        }
        List<Runes> listRunes = itemFrequent.getListRunes();
        if (listRunes.size() != 0) {
            Adapter champGGRuneAdapter = new ChampGGRuneAdapter(listRunes, this.activity);
            this.rclRunes.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
            this.rclRunes.setNestedScrollingEnabled(false);
            this.rclRunes.setAdapter(champGGRuneAdapter);
        }
        SpellOrderAdapter adapterSpell = new SpellOrderAdapter(itemFrequent.getSpellOrder(), this.activity);
        this.rclSpellOrder.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        this.rclSpellOrder.setAdapter(adapterSpell);
        Masteries masteries = itemFrequent.getMasteries();
        for (Mastery mastery : itemFrequent.getMasteries().getCuongBao()) {
            Debug.e(mastery.getId() + "Point" + String.valueOf(mastery.getPoint()));
        }
        Debug.e(String.valueOf(itemFrequent.getMasteries().getCuongBao().size()));
        LayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 0, false);
        ChampGGMasteriesAdapter adapter = new ChampGGMasteriesAdapter(masteries, this.activity, this);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(adapter);
    }

    public void onClickMastery(Mastery mastery) {
        Debug.e(mastery.getId());
        Intent intent = new Intent(this.activity, MasteryDetailDialog.class);
        intent.putExtra(Const.ITEM_ID, mastery.getId());
        startActivity(intent);
    }

    public void onItemSelect(String itemId) {
        Intent intent = new Intent(this.activity, ItemsDetailDialog.class);
        intent.putExtra(Const.ITEM_ID, itemId);
        startActivity(intent);
    }
}
