package vn.lequan.lienminhsamsoi.services;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.ultis.Const;

public class DownloadSkin extends Service {
    private NotificationManager manager;
    private Builder f62n;
    private String name;

    class Download extends AsyncTask<Void, Integer, Integer> {
        private String fileName;
        private String url;

        Download(String url) {
            this.url = url;
        }

        protected Integer doInBackground(Void... voids) {
            Exception e;
            Throwable th;
            InputStream input = null;
            OutputStream output = null;
            try {
                URL url = new URL(this.url);
                URLConnection conection = url.openConnection();
                conection.connect();
                int lenghtOfFile = conection.getContentLength();
                InputStream input2 = new BufferedInputStream(url.openStream(), 8192);
                try {
                    String[] split = this.url.split(File.separator);
                    int len = split.length;
                    this.fileName = len > 0 ? split[len - 1] : "dlfile.jpg";
                    File f = new File(Environment.getExternalStorageDirectory() + File.separator + "Download" + File.separator + this.fileName);
                    if (!f.exists()) {
                        f.getParentFile().mkdirs();
                        f.createNewFile();
                    }
                    OutputStream output2 = new FileOutputStream(f);
                    try {
                        byte[] data = new byte[1024];
                        long total = 0;
                        while (true) {
                            int count = input2.read(data);
                            if (count == -1) {
                                break;
                            }
                            total += (long) count;
                            publishProgress(new Integer[]{Integer.valueOf(Math.min((int) ((100 * total) / ((long) lenghtOfFile)), 100))});
                            output2.write(data, 0, count);
                        }
                        output2.flush();
                        output2.close();
                        input2.close();
                        try {
                            output2.close();
                            input2.close();
                            output = output2;
                            input = input2;
                        } catch (IOException e2) {
                            Log.e("Error: ", e2.getMessage());
                            output = output2;
                            input = input2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        output = output2;
                        input = input2;
                        try {
                            Log.e("Error: ", e.getMessage());
                            try {
                                output.close();
                                input.close();
                            } catch (IOException e22) {
                                Log.e("Error: ", e22.getMessage());
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                output.close();
                                input.close();
                            } catch (IOException e222) {
                                Log.e("Error: ", e222.getMessage());
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        output = output2;
                        input = input2;
                        output.close();
                        input.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    input = input2;
                    Log.e("Error: ", e.getMessage());
                    output.close();
                    input.close();
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    input = input2;
                    output.close();
                    input.close();
                    try {
                        throw th;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                Log.e("Error: ", e.getMessage());
                try {
                    output.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    input.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return null;
            }
            return null;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            DownloadSkin.this.f62n.setProgress(100, 0, false);
            DownloadSkin.this.manager.notify(0, DownloadSkin.this.f62n.build());
        }

        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            File localFile = new File(Environment.getExternalStorageDirectory() + File.separator + "Download" + File.separator + this.fileName);
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setDataAndType(Uri.fromFile(localFile), "image/*");
            PendingIntent localPendingIntent = PendingIntent.getActivity(DownloadSkin.this, 0, localIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            DownloadSkin.this.f62n.setContentTitle(DownloadSkin.this.name);
            DownloadSkin.this.f62n.setContentText("Download completed.");
            DownloadSkin.this.f62n.setSmallIcon(R.drawable.ic_done_white_24dp);
            DownloadSkin.this.f62n.setProgress(0, 0, false);
            DownloadSkin.this.f62n.setContentIntent(localPendingIntent);
            DownloadSkin.this.f62n.setAutoCancel(true);
            DownloadSkin.this.manager.notify(0, DownloadSkin.this.f62n.build());
            DownloadSkin.this.onDestroy();
        }

        protected void onProgressUpdate(Integer... values) {
            DownloadSkin.this.f62n.setProgress(100, values[0].intValue(), false);
            DownloadSkin.this.manager.notify(0, DownloadSkin.this.f62n.build());
            super.onProgressUpdate(values);
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.name = intent.getExtras().getString(Const.IMAGE_NAME_SKIN);
        this.manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        this.f62n = new Builder(this).setContentTitle("Tải xuống " + this.name).setContentText("Đang tải..").setSmallIcon(R.drawable.ic_file_download_white_24dp);
        new Download(intent.getExtras().getString(Const.IMAGE_URL_SKIN)).execute(new Void[0]);
        return super.onStartCommand(intent, flags, startId);
    }
}
