package vn.lequan.lienminhsamsoi.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ItemFromAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemFromAdapter.IActionItemFromSelect;
import vn.lequan.lienminhsamsoi.adapter.ItemIntoAdapter;
import vn.lequan.lienminhsamsoi.adapter.ItemIntoAdapter.IActionItemSelect;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ItemsDetailDialog extends Activity implements IActionItemSelect, IActionItemFromSelect {
    private ItemFromAdapter adapterFrom;
    private ItemIntoAdapter adapterInto;
    private ImageView imgItem;
    private LinearLayout layoutFrom;
    private LinearLayout layoutInto;
    private List<Item> listFrom;
    private List<Item> listInto;
    private RecyclerView rclItemFrom;
    private RecyclerView rclItemInto;
    private TextView textName;
    private TextView tvDetail;
    private TextView tvGhepThanh;
    private TextView tvGold;
    private TextView tvthanhngangInto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        getWindow().setLayout(-1, -2);
        getWindow().getAttributes().gravity = 48;
        String itemId = getIntent().getExtras().getString(Const.ITEM_ID);
        Item item = ChampDao.getInstant(this).getItemInfor(itemId);
        String name = item.getName();
        String gold = item.getGoldTotal();
        String goldBase = item.getGoldBase();
        String from = item.getFrom();
        String into = item.getInto();
        String detail = item.getDetail();
        this.textName = (TextView) findViewById(R.id.tv_item_name);
        this.tvGold = (TextView) findViewById(R.id.tv_item_gold);
        this.tvDetail = (TextView) findViewById(R.id.tv_item_detail);
        this.imgItem = (ImageView) findViewById(R.id.img_item);
        this.layoutInto = (LinearLayout) findViewById(R.id.layout_ghepthanh);
        this.layoutFrom = (LinearLayout) findViewById(R.id.layout_gheptu);
        this.tvthanhngangInto = (TextView) findViewById(R.id.tv_thanhngang);
        this.rclItemInto = (RecyclerView) findViewById(R.id.rcl_into_item);
        this.rclItemFrom = (RecyclerView) findViewById(R.id.rcl_from_item);
        this.tvGhepThanh = (TextView) findViewById(R.id.tv_ghepthanh);
        this.tvGhepThanh.setText(ChampDao.getInstant(this).getLanguage().getBuilds());
        this.textName.setText(name);
        this.tvGold.setText(gold + "(" + goldBase + ")");
        this.listInto = ChampDao.getInstant(this).getItemIntoOrFrom(into);
        int img = Utils.getImageItem(this, itemId);
        if (img != 0) {
            Glide.with((Activity) this).load(Integer.valueOf(img)).into(this.imgItem);
        } else {
            Glide.with((Activity) this).load(Utils.getUrlImageItem(this, itemId)).error((int) R.drawable.untitled).into(this.imgItem);
        }
        this.tvDetail.setText(Html.fromHtml(detail).toString());
        this.rclItemInto.setLayoutManager(new LinearLayoutManager(this, 0, false));
        if (this.listInto == null || this.listInto.isEmpty()) {
            this.layoutInto.setVisibility(8);
            this.tvthanhngangInto.setVisibility(8);
        } else {
            this.adapterInto = new ItemIntoAdapter(this, this.listInto, this);
            this.rclItemInto.setAdapter(this.adapterInto);
        }
        this.listFrom = ChampDao.getInstant(this).getItemIntoOrFrom(from);
        this.rclItemFrom.setLayoutManager(new LinearLayoutManager(this, 0, false));
        if (this.listFrom == null || this.listFrom.isEmpty()) {
            this.layoutFrom.setVisibility(8);
            return;
        }
        this.adapterFrom = new ItemFromAdapter(this, this.listFrom, this);
        this.rclItemFrom.setAdapter(this.adapterFrom);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onItemFromSelect(String itemId) {
        setView(ChampDao.getInstant(this).getItemInfor(itemId));
    }

    public void onItemSelect(String itemId) {
        setView(ChampDao.getInstant(this).getItemInfor(itemId));
    }

    private void setView(Item item) {
        int img = Utils.getImageItem(this, item.getId());
        if (img != 0) {
            Glide.with((Activity) this).load(Integer.valueOf(img)).placeholder((int) R.drawable.untitled).error((int) R.drawable.untitled).into(this.imgItem);
        } else {
            Glide.with((Activity) this).load("http://ddragon.leagueoflegends.com/cdn/" + Utils.getCurrentVersion(this) + "/img/item/" + item.getId() + ".png").into(this.imgItem);
        }
        this.tvDetail.setText(Html.fromHtml(item.getDetail()).toString());
        this.textName.setText(item.getName());
        this.tvGold.setText(item.getGoldTotal());
        this.listInto = ChampDao.getInstant(this).getItemIntoOrFrom(item.getInto());
        this.listFrom = ChampDao.getInstant(this).getItemIntoOrFrom(item.getFrom());
        if (this.listInto == null || this.listInto.isEmpty()) {
            this.layoutInto.setVisibility(8);
            this.tvthanhngangInto.setVisibility(8);
        } else {
            if (this.adapterInto != null) {
                this.adapterInto.filter(this.listInto);
            } else {
                this.adapterInto = new ItemIntoAdapter(this, this.listInto, this);
                this.rclItemInto.setAdapter(this.adapterInto);
            }
            this.layoutInto.setVisibility(0);
            this.tvthanhngangInto.setVisibility(0);
        }
        if (this.listFrom == null || this.listFrom.isEmpty()) {
            this.layoutFrom.setVisibility(8);
            return;
        }
        if (this.adapterFrom != null) {
            this.adapterFrom.filter(this.listFrom);
        } else {
            this.adapterFrom = new ItemFromAdapter(this, this.listFrom, this);
            this.rclItemFrom.setAdapter(this.adapterFrom);
        }
        this.layoutFrom.setVisibility(0);
    }
}
