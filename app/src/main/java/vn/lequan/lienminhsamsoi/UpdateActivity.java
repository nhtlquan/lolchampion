package vn.lequan.lienminhsamsoi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.load.Key;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.dao.AppBase;
import vn.lequan.lienminhsamsoi.dao.DBHelper;
import vn.lequan.lienminhsamsoi.dao.data.ChampionData;
import vn.lequan.lienminhsamsoi.dao.data.Passive;
import vn.lequan.lienminhsamsoi.dao.data.SkinData;
import vn.lequan.lienminhsamsoi.dao.data.SpellData;
import vn.lequan.lienminhsamsoi.dao.data.Stats;
import vn.lequan.lienminhsamsoi.dao.data.Var;
import vn.lequan.lienminhsamsoi.dao.model.Champion;
import vn.lequan.lienminhsamsoi.dao.model.Item;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.dao.model.Mastery;
import vn.lequan.lienminhsamsoi.dao.model.Runes;
import vn.lequan.lienminhsamsoi.dao.model.Skin;
import vn.lequan.lienminhsamsoi.dao.model.Spell;
import vn.lequan.lienminhsamsoi.dao.model.SpellPassive;
import vn.lequan.lienminhsamsoi.dao.model.Summoner;
import vn.lequan.lienminhsamsoi.dao.model.SystemInfo;
import vn.lequan.lienminhsamsoi.dao.model.TipCounter;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class UpdateActivity extends AppCompatActivity {
    private static final int CHAMPION = 2;
    private static final int ITEM = 1;
    private static final int LANGUAGE = 5;
    private static final int MASTERY = 3;
    private static String[] PERMISSIONS_SDCARD = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUEST_SDCARD = 0;
    private static final int RUNES = 4;
    private AsyncTask asyncTask;
    private ConnectionSource connectionSource = new AndroidConnectionSource(new DBHelper(this));
    private String languageCode;
    private View rootView;
    private String version;

    class C08062 implements OnClickListener {
        C08062() {
        }

        public void onClick(View view) {
            ActivityCompat.requestPermissions(UpdateActivity.this, UpdateActivity.PERMISSIONS_SDCARD, 0);
        }
    }

    class DownloadData extends AsyncTask<Void, Void, Void> {
        String language;
        String[] nameArr = new String[]{"language.json", "item.json", "mastery.json", "rune.json", "summoner.json", "championFull.json"};
        String version;

        DownloadData(String version, String language) {
            this.version = version;
            this.language = language;
        }

        protected Void doInBackground(Void... voids) {
            for (String name : this.nameArr) {
                try {
                    InputStream input = new URL("http://ddragon.leagueoflegends.com/cdn/" + this.version + "/data/" + this.language + "/" + name).openStream();
                    File f = new File(Environment.getExternalStorageDirectory() + File.separator + "lolchampion" + File.separator + name);
                    if (!f.exists()) {
                        f.getParentFile().mkdirs();
                        f.createNewFile();
                    }
                    OutputStream output = new FileOutputStream(f);
                    byte[] data = new byte[2048];
                    while (true) {
                        int count = input.read(data);
                        if (count == -1) {
                            break;
                        }
                        output.write(data, 0, count);
                    }
                    Log.d("download", "Done-------->" + name);
                    output.flush();
                    input.close();
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new InsertData().execute(new Void[0]);
        }
    }

    class InsertData extends AsyncTask<Void, Void, Void> {
        JSONObject jsonChamp;
        JSONObject jsonItem;
        JSONObject jsonLanguage;
        JSONObject jsonMastery;
        JSONObject jsonRune;
        JSONObject jsonSummoner;

        InsertData() {
        }

        protected Void doInBackground(Void... params) {
            Exception e;
            try {
                this.jsonItem = UpdateActivity.this.parserJsonObject(1);
                this.jsonChamp = UpdateActivity.this.parserJsonObject(2);
                this.jsonRune = UpdateActivity.this.parserJsonObject(4);
                this.jsonMastery = UpdateActivity.this.parserJsonObject(3);
                this.jsonLanguage = UpdateActivity.this.parserJsonObject(5);
                this.jsonSummoner = UpdateActivity.this.parserJsonObject(6);
                UpdateActivity.this.insertItem(this.jsonItem);
                UpdateActivity.this.insertChampion(this.jsonChamp);
                UpdateActivity.this.insertMastery(this.jsonMastery);
                UpdateActivity.this.insertRunes(this.jsonRune);
                UpdateActivity.this.insertLanguage(this.jsonLanguage);
                UpdateActivity.this.insertSummoner(this.jsonSummoner);
                UpdateActivity.this.insertSystemInfor();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            UpdateActivity.this.deleteDirectory();
            UpdateActivity.this.startActivity(new Intent(UpdateActivity.this, MainActivity.class));
            UpdateActivity.this.finish();
        }
    }

    class C14631 extends TypeToken<List<TipCounter>> {
        C14631() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_update);
        this.rootView = findViewById(R.id.layout_snackbar);
        ImageView icSetting = (ImageView) findViewById(R.id.img_icon_setting);
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.setting_rotate);
        rotation.setRepeatCount(-1);
        icSetting.startAnimation(rotation);
        this.version = Utils.getCurrentVersion(this);
        this.languageCode = Utils.getLanguageCode(this);
        SharedPreferences prefs = getSharedPreferences(Const.MY_PREFS_NAME, 0);
        insertTipsCounter();
        if (!isPermissionGrant()) {
            requestPermission();
        } else if (isPermissionGrant() && prefs.getBoolean("isFirstRun", true) && this.asyncTask == null) {
            this.asyncTask = new DownloadData(this.version, this.languageCode).execute(new Void[0]);
        } else {
            new InsertData().execute(new Void[0]);
        }
    }

    private boolean isPermissionGrant() {
        return ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void deleteDirectory() {
        File dir = new File(Environment.getExternalStorageDirectory() + "/lolchampion");
        if (dir.isDirectory()) {
            for (String aChildren : dir.list()) {
                new File(dir, aChildren).delete();
            }
        }
    }

    private JSONObject parserJsonObject(int type) throws IOException, JSONException {
        File sdcard = Environment.getExternalStorageDirectory();
        FileInputStream fileInputStream;
        FileChannel fc;
        switch (type) {
            case 1:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/item.json"));
                String jsonItem = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonItem = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonItem);
                } finally {
                    fileInputStream.close();
                }
            case 2:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/championFull.json"));
                String jsonChampion = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonChampion = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonChampion);
                } finally {
                    fileInputStream.close();
                }
            case 3:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/mastery.json"));
                String jsonMastery = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonMastery = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonMastery);
                } finally {
                    fileInputStream.close();
                }
            case 4:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/rune.json"));
                String jsonRune = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonRune = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonRune);
                } finally {
                    fileInputStream.close();
                }
            case 5:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/language.json"));
                String jsonLanguage = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonLanguage = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonLanguage);
                } finally {
                    fileInputStream.close();
                }
            case 6:
                fileInputStream = new FileInputStream(new File(sdcard, "/lolchampion/summoner.json"));
                String jsonSummoner = null;
                try {
                    fc = fileInputStream.getChannel();
                    jsonSummoner = Charset.defaultCharset().decode(fc.map(MapMode.READ_ONLY, 0, fc.size())).toString();
                    return new JSONObject(jsonSummoner);
                } finally {
                    fileInputStream.close();
                }
            default:
                return null;
        }
    }

    private void insertRunes(JSONObject jsonObject) {
        try {
            Dao<Runes, String> runeDao = DaoManager.createDao(this.connectionSource, Runes.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Runes.class);
            TableUtils.clearTable(this.connectionSource, Runes.class);
            JSONObject itemData = jsonObject.getJSONObject("data");
            Iterator<String> x = itemData.keys();
            while (x.hasNext()) {
                String key = (String) x.next();
                runeDao.create(AppBase.getInstance().getDataRunes(itemData.getJSONObject(key), key));
            }
            Log.d("insert", "insert succses rune!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertMastery(JSONObject jsonObject) {
        try {
            Dao<Mastery, String> masteryDao = DaoManager.createDao(this.connectionSource, Mastery.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Mastery.class);
            TableUtils.clearTable(this.connectionSource, Mastery.class);
            JSONObject itemData = jsonObject.getJSONObject("data");
            Iterator<String> x = itemData.keys();
            while (x.hasNext()) {
                String key = (String) x.next();
                masteryDao.create(AppBase.getInstance().getMastery(itemData.getJSONObject(key), key));
            }
            Log.d("insert", "Insert succes table mastery");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insertMastery1(JSONObject jsonObject) {
        try {
            Dao<Mastery, String> masteryDao = DaoManager.createDao(this.connectionSource, Mastery.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Mastery.class);
            TableUtils.clearTable(this.connectionSource, Mastery.class);
            JSONObject itemData = jsonObject.getJSONObject("tree");
            Iterator<String> x = itemData.keys();
            while (x.hasNext()) {
                String key = (String) x.next();
                masteryDao.create(AppBase.getInstance().getMastery(itemData.getJSONObject(key), key));
            }
            Log.d("insert", "Insert succes table mastery");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertItem(JSONObject jsonObject) {
        try {
            Dao<Item, String> itemDao = DaoManager.createDao(this.connectionSource, Item.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Item.class);
            TableUtils.clearTable(this.connectionSource, Item.class);
            JSONObject itemData = jsonObject.getJSONObject("data");
            Iterator<String> x = itemData.keys();
            int i = 0;
            while (x.hasNext()) {
                String key = (String) x.next();
                itemDao.create(AppBase.getInstance().getDataItem(itemData.getJSONObject(key), key));
                i++;
            }
            Log.d("insert", "Insert succes table item");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertLanguage(JSONObject jsonObject) {
        try {
            Dao<Language, String> languageDao = DaoManager.createDao(this.connectionSource, Language.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Language.class);
            TableUtils.clearTable(this.connectionSource, Language.class);
            JSONObject json = jsonObject.getJSONObject("data");
            Dao<Language, String> dao = languageDao;
            dao.create(new Language(json.getString("Back"), json.getString("Continue"), json.getString("Language"), json.getString("ItemInfo"), json.getString("PlayingAgainst"), json.getString("Range"), json.getString("Details_"), json.getString("PrimaryRole"), json.getString("mobilePleaseWait"), json.getString("mobileNews"), json.getString("modeTutorial"), json.getString("Map1"), json.getString("Map8"), json.getString("Map10"), json.getString("Map12"), json.getString("categoryChampion"), json.getString("categoryItem"), json.getString("categoryMastery"), json.getString("categoryRune"), json.getString("categorySummoner"), json.getString("Gold"), json.getString("Level"), json.getString("Abilities"), json.getString("ChampionInfo"), json.getString("Lore"), json.getString("Stats"), json.getString("Tips"), json.getString("statAbility"), json.getString("statAttack"), json.getString("statDefense"), json.getString("statDifficulty"), json.getString("statUtility"), json.getString("Assassin"), json.getString("Fighter"), json.getString("Marksman"), json.getString("Mage"), json.getString("Support"), json.getString("Tank"), json.getString("AllItems"), json.getString("Armor"), json.getString("Attack"), json.getString("AttackSpeed"), json.getString("Consumable"), json.getString("CooldownReduction"), json.getString("CriticalStrike"), json.getString("Damage"), json.getString("Defense"), json.getString("Health"), json.getString("HealthRegen"), json.getString("LifeSteal"), json.getString("Magic"), json.getString("Mana"), json.getString("ManaRegen"), json.getString("Movement"), json.getString("SpellBlock"), json.getString("SpellDamage"), json.getString("Boots"), json.getString("NonbootsMovement"), json.getString("Tenacity"), json.getString("SpellVamp"), json.getString("GoldPer"), json.getString("Slow"), json.getString("Aura"), json.getString("Active"), json.getString("MagicPenetration"), json.getString("ArmorPenetration"), json.getString("RecommendedItems"), json.getString("recommended_starting"), json.getString("recommended_essential"), json.getString("recommended_offensive"), json.getString("recommended_defensive"), json.getString("recommended_consumables"), json.getString("Require_"), json.getString("Cost_"), json.getString("OriginalCost_"), json.getString("SellsFor_"), json.getString("UpgradeCost_"), json.getString("Builds_"), json.getString("ButtonBuy"), json.getString("ButtonSell"), json.getString("SpecialRecipeLarge"), json.getString("masteryFerocity"), json.getString("masteryCunning"), json.getString("masteryResolve"), json.getString("native_﻿ar"), json.getString("native_bg"), json.getString("native_cs"), json.getString("native_de"), json.getString("native_el"), json.getString("native_en"), json.getString("native_es"), json.getString("native_fr"), json.getString("native_hu"), json.getString("native_id"), json.getString("native_it"), json.getString("native_ja"), json.getString("native_ko"), json.getString("native_nl"), json.getString("native_pl"), json.getString("native_pt"), json.getString("native_ro"), json.getString("native_ru"), json.getString("native_th"), json.getString("native_tr"), json.getString("native_vn"), json.getString("native_zh"), json.getString("native_zh_CN"), json.getString("native_zh_MY"), json.getString("native_zh_TW"), json.getString("rFlatHPModPerLevel"), json.getString("FlatMovementSpeedMod"), json.getString("PlayingAs")));
            this.connectionSource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertSummoner(JSONObject jsonObject) {
        try {
            Dao<Summoner, String> summonerDao = DaoManager.createDao(this.connectionSource, Summoner.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Summoner.class);
            TableUtils.clearTable(this.connectionSource, Summoner.class);
            JSONObject itemData = jsonObject.getJSONObject("data");
            Iterator<String> x = itemData.keys();
            int i = 0;
            while (x.hasNext()) {
                String key = (String) x.next();
                summonerDao.create(AppBase.getInstance().getSummoner(itemData.getJSONObject(key), key));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertChampion(JSONObject jsonObject) {
        try {
            TableUtils.createTableIfNotExists(this.connectionSource, Champion.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Spell.class);
            TableUtils.createTableIfNotExists(this.connectionSource, Skin.class);
            TableUtils.createTableIfNotExists(this.connectionSource, SpellPassive.class);
            TableUtils.clearTable(this.connectionSource, Champion.class);
            TableUtils.clearTable(this.connectionSource, Spell.class);
            TableUtils.clearTable(this.connectionSource, Skin.class);
            TableUtils.clearTable(this.connectionSource, SpellPassive.class);
            Dao<Champion, String> championDao = DaoManager.createDao(this.connectionSource, Champion.class);
            Dao<SpellPassive, String> spellPassiveDao = DaoManager.createDao(this.connectionSource, SpellPassive.class);
            Dao<Spell, String> spellDao = DaoManager.createDao(this.connectionSource, Spell.class);
            Dao<Skin, String> skinDao = DaoManager.createDao(this.connectionSource, Skin.class);
            JSONObject itemData = jsonObject.getJSONObject("keys");
            Iterator<String> x = itemData.keys();
            List<String> champList = new ArrayList();
            while (x.hasNext()) {
                champList.add((String) itemData.get((String) x.next()));
            }
            for (String champ : champList) {
                ChampionData data = AppBase.getInstance().getDataChampion(jsonObject, champ);
                String champId = data.getId();
                String champKey = data.getKey();
                String tags = data.getTags();
                String allytips = data.getAllytips();
                String enemytips = data.getEnemytips();
                int attackRank = data.getInfo().getAttack().intValue();
                int defenseRank = data.getInfo().getDefense().intValue();
                int magicRank = data.getInfo().getMagic().intValue();
                int difficultyRank = data.getInfo().getDifficulty().intValue();
                String name = data.getName();
                String title = data.getTitle();
                String lore = AppBase.getInstance().getColor(data.getLore());
                Stats stats = data.getStats();
                championDao.create(new Champion(null, champId, champKey, 0, tags, allytips, enemytips, 0, 0, attackRank, defenseRank, magicRank, difficultyRank, name, title, lore, stats.getArmor().doubleValue(), stats.getArmorperlevel().doubleValue(), stats.getAttackdamage().doubleValue(), stats.getAttackdamageperlevel().doubleValue(), stats.getAttackrange().doubleValue(), stats.getAttackspeedoffset().doubleValue(), stats.getAttackspeedperlevel().doubleValue(), stats.getHp().doubleValue(), stats.getHpperlevel().doubleValue(), stats.getHpregen().doubleValue(), stats.getHpregenperlevel().doubleValue(), stats.getMovespeed().doubleValue(), stats.getMp().doubleValue(), stats.getMpperlevel().doubleValue(), stats.getMpregen().doubleValue(), stats.getMpregenperlevel().doubleValue(), stats.getSpellblock().doubleValue(), stats.getSpellblockperlevel().doubleValue()));
                Passive p = data.getPassive();
                spellPassiveDao.create(new SpellPassive(null, champ, p.getName(), AppBase.getInstance().getColor(p.getDescription()), p.getImage().getFull()));
                List<SpellData> listSp = data.getSpells();
                for (int i = 0; i < listSp.size(); i++) {
                    int j;
                    SpellData sp = (SpellData) listSp.get(i);
                    String spellId = sp.getId();
                    String nameSpell = sp.getName();
                    List<Var> var = sp.getVars();
                    String tooltip = sp.getTooltip();
                    String coef = "";
                    for (Var var2 : var) {
                        String key = var2.getKey();
                        List<Double> coeff = var2.getCoeff();
                        if (coeff.size() > 1) {
                            for (Double double1 : coeff) {
                                coef = coef + ((int) (double1.doubleValue() * 100.0d)) + "/";
                            }
                            coef = coef.substring(0, coef.length() - 1);
                        } else {
                            coef = ((Double) coeff.get(0)).toString();
                        }
                        String link = var2.getLink();
                        if (link != null) {
                            String obj = "";
                            switch (link.hashCode()) {
                                case -1789440197:
                                    if (link.equals("bonushealth")) {
                                        obj = "bonushealth";
                                        break;
                                    }
                                    break;
                                case -567541308:
                                    if (link.equals("bonusspellblock")) {
                                        obj = "bonusspellblock";
                                        break;
                                    }
                                    break;
                                case -462779050:
                                    if (link.equals("bonusattackdamage")) {
                                        obj = "bonusattackdamage";
                                        break;
                                    }
                                    break;
                                case 333771028:
                                    if (link.equals("@cooldownchampion")) {
                                        obj = "@cooldownchampion";
                                        break;
                                    }
                                    break;
                                case 371986071:
                                    if (link.equals("spelldamage")) {
                                        obj = "spelldamage";
                                        break;
                                    }
                                    break;
                                case 967025591:
                                    if (link.equals("attackdamage")) {
                                        obj = "attackdamage";
                                        break;
                                    }
                                    break;
                                case 1737325696:
                                    if (link.equals("bonusarmor")) {
                                        obj = "bonusarmor";
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case "spelldamage":
                                    try {
                                        coef = ((int) (Float.parseFloat(coef) * 100.0f)) + "% AP";
                                        break;
                                    } catch (Exception e) {
                                        coef = coef + "% AP";
                                        break;
                                    }
                                case "attackdamage":
                                case "bonusattackdamage":
                                    try {
                                        coef = ((int) (Float.parseFloat(coef) * 100.0f)) + "% AD";
                                        break;
                                    } catch (Exception e2) {
                                        coef = coef + "% AD";
                                        break;
                                    }
                                case "bonusarmor":
                                case "bonusspellblock":
                                case "bonushealth":
                                    try {
                                        coef = ((int) (Float.parseFloat(coef) * 100.0f)) + "%";
                                        break;
                                    } catch (Exception e3) {
                                        coef = coef + "%";
                                        break;
                                    }
                                default:
                                    continue;
                            }
                        }
                        tooltip = tooltip.replace("{{ " + key + " }}", coef);
                    }
                    List<Object> effectBurn = sp.getEffectBurn();
                    if (effectBurn.size() > 1) {
                        for (j = 1; j < effectBurn.size(); j++) {
                            if (effectBurn.get(j) != null) {
                                tooltip = tooltip.replace("{{ e" + j + " }}", effectBurn.get(j).toString());
                            }
                        }
                    }
                    tooltip = AppBase.getInstance().getColor(tooltip);
                    String costType = sp.getCostType();
                    String costBurn = sp.getCostBurn();
                    String resource = sp.getResource();
                    if (effectBurn.size() > 1) {
                        for (j = 1; j < effectBurn.size(); j++) {
                            if (effectBurn.get(j) != null) {
                                resource = resource.replace("{{ e" + j + " }}", effectBurn.get(j).toString());
                            }
                        }
                    }
                    String str = champ;
                    spellDao.create(new Spell(null, spellId, str, i, nameSpell, tooltip, resource.replace("{{ cost }}", costBurn), sp.getCooldownBurn(), costBurn, costType, 0, sp.getRangeBurn(), sp.getImage().getFull()));
                }
                for (SkinData sk : data.getSkins()) {
                    Skin skin = new Skin();
                    String skinId = sk.getId();
                    int num = sk.getNum().intValue();
                    String nameSK = sk.getName();
                    skin.setChampId(champ);
                    skin.setCostRp(0);
                    skin.setSkinId(skinId);
                    skin.setName(nameSK);
                    skin.setNum(num);
                    skinDao.create(skin);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Log.d("insert", "Insert succes table champ");
    }

    private void insertSystemInfor() {
        try {
            Dao<SystemInfo, String> system = DaoManager.createDao(this.connectionSource, SystemInfo.class);
            TableUtils.createTableIfNotExists(this.connectionSource, SystemInfo.class);
            TableUtils.clearTable(this.connectionSource, SystemInfo.class);
            Date date = Calendar.getInstance().getTime();
            system.create(new SystemInfo(null, this.version, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date), this.languageCode));
            Log.e("insert", "insert succes system table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertTipsCounter() {
        Exception e;
        try {
            Dao<TipCounter, String> tipCounterDao = DaoManager.createDao(this.connectionSource, TipCounter.class);
            TableUtils.createTableIfNotExists(this.connectionSource, TipCounter.class);
            TableUtils.clearTable(this.connectionSource, TipCounter.class);
            InputStream is = getAssets().open("tipscounter.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            List<TipCounter> tipCounterList = new Gson().fromJson(new String(buffer, Key.STRING_CHARSET_NAME), new C14631().getType());
            for (TipCounter tips : tipCounterList) {
                tipCounterDao.create(tips);
            }
            Log.e("insert", "insert succes tips_counter table");
        } catch (SQLException e2) {
            e = e2;
            e.printStackTrace();
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            CharSequence title;
            if (Utils.getLanguageCode(this).equals("vn_VN")) {
                title = "Bạn phải cấp quyền truy cập cho ứng dụng!";
            } else {
                title = "You must grant access to the application!";
            }
            Snackbar.make(this.rootView, title, -2).setAction((CharSequence) "OK", new C08062()).show();
            return;
        }
        ActivityCompat.requestPermissions(this, PERMISSIONS_SDCARD, 0);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean grantPermission = true;
        for (int result : grantResults) {
            if (result != 0) {
                grantPermission = false;
            }
        }
        if (!grantPermission) {
            requestPermission();
        } else if (this.asyncTask == null) {
            this.asyncTask = new DownloadData(this.version, this.languageCode).execute(new Void[0]);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.asyncTask != null) {
            this.asyncTask.cancel(true);
        }
        try {
            this.connectionSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
