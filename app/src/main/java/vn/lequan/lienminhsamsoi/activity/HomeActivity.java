package vn.lequan.lienminhsamsoi.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.fragment.ChampFragment;
import vn.lequan.lienminhsamsoi.fragment.HistoryFragment;
import vn.lequan.lienminhsamsoi.fragment.ItemsFragment;
import vn.lequan.lienminhsamsoi.fragment.RunesFragment;

@SuppressLint("UseSparseArrays")
public class HomeActivity extends AppCompatActivity implements
        SmartTabLayout.TabProvider  {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("LOL");
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.demo_custom_tab_icon_and_text, tab, false));
        final SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setCustomTabView(this);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("1", ChampFragment.class));
        pages.add(FragmentPagerItem.of("2", ItemsFragment.class));
        pages.add(FragmentPagerItem.of("3", RunesFragment.class));
        pages.add(FragmentPagerItem.of("4", HistoryFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);
        pager.setAdapter(adapter);
        viewPagerTab.setViewPager(pager);
    }

    @Override
    public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        Resources res = container.getContext().getResources();
        View tab = inflater.inflate(R.layout.custom_tab_icon_and_text, container, false);
        ImageView icon = (ImageView) tab.findViewById(R.id.custom_tab_icon);
        TextView icon1 = (TextView) tab.findViewById(R.id.custom_tab_text);
        switch (position) {
            case 0:
                icon.setImageDrawable(res.getDrawable(R.drawable.aatrox));
                break;
            case 1:
                icon.setImageDrawable(res.getDrawable(R.drawable.aatrox));
                break;
            case 2:
                icon.setImageDrawable(res.getDrawable(R.drawable.aatrox));
                break;
            case 3:
                icon.setImageDrawable(res.getDrawable(R.drawable.aatrox));
                break;
            default:
                throw new IllegalStateException("Invalid position: " + position);
        }
        return tab;
    }
}
