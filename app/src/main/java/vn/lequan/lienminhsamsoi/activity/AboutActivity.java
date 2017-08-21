package vn.lequan.lienminhsamsoi.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.SystemInfo;

public class AboutActivity extends AppCompatActivity implements OnClickListener {

    class C08071 implements OnClickListener {
        C08071() {
        }

        public void onClick(View view) {
            AboutActivity.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Thông tin");
        toolbar.setNavigationOnClickListener(new C08071());
        try {
            initView();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initView() throws NameNotFoundException {
        TextView versionApp = (TextView) findViewById(R.id.sub_version_app);
        TextView versionDatabase = (TextView) findViewById(R.id.sub_version_database);
        TextView lastUpdate = (TextView) findViewById(R.id.sub_last_update);
        View ykienDongGop = findViewById(R.id.ykien_donggop);
        String version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        SystemInfo systemInfo = ChampDao.getInstant(this).getSystemInfor();
        String versionData = systemInfo.getVersion();
        String timeUpdate = systemInfo.getUpdateTime();
        versionApp.setText(version);
        versionDatabase.setText(versionData);
        lastUpdate.setText(timeUpdate);
        ykienDongGop.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ykien_donggop:
                sendEmailFeedback();
                return;
            default:
                return;
        }
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void sendEmailFeedback() {
        try {
            Intent gmail = new Intent("android.intent.action.VIEW");
            gmail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
            gmail.putExtra("android.intent.extra.EMAIL", new String[]{"nguyentank4@gmail.com"});
            gmail.putExtra("android.intent.extra.SUBJECT", "[LOLChampion] Feedback");
            gmail.setType("plain/text");
            gmail.putExtra("android.intent.extra.TEXT", "");
            startActivity(gmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
