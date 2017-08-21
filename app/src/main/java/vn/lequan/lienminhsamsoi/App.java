package vn.lequan.lienminhsamsoi;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.multidex.MultiDex;
import android.util.Base64;
import android.util.Log;

import com.clough.android.androiddbviewer.ADBVApplication;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import vn.lequan.lienminhsamsoi.dao.DBHelper;
import vn.lequan.lienminhsamsoi.ultis.GAUtils;
import vn.lequan.lienminhsamsoi.ultis.GAUtils.Target;

public class App extends ADBVApplication {
    public static final String TAG = App.class.getSimpleName();
    private static App mInstance;

    public SQLiteOpenHelper getDataBase() {
        return new DBHelper(getApplicationContext());
    }

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        GAUtils.initialize(this);
        GAUtils.getInstance().get(Target.APP);
//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3280281719755794~6633838461");
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static synchronized App getInstance() {
        App app;
        synchronized (App.class) {
            app = mInstance;
        }
        return app;
    }

    public synchronized Tracker getGoogleAnalyticsTracker() {
        return GAUtils.getInstance().get(Target.APP);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    private void printKeyhashFacebook() {
        Exception e;
        try {
            for (Signature signature : getPackageManager().getPackageInfo("vn.lequan.lienminhsamsoi", 64).signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), 0));
            }
        } catch (NameNotFoundException e2) {
            e = e2;
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public void trackScreenView(String screenName) {
        Tracker t = getGoogleAnalyticsTracker();
        t.setScreenName(screenName);
        t.send(new ScreenViewBuilder().build());
        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }

    public void trackException(Exception e) {
        if (e != null) {
            getGoogleAnalyticsTracker().send(new ExceptionBuilder().setDescription(new StandardExceptionParser(this, null).getDescription(Thread.currentThread().getName(), e)).setFatal(false).build());
        }
    }

    public void trackEvent(String category, String action, String label) {
        getGoogleAnalyticsTracker().send(new EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
    }
}
