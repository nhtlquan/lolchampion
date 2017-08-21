package vn.lequan.lienminhsamsoi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.Html;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.championgg.DataRole;
import vn.lequan.lienminhsamsoi.championgg.ItemFrequent;
import vn.lequan.lienminhsamsoi.dao.model.Champion;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.dao.model.Mastery;
import vn.lequan.lienminhsamsoi.dao.model.SpellPassive;
import vn.lequan.lienminhsamsoi.dao.model.SystemInfo;
import vn.lequan.lienminhsamsoi.dao.model.TipCounter;
import vn.lequan.lienminhsamsoi.models.ChampGuildeModel;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.models.Lore;
import vn.lequan.lienminhsamsoi.models.ModelGridView;
import vn.lequan.lienminhsamsoi.models.Runes;
import vn.lequan.lienminhsamsoi.models.SkinModel;
import vn.lequan.lienminhsamsoi.models.Spell;
import vn.lequan.lienminhsamsoi.ultis.Const;

public class ChampDao implements BaseColumns {
    private static SQLiteDatabase database;
    private static ChampDao instant;

    class C14701 extends TypeToken<List<String>> {
        C14701() {
        }
    }

    class C14712 extends TypeToken<List<String>> {
        C14712() {
        }
    }

    private ChampDao(Context paramContext) {
        database = new DBHelper(paramContext).getReadableDatabase();
    }

    public static ChampDao getInstant(Context paramContext) {
        if (instant == null) {
            instant = new ChampDao(paramContext);
        }
        return instant;
    }

    public List<ModelGridView> getListModels() throws Exception {
        List<ModelGridView> localArrayList = new ArrayList();
        Cursor localCursor = database.rawQuery("SELECT name,champId,champKey FROM champion ORDER BY name", null);
        if (localCursor != null) {
            localCursor.moveToFirst();
            while (!localCursor.isAfterLast()) {
                String id = localCursor.getString(localCursor.getColumnIndex(Const.CHAMP_ID));
                localArrayList.add(new ModelGridView(id, localCursor.getString(localCursor.getColumnIndex("name")), id.toLowerCase(), localCursor.getString(localCursor.getColumnIndex("champKey"))));
                localCursor.moveToNext();
            }
            localCursor.close();
        }
        return localArrayList;
    }

