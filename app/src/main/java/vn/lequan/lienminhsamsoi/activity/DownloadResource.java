package vn.lequan.lienminhsamsoi.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Champion;
import vn.lequan.lienminhsamsoi.dao.model.Item;
import vn.lequan.lienminhsamsoi.dao.model.Spell;
import vn.lequan.lienminhsamsoi.dao.model.SpellPassive;

public class DownloadResource extends AppCompatActivity {
    private static final int CHAMPION = 0;
    private static final int CHAMPION_LOADING = 4;
    private static final int ITEM = 3;
    private static final int SPELL = 2;
    private static final int SPELL_PASSIVE = 1;
    private static final String VERSION = "6.24.1";

    class DownloadData extends AsyncTask<Void, Integer, Void> {
        List<String> error;
        int f55i;
        List<String> imageName;
        int type;

        private DownloadData(List<String> imageName, int type) {
            this.f55i = 0;
            this.error = new ArrayList();
            this.imageName = imageName;
            this.type = type;
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected Void doInBackground(Void... r18) {
            /*
            r17 = this;
            r0 = r17;
            r13 = r0.imageName;
            r13 = r13.iterator();
        L_0x0008:
            r14 = r13.hasNext();
            if (r14 == 0) goto L_0x0230;
        L_0x000e:
            r9 = r13.next();
            r9 = (java.lang.String) r9;
            r11 = 0;
            r5 = 0;
            r0 = r17;
            r14 = r0.type;	 Catch:{ Exception -> 0x0058 }
            switch(r14) {
                case 0: goto L_0x0064;
                case 1: goto L_0x016e;
                case 2: goto L_0x01ba;
                case 3: goto L_0x0114;
                case 4: goto L_0x00bc;
                default: goto L_0x001d;
            };	 Catch:{ Exception -> 0x0058 }
        L_0x001d:
            r1 = r11.openConnection();	 Catch:{ Exception -> 0x0058 }
            r1.connect();	 Catch:{ Exception -> 0x0058 }
            r8 = r1.getContentLength();	 Catch:{ Exception -> 0x0058 }
            r7 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0058 }
            r14 = r11.openStream();	 Catch:{ Exception -> 0x0058 }
            r15 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r7.<init>(r14, r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r5.exists();	 Catch:{ Exception -> 0x0058 }
            if (r14 != 0) goto L_0x0043;
        L_0x0039:
            r14 = r5.getParentFile();	 Catch:{ Exception -> 0x0058 }
            r14.mkdirs();	 Catch:{ Exception -> 0x0058 }
            r5.createNewFile();	 Catch:{ Exception -> 0x0058 }
        L_0x0043:
            r10 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0058 }
            r10.<init>(r5);	 Catch:{ Exception -> 0x0058 }
            r14 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
            r3 = new byte[r14];	 Catch:{ Exception -> 0x0058 }
        L_0x004c:
            r2 = r7.read(r3);	 Catch:{ Exception -> 0x0058 }
            r14 = -1;
            if (r2 == r14) goto L_0x0206;
        L_0x0053:
            r14 = 0;
            r10.write(r3, r14, r2);	 Catch:{ Exception -> 0x0058 }
            goto L_0x004c;
        L_0x0058:
            r4 = move-exception;
        L_0x0059:
            r4.printStackTrace();
            r0 = r17;
            r14 = r0.error;
            r14.add(r9);
            goto L_0x0008;
        L_0x0064:
            r12 = new java.net.URL;	 Catch:{ Exception -> 0x0058 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
            r14.<init>();	 Catch:{ Exception -> 0x0058 }
            r15 = "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0058 }
            r15 = ".png";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0058 }
            r12.<init>(r14);	 Catch:{ Exception -> 0x0058 }
            r6 = new java.io.File;	 Catch:{ Exception -> 0x0232 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
            r14.<init>();	 Catch:{ Exception -> 0x0232 }
            r15 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "lolchampion/champion";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = r9.toLowerCase();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = ".png";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0232 }
            r6.<init>(r14);	 Catch:{ Exception -> 0x0232 }
            r5 = r6;
            r11 = r12;
            goto L_0x001d;
        L_0x00bc:
            r12 = new java.net.URL;	 Catch:{ Exception -> 0x0058 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
            r14.<init>();	 Catch:{ Exception -> 0x0058 }
            r15 = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0058 }
            r15 = "_0.jpg";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0058 }
            r12.<init>(r14);	 Catch:{ Exception -> 0x0058 }
            r6 = new java.io.File;	 Catch:{ Exception -> 0x0232 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
            r14.<init>();	 Catch:{ Exception -> 0x0232 }
            r15 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "lolchampion/loading";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = r9.toLowerCase();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "_0.jpg";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0232 }
            r6.<init>(r14);	 Catch:{ Exception -> 0x0232 }
            r5 = r6;
            r11 = r12;
            goto L_0x001d;
        L_0x0114:
            r12 = new java.net.URL;	 Catch:{ Exception -> 0x0058 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
            r14.<init>();	 Catch:{ Exception -> 0x0058 }
            r15 = "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/item/";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0058 }
            r15 = ".png";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0058 }
            r12.<init>(r14);	 Catch:{ Exception -> 0x0058 }
            r6 = new java.io.File;	 Catch:{ Exception -> 0x0232 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
            r14.<init>();	 Catch:{ Exception -> 0x0232 }
            r15 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "lolchampion/item";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "i";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0232 }
            r15 = ".png";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0232 }
            r6.<init>(r14);	 Catch:{ Exception -> 0x0232 }
            r5 = r6;
            r11 = r12;
            goto L_0x001d;
        L_0x016e:
            r12 = new java.net.URL;	 Catch:{ Exception -> 0x0058 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
            r14.<init>();	 Catch:{ Exception -> 0x0058 }
            r15 = "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/passive/";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0058 }
            r12.<init>(r14);	 Catch:{ Exception -> 0x0058 }
            r6 = new java.io.File;	 Catch:{ Exception -> 0x0232 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
            r14.<init>();	 Catch:{ Exception -> 0x0232 }
            r15 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "lolchampion/passive";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = r9.toLowerCase();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0232 }
            r6.<init>(r14);	 Catch:{ Exception -> 0x0232 }
            r5 = r6;
            r11 = r12;
            goto L_0x001d;
        L_0x01ba:
            r12 = new java.net.URL;	 Catch:{ Exception -> 0x0058 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
            r14.<init>();	 Catch:{ Exception -> 0x0058 }
            r15 = "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/spell/";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.append(r9);	 Catch:{ Exception -> 0x0058 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0058 }
            r12.<init>(r14);	 Catch:{ Exception -> 0x0058 }
            r6 = new java.io.File;	 Catch:{ Exception -> 0x0232 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
            r14.<init>();	 Catch:{ Exception -> 0x0232 }
            r15 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = "lolchampion/spell";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = java.io.File.separator;	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r15 = r9.toLowerCase();	 Catch:{ Exception -> 0x0232 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x0232 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x0232 }
            r6.<init>(r14);	 Catch:{ Exception -> 0x0232 }
            r5 = r6;
            r11 = r12;
            goto L_0x001d;
        L_0x0206:
            r10.flush();	 Catch:{ Exception -> 0x0058 }
            r7.close();	 Catch:{ Exception -> 0x0058 }
            r10.close();	 Catch:{ Exception -> 0x0058 }
            r0 = r17;
            r14 = r0.f55i;	 Catch:{ Exception -> 0x0058 }
            r14 = r14 + 1;
            r0 = r17;
            r0.f55i = r14;	 Catch:{ Exception -> 0x0058 }
            r14 = 1;
            r14 = new java.lang.Integer[r14];	 Catch:{ Exception -> 0x0058 }
            r15 = 0;
            r0 = r17;
            r0 = r0.f55i;	 Catch:{ Exception -> 0x0058 }
            r16 = r0;
            r16 = java.lang.Integer.valueOf(r16);	 Catch:{ Exception -> 0x0058 }
            r14[r15] = r16;	 Catch:{ Exception -> 0x0058 }
            r0 = r17;
            r0.publishProgress(r14);	 Catch:{ Exception -> 0x0058 }
            goto L_0x0008;
        L_0x0230:
            r13 = 0;
            return r13;
        L_0x0232:
            r4 = move-exception;
            r11 = r12;
            goto L_0x0059;
            */
            throw new UnsupportedOperationException("Method not decompiled: vn.lequan.lienminhsamsoi.activity.DownloadResource.DownloadData.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e("e", this.f55i + "/" + this.imageName.size());
        }

        protected void onPostExecute(Void integer) {
            super.onPostExecute(integer);
            if (this.error.size() > 0) {
                Log.e("e", "error: " + new Gson().toJson(this.error));
                return;
            }
            Log.e("e", "download compele");
        }
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_resource_activity);
        ChampDao champDao = ChampDao.getInstant(this);
        List<Champion> championList = champDao.getAllChampion();
        List<SpellPassive> passiveList = champDao.getAllSpellPassive();
        List<Spell> spellList = champDao.getAllSpell();
        List<Item> itemList = champDao.getAllItem();
        List<String> lstChamp = new ArrayList();
        List<String> lstPassive = new ArrayList();
        List<String> lstSPell = new ArrayList();
        List<String> lstItem = new ArrayList();
        for (Champion champ : championList) {
            lstChamp.add(champ.getChampId());
        }
        for (Spell spell : spellList) {
            lstSPell.add(spell.getImage());
        }
        for (SpellPassive spellPassive : passiveList) {
            lstPassive.add(spellPassive.getImage());
        }
        for (Item item : itemList) {
            lstItem.add(item.getItemId());
        }
        new DownloadData(lstChamp, 0).execute(new Void[0]);
        new DownloadData(lstChamp, 4).execute(new Void[0]);
        new DownloadData(lstPassive, 1).execute(new Void[0]);
        new DownloadData(lstSPell, 2).execute(new Void[0]);
        new DownloadData(lstItem, 3).execute(new Void[0]);
    }
}
