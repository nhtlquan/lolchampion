package vn.lequan.lienminhsamsoi.ultis;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import vn.lequan.lienminhsamsoi.R;
import java.util.HashMap;
import java.util.Map;

public class GAUtils {
    private static GAUtils sInstance;
    private final Context mContext;
    private final Map<Target, Tracker> mTrackers = new HashMap();

    public enum Target {
        APP
    }

    public static synchronized void initialize(Context context) {
        synchronized (GAUtils.class) {
            if (sInstance != null) {
                throw new IllegalStateException("Extra call to initialize analytics trackers");
            }
            sInstance = new GAUtils(context);
        }
    }

    public static synchronized GAUtils getInstance() {
        GAUtils gAUtils;
        synchronized (GAUtils.class) {
            if (sInstance == null) {
                throw new IllegalStateException("Call initialize() before getInstance()");
            }
            gAUtils = sInstance;
        }
        return gAUtils;
    }

    private GAUtils(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public synchronized Tracker get(Target target) {
        if (!this.mTrackers.containsKey(target)) {
            switch (target) {
                case APP:
                    this.mTrackers.put(target, GoogleAnalytics.getInstance(this.mContext).newTracker((int) R.xml.app_tracker));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled analytics target " + target);
            }
        }
        return (Tracker) this.mTrackers.get(target);
    }
}