    public Lore getOverview(String id) {
        Lore model = new Lore();
        Cursor cursor = database.rawQuery("SELECT * FROM champion where champId = ?", new String[]{id});
        if (cursor == null) {
            return model;
        }
        cursor.moveToFirst();
        String champId = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
        float armor = cursor.getFloat(cursor.getColumnIndex("armor"));
        float armorPerLevel = cursor.getFloat(cursor.getColumnIndex("armorPerLevel"));
        float attackDamage = cursor.getFloat(cursor.getColumnIndex("attackDamage"));
        float attackDamagePerLevel = cursor.getFloat(cursor.getColumnIndex("attackDamagePerLevel"));
        int attackRange = cursor.getInt(cursor.getColumnIndex("attackRange"));
        int attackRank = cursor.getInt(cursor.getColumnIndex("attackRank"));
        float attackSpeedPerLevel = cursor.getFloat(cursor.getColumnIndex("attackSpeedPerLevel"));
        int costIp = cursor.getInt(cursor.getColumnIndex("costIp"));
        int costRp = cursor.getInt(cursor.getColumnIndex("costRp"));
        int defenseRank = cursor.getInt(cursor.getColumnIndex("defenseRank"));
        int difficultyRank = cursor.getInt(cursor.getColumnIndex("difficultyRank"));
        float hp = cursor.getFloat(cursor.getColumnIndex("hp"));
        int hpPerLevel = cursor.getInt(cursor.getColumnIndex("hpPerLevel"));
        float hpRegen = cursor.getFloat(cursor.getColumnIndex("hpRegen"));
        float hpRegenPerLevel = cursor.getFloat(cursor.getColumnIndex("hpRegenPerLevel"));
        String index = "vn.lequan.lienminhsamsoi:drawable/" + champId.toLowerCase() + "_0";
        String lore = cursor.getString(cursor.getColumnIndex("lore"));
        int magicRank = cursor.getInt(cursor.getColumnIndex("magicRank"));
        int moveSpeed = cursor.getInt(cursor.getColumnIndex("moveSpeed"));
        float mp = cursor.getFloat(cursor.getColumnIndex("mp"));
        int mpPerLevel = cursor.getInt(cursor.getColumnIndex("mpPerLevel"));
        float mpRegen = cursor.getFloat(cursor.getColumnIndex("mpRegen"));
        float mpRegenPerLevel = cursor.getFloat(cursor.getColumnIndex("mpRegenPerLevel"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        float spellBlock = cursor.getFloat(cursor.getColumnIndex("spellBlock"));
        float spellBlockPerLevel = cursor.getFloat(cursor.getColumnIndex("spellBlockPerLevel"));
        String title = cursor.getString(cursor.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_TITLE));
        cursor.close();
        return new Lore(champId, armor, armorPerLevel, attackDamage, attackDamagePerLevel, attackRange, attackRank, attackSpeedPerLevel, costIp, costRp, defenseRank, difficultyRank, hp, hpPerLevel, hpRegen, hpRegenPerLevel, index, lore, magicRank, moveSpeed, mp, mpPerLevel, mpRegen, mpRegenPerLevel, name, spellBlock, spellBlockPerLevel, title);
    }

    public Lore getOverviewFromkey(String id) {
        Lore model = new Lore();
        Cursor cursor = database.rawQuery("SELECT * FROM champion where champKey = ?", new String[]{id});
        if (cursor == null) {
            return model;
        }
        cursor.moveToFirst();
        String champId = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
        float armor = cursor.getFloat(cursor.getColumnIndex("armor"));
        float armorPerLevel = cursor.getFloat(cursor.getColumnIndex("armorPerLevel"));
        float attackDamage = cursor.getFloat(cursor.getColumnIndex("attackDamage"));
        float attackDamagePerLevel = cursor.getFloat(cursor.getColumnIndex("attackDamagePerLevel"));
        int attackRange = cursor.getInt(cursor.getColumnIndex("attackRange"));
        int attackRank = cursor.getInt(cursor.getColumnIndex("attackRank"));
        float attackSpeedPerLevel = cursor.getFloat(cursor.getColumnIndex("attackSpeedPerLevel"));
        int costIp = cursor.getInt(cursor.getColumnIndex("costIp"));
        int costRp = cursor.getInt(cursor.getColumnIndex("costRp"));
        int defenseRank = cursor.getInt(cursor.getColumnIndex("defenseRank"));
        int difficultyRank = cursor.getInt(cursor.getColumnIndex("difficultyRank"));
        float hp = cursor.getFloat(cursor.getColumnIndex("hp"));
        int hpPerLevel = cursor.getInt(cursor.getColumnIndex("hpPerLevel"));
        float hpRegen = cursor.getFloat(cursor.getColumnIndex("hpRegen"));
        float hpRegenPerLevel = cursor.getFloat(cursor.getColumnIndex("hpRegenPerLevel"));
        String index = "vn.lequan.lienminhsamsoi:drawable/" + champId.toLowerCase() + "_0";
        String lore = cursor.getString(cursor.getColumnIndex("lore"));
        int magicRank = cursor.getInt(cursor.getColumnIndex("magicRank"));
        int moveSpeed = cursor.getInt(cursor.getColumnIndex("moveSpeed"));
        float mp = cursor.getFloat(cursor.getColumnIndex("mp"));
        int mpPerLevel = cursor.getInt(cursor.getColumnIndex("mpPerLevel"));
        float mpRegen = cursor.getFloat(cursor.getColumnIndex("mpRegen"));
        float mpRegenPerLevel = cursor.getFloat(cursor.getColumnIndex("mpRegenPerLevel"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        float spellBlock = cursor.getFloat(cursor.getColumnIndex("spellBlock"));
        float spellBlockPerLevel = cursor.getFloat(cursor.getColumnIndex("spellBlockPerLevel"));
        String title = cursor.getString(cursor.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_TITLE));
        cursor.close();
        return new Lore(champId, armor, armorPerLevel, attackDamage, attackDamagePerLevel, attackRange, attackRank, attackSpeedPerLevel, costIp, costRp, defenseRank, difficultyRank, hp, hpPerLevel, hpRegen, hpRegenPerLevel, index, lore, magicRank, moveSpeed, mp, mpPerLevel, mpRegen, mpRegenPerLevel, name, spellBlock, spellBlockPerLevel, title);
    }

    public List<Spell> getSpell(String chamId) {
        List<Spell> list = new ArrayList();
        list.add(getSpellPassive(chamId));
        Cursor cursor = database.rawQuery("SELECT * FROM spell WHERE champId = ?", new String[]{chamId});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String spellId = cursor.getString(cursor.getColumnIndex("spellId"));
                list.add(new Spell(spellId, "vn.lequan.lienminhsamsoi:drawable/" + spellId.toLowerCase(), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("cooldownBurn")), cursor.getString(cursor.getColumnIndex("resource")), cursor.getString(cursor.getColumnIndex("rangeBurn")), cursor.getString(cursor.getColumnIndex("description"))));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    private Spell getSpellPassive(String chamId) {
        Cursor cursor = database.rawQuery("SELECT * FROM spell_passive WHERE champId = ?", new String[]{chamId});
        if (cursor == null) {
            return null;
        }
        cursor.moveToFirst();
        String full = cursor.getString(cursor.getColumnIndex("image"));
        Spell list = new Spell(full, "vn.lequan.lienminhsamsoi:drawable/" + full.toLowerCase().replace(".png", ""), cursor.getString(cursor.getColumnIndex("name")), "", "", "", Html.fromHtml(cursor.getString(cursor.getColumnIndex("description"))).toString());
        cursor.close();
        return list;
    }

    public String getSummoner(String chamId) {
        Cursor cursor = database.rawQuery("SELECT * FROM summoner WHERE key = ?", new String[]{chamId});
        if (cursor == null) {
            return null;
        }
        cursor.moveToFirst();
        String full = cursor.getString(cursor.getColumnIndex("id"));
        cursor.close();
        return full;
    }

    public List<String> getTips(String chamId, String type) {
        Type listType = new C14701().getType();
        Gson gson = new Gson();
        List<String> data2 = new ArrayList();
        String SQLQuery = "SELECT " + type + " FROM champion WHERE champId = ?";
        Cursor cursor = database.rawQuery(SQLQuery, new String[]{chamId});
        if (cursor == null) {
            return data2;
        }
        cursor.moveToFirst();
        data2 = (List) gson.fromJson(cursor.getString(cursor.getColumnIndex(type)), listType);
        cursor.close();
        return data2;
    }

    public List<String> getChampTag(String champId) {
        Type listType = new C14712().getType();
        Gson gson = new Gson();
        List<String> data2 = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT tags FROM champion WHERE champId = ?", new String[]{champId});
        if (cursor == null) {
            return data2;
        }
        cursor.moveToFirst();
        data2 = (List) gson.fromJson(cursor.getString(cursor.getColumnIndex("tags")), listType);
        cursor.close();
        return data2;
    }

    public List<ModelGridView> searchChampion(String chamName) {
        List<ModelGridView> list = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT name,champId,champKey FROM champion WHERE name LIKE ? ", new String[]{"%" + chamName + "%"});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
                list.add(new ModelGridView(id, cursor.getString(cursor.getColumnIndex("name")), id.toLowerCase(), cursor.getString(cursor.getColumnIndex("champKey"))));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public List<SkinModel> getLinkSkin(String champId) {
        Debug.e(champId);
        List<SkinModel> list = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT * FROM skin WHERE champId = ?", new String[]{champId});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
                list.add(new SkinModel(cursor.getString(cursor.getColumnIndex("name")), "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + id + "_" + cursor.getInt(cursor.getColumnIndex("num")) + ".jpg"));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public List<SkinModel> getLinkSkinBykeyID(String champId) {
        Debug.e(champId);
        List<SkinModel> list = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT * FROM skin WHERE keyID = ?", new String[]{champId});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
                list.add(new SkinModel(cursor.getString(cursor.getColumnIndex("name")), "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + id + "_" + cursor.getInt(cursor.getColumnIndex("num")) + ".jpg"));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public List<ModelGridView> getWeakChampion(String champId, String type) {
        List<ModelGridView> list = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT * FROM tips_counter WHERE champId = ?", new String[]{champId});
        if (cursor.moveToFirst()) {
            String weak = cursor.getString(cursor.getColumnIndex(type));
            String[] weakArr = null;
            if (weak != null) {
                if (!weak.equals("")) {
                    weakArr = weak.replace("[", "").replace("]", "").split(",");
                }
            }
            if (weakArr != null) {
                for (String a : weakArr) {
                    Cursor cursor1 = database.query(Const.CHAMPION_KEY, new String[]{Const.CHAMP_ID, "name"}, "champKey =?", new String[]{a}, null, null, null);
                    if (cursor1.moveToFirst()) {
                        String id = cursor1.getString(cursor1.getColumnIndex(Const.CHAMP_ID));
                        list.add(new ModelGridView(id, cursor1.getString(cursor1.getColumnIndex("name")), id.toLowerCase(), a));
                        cursor1.close();
                    }
                }
            }
            cursor.close();
        }
        return list;
    }

    public String getVideoId(String champId) {
        String videoId = "";
        Cursor cursor = database.rawQuery("SELECT video FROM tips_counter WHERE champId = ?", new String[]{champId});
        if (!cursor.moveToFirst()) {
            return videoId;
        }
        cursor.moveToFirst();
        videoId = cursor.getString(cursor.getColumnIndex(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO));
        cursor.close();
        return videoId;
    }

    public List<ModelGridView> getListChampionTag(String tagKey) {
        List<ModelGridView> list = new ArrayList();
        Cursor cursor = database.rawQuery("SELECT name,champId,champKey FROM champion WHERE tags LIKE ? ORDER BY name", new String[]{"%" + tagKey + "%"});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Const.CHAMP_ID));
                list.add(new ModelGridView(id, cursor.getString(cursor.getColumnIndex("name")), id.toLowerCase(), cursor.getString(cursor.getColumnIndex("champKey"))));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public void createDataGuilde(List<ChampGuildeModel> list) {
        try {
            Debug.e(String.valueOf(list.size()));
            ConnectionSource connectionSource = new AndroidConnectionSource(database);
            Dao<ChampGuildeModel, String> system = DaoManager.createDao(connectionSource, ChampGuildeModel.class);
            TableUtils.createTableIfNotExists(connectionSource, ChampGuildeModel.class);
            for (ChampGuildeModel model : list) {
                system.create(model);
            }
            connectionSource.close();
        } catch (Exception e) {
            Debug.e(e.toString());
            e.printStackTrace();
        }
    }

    public boolean updateDataGuilde(String champId, String role, String body) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("body", body);
            if (database.update("champguildemodel", cv, "champId = ? and roleId = ?", new String[]{champId, role}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getChampGuilde(String champId, String role) {
        Cursor cursor = database.rawQuery("SELECT * FROM champguildemodel WHERE champId = ? AND roleId = ?", new String[]{champId, role});
        if (cursor != null) {
            cursor.moveToFirst();
            try {
                String model = cursor.getString(cursor.getColumnIndex("body"));
                cursor.close();
                return model;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public DataRole getDataRole(String champId) {
        String SQLQuery = "SELECT * FROM champguildemodel WHERE champId = ?";
        try {
            Cursor cursor = database.rawQuery(SQLQuery, new String[]{champId});
            if (cursor != null) {
                cursor.moveToFirst();
                ItemFrequent model = (ItemFrequent) new Gson().fromJson(cursor.getString(cursor.getColumnIndex("body")), ItemFrequent.class);
                cursor.close();
                return model.getDataRole();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Item> getListItem(String sqlCommand, String mapId) {
        List<Item> list = new ArrayList();
        Cursor cursor = database.rawQuery(sqlCommand, new String[]{mapId});
        Debug.e(sqlCommand);
        Debug.e(mapId);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                list.add(new Item(cursor.getString(cursor.getColumnIndex(Const.ITEM_ID)), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("goldBase")), cursor.getString(cursor.getColumnIndex("goldTotal")), cursor.getString(cursor.getColumnIndex("into")), cursor.getString(cursor.getColumnIndex("from")), cursor.getString(cursor.getColumnIndex("description"))));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public List<Item> getItemIntoOrFrom(String item) {
        List<Item> list = new ArrayList();
        String[] itemArr = item.replace("[", "").replace("]", "").split(",");
        if (!(itemArr[0].equals("") || itemArr[0].isEmpty())) {
            for (String a : itemArr) {
                Cursor cursor1 = database.rawQuery(SQLConst.SQL_SELECT_ITEM_INTO_AND_FROM, new String[]{a.trim()});
                if (cursor1.moveToFirst()) {
                    cursor1.moveToFirst();
                    list.add(new Item(cursor1.getString(cursor1.getColumnIndex(Const.ITEM_ID)), null, null, cursor1.getString(cursor1.getColumnIndex("goldTotal")), null, null, null));
                    cursor1.close();
                }
            }
        }
        return list;
    }

    public Item getItemInfor(String itemId) {
        Cursor cursor = database.rawQuery(SQLConst.SQL_SELECT_ITEM_WITH_ID, new String[]{itemId});
        if (!cursor.moveToFirst()) {
            return null;
        }
        cursor.moveToFirst();
        Item item = new Item(cursor.getString(cursor.getColumnIndex(Const.ITEM_ID)), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("goldBase")), cursor.getString(cursor.getColumnIndex("goldTotal")), cursor.getString(cursor.getColumnIndex("into")), cursor.getString(cursor.getColumnIndex("from")), cursor.getString(cursor.getColumnIndex("description")));
        cursor.close();
        return item;
    }

    public List<Runes> getListRunes(String sql, String[] param) {
        List<Runes> list = new ArrayList();
        Cursor cursor = database.rawQuery(sql, param);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(new Runes(cursor.getString(cursor.getColumnIndex(Const.ITEM_ID)), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("image")), ""));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public Runes getRune(Context context, String id) {
        Runes rune = null;
        String SQLQuery = "SELECT * FROM runes";
        List<Runes> listRunes = ChampDao.getInstant(context).getListRunes(SQLQuery, null);
        for (Runes runes : listRunes) {
            if (runes.getRuneId().equals(id)) {
                rune = runes;
            }
        }
        return rune;
    }

    public SystemInfo getSystemInfor() {
        SystemInfo systemInfo = null;
        try {
            return (SystemInfo) DaoManager.createDao(new AndroidConnectionSource(database), SystemInfo.class).queryForAll().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return systemInfo;
        }
    }

    public List<TipCounter> getAllTipsCouunter() {
        List<TipCounter> list = null;
        try {
            list = DaoManager.createDao(new AndroidConnectionSource(database), TipCounter.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Mastery getMastery(String masteryId) {
        Mastery mastery = null;
        try {
            return (Mastery) DaoManager.createDao(new AndroidConnectionSource(database), Mastery.class).queryForEq("masteryId", masteryId).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return mastery;
        }
    }

    public List<Mastery> getMastery() {
        List<Mastery> mastery = null;
        try {
            return (List<Mastery>) DaoManager.createDao(new AndroidConnectionSource(database), Mastery.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return mastery;
        }
    }

    public List<vn.lequan.lienminhsamsoi.dao.model.Item> getAllItem() {
        List<vn.lequan.lienminhsamsoi.dao.model.Item> itemList = null;
        try {
            itemList = DaoManager.createDao(new AndroidConnectionSource(database), vn.lequan.lienminhsamsoi.dao.model.Item.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<vn.lequan.lienminhsamsoi.dao.model.Spell> getAllSpell() {
        List<vn.lequan.lienminhsamsoi.dao.model.Spell> itemList = null;
        try {
            itemList = DaoManager.createDao(new AndroidConnectionSource(database), vn.lequan.lienminhsamsoi.dao.model.Spell.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<SpellPassive> getAllSpellPassive() {
        List<SpellPassive> itemList = null;
        try {
            itemList = DaoManager.createDao(new AndroidConnectionSource(database), SpellPassive.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public Language getLanguage() {
        try {
            return (Language) DaoManager.createDao(new AndroidConnectionSource(database), Language.class).queryForAll().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Champion> getAllChampion() {
        List<Champion> itemList = null;
        try {
            itemList = DaoManager.createDao(new AndroidConnectionSource(database), Champion.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
