package vn.lequan.lienminhsamsoi.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.LinkedHashMap;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.TabFragmentAdapter;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.fragment.ChampBuildFragment;
import vn.lequan.lienminhsamsoi.fragment.ChampGuideFragment;
import vn.lequan.lienminhsamsoi.fragment.ChampOverviewFragment;
import vn.lequan.lienminhsamsoi.fragment.ChampSkinFagment;
import vn.lequan.lienminhsamsoi.fragment.ChampSpellFragment;

public class ChampionsDetailActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = (!ChampionsDetailActivity.class.desiredAssertionStatus());


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_info);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.demo_custom_tab_icon_and_notification_mark_bottom, tab, false));
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        LinkedHashMap<Integer, Fragment> mapFragments; mapFragments = new LinkedHashMap<Integer, Fragment>();
        Language language = ChampDao.getInstant(this).getLanguage();
        mapFragments.put(R.string.tongquan, new ChampOverviewFragment());
        mapFragments.put(R.string.kynang, new ChampSpellFragment());
        mapFragments.put(R.string.cachchoi, new ChampBuildFragment());
        mapFragments.put(R.string.huongdan, new ChampGuideFragment());
        mapFragments.put(R.string.skin, new ChampSkinFagment());
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(this, getSupportFragmentManager(),
                mapFragments);
        pager.setAdapter(tabFragmentAdapter);
        viewPagerTab.setViewPager(pager);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_infor_champion, menu);
        return true;
    }
}
