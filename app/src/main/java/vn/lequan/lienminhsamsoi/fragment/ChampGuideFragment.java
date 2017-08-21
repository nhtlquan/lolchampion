package vn.lequan.lienminhsamsoi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import vn.lequan.lienminhsamsoi.App;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.ChampionsDetailActivity;
import vn.lequan.lienminhsamsoi.adapter.ChampCounterAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampCounterAdapter.IItemClick;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.ModelGridView;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ChampGuideFragment extends BaseFragment implements IItemClick {
    private CardView cardStrong;
    private CardView cardWeak;
    private GridView gridStrong;
    private GridView gridWeak;
    private List<String> listAllyTips = null;
    private List<String> listEnemyTips = null;
    private String text4me = "";
    private String text4you = "";
    private TextView tvGuideCounter;
    private TextView tvGuideTips;

    public int getLayoutId() {
        return R.layout.fragment_guild;
    }

    public void initView(View v) {
        TextView titleA = (TextView) v.findViewById(R.id.a);
        TextView tvTitleTips = (TextView) v.findViewById(R.id.aa);
        TextView tvTitleCounter = (TextView) v.findViewById(R.id.bb);
        this.tvGuideTips = (TextView) v.findViewById(R.id.guide_tv_4me);
        TextView titleB = (TextView) v.findViewById(R.id.b);
        this.tvGuideCounter = (TextView) v.findViewById(R.id.guide_tv_4you);
        this.gridWeak = (GridView) v.findViewById(R.id.gridview_weak);
        this.gridStrong = (GridView) v.findViewById(R.id.gridview_strong);
        this.cardWeak = (CardView) v.findViewById(R.id.card_weak);
        this.cardStrong = (CardView) v.findViewById(R.id.card_strong);
        String champName = this.activity.getIntent().getExtras().getString("name");
        titleA.setText(new StringBuilder(this.language.getPlayingAs() + " ").append(champName).append(":").toString().toUpperCase());
        titleB.setText(new StringBuilder(this.language.getPlayingAgainst() + " ").append(champName).append(":").toString().toUpperCase());
        if (!Utils.getLanguageCode(this.activity).equals("vn_VN")) {
            tvTitleTips.setText("WEAK AGAINST");
            tvTitleCounter.setText("STRONG AGAINST");
        }
    }

    public void initAction() {
        initAds();
    }

    public void onResume() {
        super.onResume();
        App.getInstance().trackScreenView("Guide Screen");
    }

    public void initData() {
        ChampDao championDao = ChampDao.getInstant(this.activity);
        List<ModelGridView> listWeak = championDao.getWeakChampion(this.CHAMP_ID, "weakAgainst");
        if (listWeak == null || listWeak.size() == 0) {
            this.cardWeak.setVisibility(8);
        } else {
            this.gridWeak.setAdapter(new ChampCounterAdapter(this.activity, listWeak, this));
            this.gridWeak.setVisibility(0);
        }
        List<ModelGridView> listStrong = championDao.getWeakChampion(this.CHAMP_ID, "strongAgainst");
        if (listStrong == null || listStrong.size() == 0) {
            this.cardStrong.setVisibility(8);
        } else {
            this.gridStrong.setAdapter(new ChampCounterAdapter(this.activity, listStrong, this));
            this.cardStrong.setVisibility(0);
        }
        if (this.listAllyTips == null) {
            this.listAllyTips = championDao.getTips(this.CHAMP_ID, "allytips");
            for (int j = 0; j < this.listAllyTips.size(); j++) {
                this.text4me += ((String) this.listAllyTips.get(j)) + "<br><br>";
            }
        }
        this.tvGuideTips.setText(Html.fromHtml(this.text4me));
        if (this.listEnemyTips == null) {
            this.listEnemyTips = championDao.getTips(this.CHAMP_ID, "enemytips");
            for (int i = 0; i < this.listEnemyTips.size(); i++) {
                this.text4you += ((String) this.listEnemyTips.get(i)) + "<br><br>";
            }
        }
        this.tvGuideCounter.setText(Html.fromHtml(this.text4you));
    }

    public void onChampClick(ModelGridView champion) {
        Intent intent = new Intent(this.activity, ChampionsDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("KEY", champion.getKey());
        bundle.putString(Const.CHAMPION_KEY, champion.getId());
        bundle.putString("name", champion.getName());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
