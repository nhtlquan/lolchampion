package vn.lequan.lienminhsamsoi.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.customview.TouchImageView;
import vn.lequan.lienminhsamsoi.models.SkinModel;
import vn.lequan.lienminhsamsoi.services.DownloadSkin;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class FullscreenActivity extends AppCompatActivity {
    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private static String[] PERMISSIONS_SDCARD = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUEST_SDCARD = 0;
    private static final int UI_ANIMATION_DELAY = 300;
    private TouchImageView mContentView;
    private View mControlsView;

    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_fullscreen);
        final String url = getIntent().getExtras().getString("URL");
        final String skinName = getIntent().getExtras().getString("SKIN_NAME");
        this.mControlsView = findViewById(R.id.fullscreen_content_controls);
        this.mContentView = (TouchImageView) findViewById(R.id.fullscreen_content);
        Glide.with((FragmentActivity) this).load(url).into(this.mContentView);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void download(SkinModel model) {
        if (Utils.isNetworkAvailable(this)) {
            Intent intent = new Intent(this, DownloadSkin.class);
            Bundle bundle = new Bundle();
            bundle.putString(Const.IMAGE_NAME_SKIN, model.getName());
            bundle.putString(Const.IMAGE_URL_SKIN, model.getImage());
            intent.putExtras(bundle);
            startService(intent);
            return;
        }
        Toast.makeText(this, R.string.check_internet, 0).show();
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


}
