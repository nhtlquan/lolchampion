package vn.lequan.lienminhsamsoi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.API.Face.Face_AccountID;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.MasteryTree;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.dao.model.Mastery;
import vn.lequan.lienminhsamsoi.fragment.ChampFragment;
import vn.lequan.lienminhsamsoi.fragment.HistoryFragment;
import vn.lequan.lienminhsamsoi.fragment.ItemsFragment;
import vn.lequan.lienminhsamsoi.fragment.NewsFragment;
import vn.lequan.lienminhsamsoi.fragment.RunesFragment;
import vn.lequan.lienminhsamsoi.http.GetDataChamp;
import vn.lequan.lienminhsamsoi.services.UpdateGuildeService;
import vn.lequan.lienminhsamsoi.services.UpdateService;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import vn.lequan.lienminhsamsoi.utils.DialogExit;

public class MainActivity extends AppCompatActivity implements SmartTabLayout.TabProvider, OnNavigationItemSelectedListener {
    static final /* synthetic */ boolean $assertionsDisabled = (!MainActivity.class.desiredAssertionStatus());
    private String currentVersion;
    private FragmentManager fm = getSupportFragmentManager();
    private Language language;
    private View mLayout;
    private String newVersion;
    private Toolbar toolbar;
    private boolean doubleBackToExitPressedOnce;
    public static SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "DANHGIA";
    int PRIVATE_MODE = 0;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    class C07991 implements OnClickListener {
        C07991() {
        }

        public void onClick(View view) {
            MainActivity.this.startUpdateService();
            MainActivity.this.finish();
        }
    }

    class C08002 implements OnClickListener {
        C08002() {
        }

        public void onClick(View view) {
            MainActivity.this.startUpdateService();
        }
    }

    class C08013 implements OnClickListener {
        C08013() {
        }

        public void onClick(View view) {
            if (Utils.isNetworkAvailable(MainActivity.this)) {
                MainActivity.this.startService(new Intent(MainActivity.this, UpdateGuildeService.class));
                return;
            }
            Toast.makeText(MainActivity.this, "KHông có kết nối internet!", 0).show();
        }
    }

    class CheckUpdateDatabase extends AsyncTask<Void, Void, Void> {
        CheckUpdateDatabase() {
        }

        protected Void doInBackground(Void... voids) {
            try {
                MainActivity.this.newVersion = new GetDataChamp().getVersion();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (MainActivity.this.newVersion != null) {
                Utils.setNewVersion(MainActivity.this, MainActivity.this.newVersion);
                if (!MainActivity.this.currentVersion.equals(MainActivity.this.newVersion)) {
                    if (Utils.getAutoUpdate(MainActivity.this)) {
                        MainActivity.this.startUpdateService();
                    } else {
                        MainActivity.this.showSnackbarUpdate();
                    }
                }
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences(Const.MY_PREFS_NAME, 0);
        if (prefs.getBoolean("isFirstRun", true)) {
            prefs.edit().putBoolean("isFirstRun", false).apply();
        }
        setContentView((int) R.layout.activity_main);
        sharedpreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, PRIVATE_MODE);
        this.mLayout = findViewById(R.id.coordinator_layout);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.language = ChampDao.getInstant(this).getLanguage();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Quan");
        List<Mastery> item = ChampDao.getInstant(this).getMastery();
        Debug.e(item.get(14).getName());
        Debug.e(String.valueOf(item.size()));
        try {
            this.currentVersion = ChampDao.getInstant(this).getSystemInfor().getVersion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Utils.isNetworkAvailable(this)) {
            new CheckUpdateDatabase().execute(new Void[0]);
        }
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.demo_custom_tab_icon_and_text, tab, false));
        final SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setCustomTabView(this);
        viewPagerTab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("1", ChampFragment.class));
        pages.add(FragmentPagerItem.of("2", NewsFragment.class));
        pages.add(FragmentPagerItem.of("3", ItemsFragment.class));
        pages.add(FragmentPagerItem.of("4", HistoryFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);
        pager.setAdapter(adapter);
        viewPagerTab.setViewPager(pager);
//        setUpNavigationDrawer();
        getMasteryTree();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Process.killProcess(Process.myPid());
            return;
        }
        if (sharedpreferences.getBoolean("check", true)) {
            DialogExit dialogSetting = new DialogExit();
            if (!dialogSetting.isHidden()) {
                dialogSetting.show(getSupportFragmentManager(), DialogExit.class.getSimpleName());
                return;
            }
        }
        this.doubleBackToExitPressedOnce = true;
        Debug.showAlert(this, "Nhấn back 2 lần để thoát!");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void getMasteryTree() {
        Call<MasteryTree> call = GlobalApp.getInstance().retrofit1.create(Face_AccountID.class).getListMastery(currentVersion);
        call.enqueue(new Callback<MasteryTree>() {
            @Override
            public void onResponse(Call<MasteryTree> call, Response<MasteryTree> response) {
                try {
                    GlobalApp.getInstance().masteryTree = response.body();
                } catch (Exception e) {
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<MasteryTree> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }

//    private void setUpNavigationDrawer() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        if ($assertionsDisabled || drawer != null) {
//            drawer.setDrawerListener(toggle);
//            toggle.syncState();
//            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//            if ($assertionsDisabled || navigationView != null) {
//                navigationView.setNavigationItemSelectedListener(this);
//                ((TextView) navigationView.getHeaderView(0).findViewById(R.id.header_textView)).setText("current version " + this.currentVersion);
//                Menu menuNav = navigationView.getMenu();
//                menuNav.findItem(R.id.nav_champion).setTitle(this.language.getCategoryChampion());
//                menuNav.findItem(R.id.nav_items).setTitle(this.language.getCategoryItem());
//                menuNav.findItem(R.id.nav_runes).setTitle(this.language.getCategoryRune());
//                menuNav.findItem(R.id.nav_history).setTitle("Lịch Sử");
//
//                return;
//            }
//            throw new AssertionError();
//        }
//        throw new AssertionError();
//    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        Resources res = container.getContext().getResources();
        View tab = inflater.inflate(R.layout.custom_tab_icon_and_text, container, false);
        ImageView icon = (ImageView) tab.findViewById(R.id.custom_tab_icon);
        TextView title = (TextView) tab.findViewById(R.id.custom_tab_text);
        switch (position) {
            case 0:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_local_library_white_24dp));
                title.setText("Tướng");
                break;
            case 1:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_whatshot_white_24dp));
                title.setText("Tin Tức");
                break;
            case 2:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_gavel_white_24dp));
                title.setText("Trang Bị");
                break;
            case 3:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_history_white_24dp));
                title.setText("Lịch Sử");
                break;
            default:
                throw new IllegalStateException("Invalid position: " + position);
        }
        return tab;
    }

    private void startUpdateService() {
        startService(new Intent(this, UpdateService.class));
    }

    private void showSnackbarError() {
        Snackbar.make(this.mLayout, (CharSequence) "Database error..", -2).setAction((CharSequence) "RESTART", new C07991()).show();
    }

    private void showSnackbarUpdate() {
        Snackbar.make(this.mLayout, "Có bản cập nhật mới " + this.newVersion, -2).setAction((CharSequence) "CẬP NHẬT", new C08002()).show();
    }

    private void showSnackbarUPdateData() {
        Snackbar.make(this.mLayout, (CharSequence) "Tải về tất cả hướng dẫn offline?", -2).setAction((CharSequence) "TẢI XUỐNG", new C08013()).show();
    }
}
