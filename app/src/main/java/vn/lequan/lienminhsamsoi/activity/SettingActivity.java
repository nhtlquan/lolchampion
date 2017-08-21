package vn.lequan.lienminhsamsoi.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.UpdateActivity;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.LanguageData;
import vn.lequan.lienminhsamsoi.services.UpdateGuildeService;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class SettingActivity extends AppCompatActivity implements OnClickListener {
    private TextView tvAutoupdate;
    private TextView tvInfor;
    private TextView tvLanguage;
    private TextView tvNotifi;
    private TextView tvSubUpdatedata;
    private TextView tvSubnottifi;
    private TextView tvUpdateData;

    class C08161 implements OnClickListener {
        C08161() {
        }

        public void onClick(View view) {
            SettingActivity.this.onBackPressed();
        }
    }

    class C08172 implements OnCheckedChangeListener {
        C08172() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
            if (isCheck) {
                Utils.setAutoUpdate(SettingActivity.this, true);
            } else {
                Utils.setAutoUpdate(SettingActivity.this, false);
            }
        }
    }

    class C08183 implements OnCheckedChangeListener {
        C08183() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                Utils.setShowNotification(SettingActivity.this, true);
            } else {
                Utils.setShowNotification(SettingActivity.this, false);
            }
        }
    }

    class C08205 implements OnKeyListener {
        C08205() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_setting);
        View itemLanguage = findViewById(R.id.item_language);
        View itemResetDatabase = findViewById(R.id.item_infomation);
        View itemDownloadData = findViewById(R.id.item_download_data);
        this.tvLanguage = (TextView) findViewById(R.id.language);
        this.tvNotifi = (TextView) findViewById(R.id.tv_notification);
        this.tvSubnottifi = (TextView) findViewById(R.id.sub_notification);
        this.tvAutoupdate = (TextView) findViewById(R.id.tv_auto_update);
        this.tvUpdateData = (TextView) findViewById(R.id.tv_download_data);
        this.tvSubUpdatedata = (TextView) findViewById(R.id.sub_tv_download_data);
        this.tvInfor = (TextView) findViewById(R.id.resetName);
        this.tvLanguage.setText(ChampDao.getInstant(this).getLanguage().getLanguage());
        if (!Utils.getLanguageCode(this).equals("vn_VN")) {
            this.tvNotifi.setText("Notification");
            this.tvSubnottifi.setText("Notification when updates");
            this.tvAutoupdate.setText("Auto update database");
            this.tvUpdateData.setText("Update data");
            this.tvSubUpdatedata.setText("Download all tutorial offline");
            this.tvInfor.setText("Infomation");
        }
        TextView tvSubLanguage = (TextView) findViewById(R.id.sub_language);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new C08161());
        itemLanguage.setOnClickListener(this);
        itemResetDatabase.setOnClickListener(this);
        itemDownloadData.setOnClickListener(this);
        String languageCode = Utils.getLanguageCode(this);
        for (LanguageData data : LanguageData.values()) {
            if (data.getCode().equals(languageCode)) {
                tvSubLanguage.setText(data.getName());
            }
        }
        setUpCheckboxAutoUpdate();
        setUpSwicthNotification();
    }

    private void setUpCheckboxAutoUpdate() {
        CheckBox chkAutoUpdate = (CheckBox) findViewById(R.id.chk_auto_update);
        if (Utils.getAutoUpdate(this)) {
            chkAutoUpdate.setChecked(true);
        } else {
            chkAutoUpdate.setChecked(false);
        }
        chkAutoUpdate.setOnCheckedChangeListener(new C08172());
    }

    private void setUpSwicthNotification() {
        Switch switchNotification = (Switch) findViewById(R.id.switch_notification);
        if (Utils.getShowNotification(this)) {
            switchNotification.setChecked(true);
        } else {
            switchNotification.setChecked(false);
        }
        switchNotification.setOnCheckedChangeListener(new C08183());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_language:
                showDialogChoiceLanguage();
                return;
            case R.id.item_download_data:
                if (Utils.isNetworkAvailable(this)) {
                    startService(new Intent(this, UpdateGuildeService.class));
                    return;
                } else {
                    Toast.makeText(this, "KHông có kết nối internet!", 0).show();
                    return;
                }
            case R.id.item_infomation:
                startActivity(new Intent(this, AboutActivity.class));
                return;
            default:
                return;
        }
    }

    private void showDialogWaring() {
        new Builder(this).setTitle((CharSequence) "No internet connection").setMessage((CharSequence) "Please connect to wifi or mobile network and try again.").setPositiveButton((CharSequence) "OK", null).show();
    }

    private void showDialogChoiceLanguage() {
        final LanguageData[] datas = LanguageData.values();
        CharSequence[] items = new CharSequence[datas.length];
        for (int i = 0; i < datas.length; i++) {
            items[i] = datas[i].getName();
        }
        Builder builder = new Builder(this, R.style.AlertDialogCustom);
        builder.setTitle((CharSequence) "Language...");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int position) {
                Utils.setLanguageCode(SettingActivity.this, datas[position].getCode());
                SettingActivity.this.getSharedPreferences(Const.MY_PREFS_NAME, 0).edit().putBoolean("isFirstRun", true).apply();
                if (Utils.isNetworkAvailable(SettingActivity.this)) {
                    Intent i = new Intent(SettingActivity.this, UpdateActivity.class);
                    i.addFlags(268468224);
                    SettingActivity.this.startActivity(i);
                    SettingActivity.this.finish();
                    return;
                }
                SettingActivity.this.showDialogWaring();
            }
        });
        AlertDialog myAlertDialog = builder.create();
        myAlertDialog.show();
        myAlertDialog.setOnKeyListener(new C08205());
    }
}
