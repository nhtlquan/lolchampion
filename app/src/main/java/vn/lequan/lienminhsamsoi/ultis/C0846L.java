package vn.lequan.lienminhsamsoi.ultis;

import android.util.Log;

public class C0846L {
    private static boolean DEBUG = true;
    private static String TAG = "LOLCHAMPION";

    public static void setDebug(boolean isDebuged) {
        DEBUG = isDebuged;
    }

    public static void setTAG(String tag) {
        TAG = tag;
    }

    public static void m143d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void m145i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void m146w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void m144e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }
}
