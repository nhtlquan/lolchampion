package vn.lequan.lienminhsamsoi.ultis;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final String KEY_AUTO_UPDATE = "auto_update";
    private static final String KEY_SHOW_NOTIFICATION = "show_notification";

    public static boolean copyDatabaseFromAssets(Context context, String databaseName, boolean overwrite) {
        if (context.getDatabasePath(databaseName).exists() && !overwrite) {
            return true;
        }
        File outputFile = context.getDatabasePath(databaseName + ".temp");
        outputFile.getParentFile().mkdirs();
        try {
            InputStream inputStream = context.getAssets().open(databaseName);
            OutputStream outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = inputStream.read(buffer);
                if (length > 0) {
                    outputStream.write(buffer, 0, length);
                } else {
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                    outputFile.renameTo(context.getDatabasePath(databaseName));
                    return true;
                }
            }
        } catch (IOException e) {
            if (outputFile.exists()) {
                outputFile.delete();
            }
            return false;
        }
    }

    public static boolean doesDatabaseExist(ContextWrapper context, String dbName) {
        return context.getDatabasePath(dbName).exists();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static int getImageMasteryGray(Context context, String itemId) {
        return context.getResources().getIdentifier("vn.lequan.lienminhsamsoi:drawable/gray_" + itemId, null, null);
    }

    public static int getImageItem(Context context, String itemId) {
        return context.getResources().getIdentifier("vn.lequan.lienminhsamsoi:drawable/i" + itemId, null, null);
    }

    public static int getImageDrawble(Context context, String champId) {
        return context.getResources().getIdentifier("vn.lequan.lienminhsamsoi:drawable/" + champId.toLowerCase(), null, null);
    }

    public static String getUrlImageItem(Context context, String itemId) {
        return "http://ddragon.leagueoflegends.com/cdn/" + getCurrentVersion(context) + "/img/item/" + itemId + ".png";
    }

    public static String getUrlSpell(Context context, String spellName) {
        return "http://ddragon.leagueoflegends.com/cdn/" + getCurrentVersion(context) + "/img/spell/" + spellName + ".png";
    }

    public static String decode(String text) {
        return text.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a").replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e").replaceAll("ì|í|î|ị|ỉ|ĩ", "i").replaceAll("ö|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o").replaceAll("ü|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u").replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y").replaceAll("đ", "d");
    }

    public static String getImageRunne(Context context, String runeImage) {
        return "http://ddragon.leagueoflegends.com/cdn/" + getCurrentVersion(context) + "/img/rune/" + runeImage;
    }

    public static List<String> getLinkVideoSpell(String champId) {
        List<String> list = new ArrayList();
        switch (champId.length()) {
            case 1:
                champId = "00" + champId;
                break;
            case 2:
                champId = AppEventsConstants.EVENT_PARAM_VALUE_NO + champId;
                break;
        }
        for (int i = 1; i <= 5; i++) {
            list.add("https://lolstatic-a.akamaihd.net/champion-abilities/videos/mp4/0" + champId + "_0" + i + ".mp4");
        }
        return list;
    }

    public static void setNewVersion(Context context, String newVersion) {
        Editor editor = context.getSharedPreferences(Const.MY_PREFS_NAME, 0).edit();
        editor.putString("version", newVersion);
        editor.apply();
    }

    public static String getCurrentVersion(Context context) {
        return context.getSharedPreferences(Const.MY_PREFS_NAME, 0).getString("version", "");
    }

    public static void setLanguageCode(Context context, String languageCode) {
        Editor editor = context.getSharedPreferences(Const.MY_PREFS_NAME, 0).edit();
        editor.putString(Const.KEY_LANGUAGE_CODE, languageCode);
        editor.apply();
    }

    public static String getLanguageCode(Context context) {
        return context.getSharedPreferences(Const.MY_PREFS_NAME, 0).getString(Const.KEY_LANGUAGE_CODE, "en_US");
    }

    public static void setAutoUpdate(Context context, boolean update) {
        Editor editor = context.getSharedPreferences(Const.MY_PREFS_NAME, 0).edit();
        editor.putBoolean(KEY_AUTO_UPDATE, update);
        editor.apply();
    }

    public static boolean getAutoUpdate(Context context) {
        return context.getSharedPreferences(Const.MY_PREFS_NAME, 0).getBoolean(KEY_AUTO_UPDATE, false);
    }

    public static void setShowNotification(Context context, boolean show) {
        Editor editor = context.getSharedPreferences(Const.MY_PREFS_NAME, 0).edit();
        editor.putBoolean(KEY_SHOW_NOTIFICATION, show);
        editor.apply();
    }

    public static boolean getShowNotification(Context context) {
        return context.getSharedPreferences(Const.MY_PREFS_NAME, 0).getBoolean(KEY_SHOW_NOTIFICATION, false);
    }

    public static String getDatabaseNameFromLanguageCode(String languageCode) {
        return Const.MAIN_DATABASE_NAME;
    }
}
