package vn.lequan.lienminhsamsoi.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "loldb.db";

    public DBHelper(Context context) {
        super(context, "loldb.db", null, 1);
    }

    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
    }

    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }
}
