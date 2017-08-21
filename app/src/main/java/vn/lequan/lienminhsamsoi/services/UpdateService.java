package vn.lequan.lienminhsamsoi.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.UpdateActivity;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class UpdateService extends Service {

    private class DownloadData extends AsyncTask<Void, Integer, Void> {
        String language;
        String[] nameArr;
        String version;

        private DownloadData(String version, String language) {
            this.nameArr = new String[]{"language.json", "item.json", "mastery.json", "rune.json", "summoner.json", "championFull.json"};
            this.version = version;
            this.language = language;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(UpdateService.this, "Đang Tải Dữ Liệu...", Toast.LENGTH_LONG).show();
        }

        protected Void doInBackground(Void... voids) {
            for (String name : this.nameArr) {
                try {
                    URL url = new URL("http://ddragon.leagueoflegends.com/cdn/" + this.version + "/data/" + this.language + "/" + name);
                    Debug.e(url.toString());
                    URLConnection conection = url.openConnection();
                    conection.connect();
                    int lenghtOfFile = conection.getContentLength();
                    InputStream input = new BufferedInputStream(url.openStream(), 8192);
                    File f = new File(Environment.getExternalStorageDirectory() + File.separator + "lolchampion" + File.separator + name);
                    if (!f.exists()) {
                        f.getParentFile().mkdirs();
                        f.createNewFile();
                    }
                    OutputStream output = new FileOutputStream(f);
                    byte[] data = new byte[2048];
                    long total = 0;
                    while (true) {
                        int count = input.read(data);
                        if (count == -1) {
                            break;
                        }
                        total += (long) count;
                        Debug.e(name + String.valueOf(count));
                        publishProgress(new Integer[]{Integer.valueOf(Math.min((int) ((100 * total) / ((long) lenghtOfFile)), 100))});
                        output.write(data, 0, count);
                    }
                    Log.d("download", "Done-------->" + name);
                    output.flush();
                    input.close();
                    output.close();
                } catch (Exception e) {
                    Debug.e(e.toString());
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        protected void onPostExecute(Void integer) {
            super.onPostExecute(integer);
            Debug.e("Fuck");
            Intent intent = new Intent(UpdateService.this, UpdateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            stopSelf();
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        new DownloadData(Utils.getCurrentVersion(this), Utils.getLanguageCode(this)).execute(new Void[0]);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate() {
        super.onCreate();
        Log.e("service", "Service is created");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "Service is destroys");
    }
}
