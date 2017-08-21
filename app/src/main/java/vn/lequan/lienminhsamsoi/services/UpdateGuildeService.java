package vn.lequan.lienminhsamsoi.services;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.championgg.ChampionGG;
import vn.lequan.lienminhsamsoi.championgg.ItemFrequent;
import vn.lequan.lienminhsamsoi.dao.DBHelper;
import vn.lequan.lienminhsamsoi.models.ChampGuildeModel;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateGuildeService extends Service {
    private ConnectionSource connectionSource = new AndroidConnectionSource(new DBHelper(this));
    private NotificationManager manager;
    private Builder f64n;
    private Dao<ChampGuildeModel, String> system;

    class DownloadData extends AsyncTask<Void, Void, Void> {
        List<String> listLink;

        DownloadData() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            UpdateGuildeService.this.manager.notify(0, UpdateGuildeService.this.f64n.build());
        }

        protected Void doInBackground(Void... voids) {
            this.listLink = ChampionGG.getInstance().getAllLinkRole();
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (this.listLink != null) {
                new InsertData(this.listLink).execute(new Void[0]);
                return;
            }
            UpdateGuildeService.this.onDestroy();
            Toast.makeText(UpdateGuildeService.this, "Rất tiếc, đã xảy ra lỗi!", 0).show();
        }
    }

    class InsertData extends AsyncTask<Void, Integer, Void> {
        int f63i = 0;
        List<ChampGuildeModel> list = new ArrayList();
        List<String> listLink;

        InsertData(List<String> listLink) {
            this.listLink = listLink;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            UpdateGuildeService.this.f64n.setProgress(this.listLink.size(), 0, false);
            UpdateGuildeService.this.manager.notify(0, UpdateGuildeService.this.f64n.build());
        }

        protected Void doInBackground(Void... voids) {
            Gson gson = new Gson();
            for (String link : this.listLink) {
                String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
                ItemFrequent itemFrequent = ChampionGG.getInstance().getDataChampionGG(ChampionGG.getInstance().getDocument(link));
                itemFrequent.getDataRole().setTimeUpdate(date);
                String data = gson.toJson(itemFrequent);
                String[] arr = link.split("/");
                this.list.add(new ChampGuildeModel(null, arr[2], arr[3], data));
                this.f63i++;
                publishProgress(new Integer[]{Integer.valueOf(this.f63i)});
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            UpdateGuildeService.this.f64n.setProgress(this.listLink.size(), values[0].intValue(), false);
            UpdateGuildeService.this.f64n.setContentText("Downloading... " + values[0] + "/" + this.listLink.size());
            UpdateGuildeService.this.manager.notify(0, UpdateGuildeService.this.f64n.build());
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (this.list != null) {
                try {
                    TableUtils.clearTable(UpdateGuildeService.this.connectionSource, ChampGuildeModel.class);
                    for (ChampGuildeModel model : this.list) {
                        UpdateGuildeService.this.system.create(model);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                UpdateGuildeService.this.f64n.setAutoCancel(true);
                UpdateGuildeService.this.manager.notify(0, UpdateGuildeService.this.f64n.build());
                UpdateGuildeService.this.manager.cancelAll();
                Toast.makeText(UpdateGuildeService.this, "Download complete!", 0).show();
                UpdateGuildeService.this.stopSelf();
            }
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.manager = (NotificationManager) getSystemService("notification");
        this.f64n = new Builder(this).setContentTitle("Cập nhật dữ liệu").setContentText("Dowloading...").setSmallIcon(R.drawable.ic_cloud_download_white_24dp);
        try {
            this.system = DaoManager.createDao(this.connectionSource, ChampGuildeModel.class);
            TableUtils.createTableIfNotExists(this.connectionSource, ChampGuildeModel.class);
            new DownloadData().execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            this.connectionSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("e", "onDestroy()");
        System.gc();
    }
}
