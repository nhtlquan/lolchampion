package vn.lequan.lienminhsamsoi.dao;

import android.util.Log;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.stmt.query.SimpleComparison;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import vn.lequan.lienminhsamsoi.dao.data.ChampionData;
import vn.lequan.lienminhsamsoi.dao.data.Image;
import vn.lequan.lienminhsamsoi.dao.data.Info;
import vn.lequan.lienminhsamsoi.dao.data.Passive;
import vn.lequan.lienminhsamsoi.dao.data.SkinData;
import vn.lequan.lienminhsamsoi.dao.data.SpellData;
import vn.lequan.lienminhsamsoi.dao.data.Stats;
import vn.lequan.lienminhsamsoi.dao.data.Var;
import vn.lequan.lienminhsamsoi.dao.model.Item;
import vn.lequan.lienminhsamsoi.dao.model.Mastery;
import vn.lequan.lienminhsamsoi.dao.model.Runes;
import vn.lequan.lienminhsamsoi.dao.model.Summoner;

public class AppBase {
    private static AppBase appBase;

    class C14661 extends TypeToken<String[]> {
        C14661() {
        }
    }

    class C14672 extends TypeToken<List<Object>> {
        C14672() {
        }
    }

    class C14683 extends TypeToken<List<Double>> {
        C14683() {
        }
    }

    class C14694 extends TypeToken<List<SkinData>> {
        C14694() {
        }
    }

    public static AppBase getInstance() {
        if (appBase == null) {
            appBase = new AppBase();
        }
        return appBase;
    }

    public String getColor(String paramString) {
        return paramString.replace("<span class=\"color", "<font color=#").replace("\">", SimpleComparison.GREATER_THAN_OPERATION).replace("</span>", "</font>").replace("{{ f1 }}", "").replace("{{ f2 }}", "").replace("{{ f3 }}", "").replace("{{ f4 }}", "").replace("{{ f5 }}", "").replace("{{ f6 }}", "").replace("{{ f7 }}", "").replace("{{ f8 }}", "").replace("{{ f9 }}", "").replace("{{ f10 }}", "");
    }

    public Mastery getMastery(JSONObject jsonObject, String masteryId) {
        try {
            return new Mastery(null, masteryId, jsonObject.getString("name"), jsonObject.getJSONArray("description").toString(), jsonObject.getJSONObject("image").getString("full"), jsonObject.getInt("ranks"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Runes getDataRunes(JSONObject jsonObject, String itemId) throws JSONException {
        String name = jsonObject.getString("name");
        String description = jsonObject.getString("description");
        String image = jsonObject.getJSONObject("image").getString("full");
        JSONObject runeObj = jsonObject.getJSONObject("rune");
        return new Runes(null, itemId, name, description, runeObj.getString(ShareConstants.MEDIA_TYPE), runeObj.getString("tier"), image);
    }
    public Summoner getSummoner(JSONObject jsonObject, String itemId) throws JSONException {
        String id = jsonObject.getString("id");
        String key = jsonObject.getString("key");
        return new Summoner(id,key);
    }

    public Item getDataItem(JSONObject jsonObject, String itemId) throws JSONException {
        Gson gson = new Gson();
        Type listType = new C14661().getType();
        Item item = new Item();
        String name = (String) jsonObject.get("name");
        String description = (String) jsonObject.get("description");
        String tag = Arrays.toString((String[]) gson.fromJson(jsonObject.getJSONArray("tags").toString(), listType));
        JSONObject gold = jsonObject.getJSONObject("gold");
        int total = gold.getInt("total");
        int sell = gold.getInt("sell");
        int base = gold.getInt("base");
        String into = "";
        String from = "";
        try {
            JSONArray intoArr = jsonObject.getJSONArray("into");
            if (intoArr != null) {
                into = Arrays.toString((String[]) gson.fromJson(intoArr.toString(), listType));
            }
        } catch (Exception e) {
            into = "[]";
        }
        try {
            JSONArray fromArr = jsonObject.getJSONArray("from");
            if (fromArr != null) {
                from = Arrays.toString((String[]) gson.fromJson(fromArr.toString(), listType));
            }
        } catch (Exception e2) {
            from = "[]";
        }
        JSONObject mapsObj = jsonObject.getJSONObject("maps");
        Iterator<String> x = mapsObj.keys();
        String maps = "[";
        while (x.hasNext()) {
            String key = (String) x.next();
            if (mapsObj.getBoolean(key)) {
                maps = maps + key + ", ";
            }
        }
        maps = maps.substring(0, maps.length()) + "]";
        item.setItemId(itemId);
        item.setName(name);
        item.setDescription(description);
        item.setTags(tag);
        item.setGoldBase(base);
        item.setGoldSell(sell);
        item.setGoldTotal(total);
        item.setInto(into);
        item.setFrom(from);
        item.setMaps(maps);
        return item;
    }

    public ChampionData getDataChampion(JSONObject jsonObject, String champId) throws JSONException {
        Type listType = new C14672().getType();
        Type listTypeCoeff = new C14683().getType();
        Type listTypeSkin = new C14694().getType();
        ChampionData champ = new ChampionData();
        Gson gson = new Gson();
        JSONObject champion = (JSONObject) ((JSONObject) jsonObject.get("data")).get(champId);
        champ.setId(champId);
        champ.setKey((String) champion.get("key"));
        champ.setName((String) champion.get("name"));
        champ.setTitle((String) champion.get(ShareConstants.WEB_DIALOG_PARAM_TITLE));
        champ.setSkins((List) gson.fromJson(((JSONArray) champion.get("skins")).toString(), listTypeSkin));
        champ.setLore((String) champion.get("lore"));
        champ.setAllytips(((JSONArray) champion.get("allytips")).toString());
        champ.setEnemytips(((JSONArray) champion.get("enemytips")).toString());
        champ.setTags(((JSONArray) champion.get("tags")).toString());
        champ.setInfo((Info) gson.fromJson(((JSONObject) champion.get("info")).toString(), Info.class));
        champ.setStats((Stats) gson.fromJson(((JSONObject) champion.get("stats")).toString(), Stats.class));
        JSONArray spells = (JSONArray) champion.get("spells");
        List<SpellData> listSpell = new ArrayList();
        for (int i = 0; i < spells.length(); i++) {
            String resource;
            SpellData spellObj = new SpellData();
            JSONObject spell = (JSONObject) spells.get(i);
            String idSpell = (String) spell.get(ShareConstants.WEB_DIALOG_PARAM_ID);
            String nameSpell = (String) spell.get("name");
            String tooltip = (String) spell.get("tooltip");
            String costBurn = (String) spell.get("costBurn");
            String cooldownBurn = (String) spell.get("cooldownBurn");
            List<Object> effectBurnObj = (List) gson.fromJson(((JSONArray) spell.get("effectBurn")).toString(), listType);
            JSONArray vars = (JSONArray) spell.get("vars");
            List<Var> listvarsObj = new ArrayList();
            if (vars != null && vars.length() > 0) {
                for (int j = 0; j < vars.length(); j++) {
                    String link;
                    Var varsObj = new Var();
                    JSONObject var = (JSONObject) vars.get(j);
                    try {
                        link = (String) var.get("link");
                    } catch (Exception e) {
                        link = String.valueOf(var.get("multiplier"));
                    }
                    List<Double> coeff = new ArrayList();
                    try {
                        coeff.add(Double.valueOf(var.getDouble("coeff")));
                    } catch (Exception e2) {
                        Log.e("error", champId + " -- " + j);
                        coeff = (List) gson.fromJson(((JSONArray) var.get("coeff")).toString(), listTypeCoeff);
                    }
                    String keyVar = (String) var.get("key");
                    varsObj.setLink(link);
                    varsObj.setKey(keyVar);
                    varsObj.setCoeff(coeff);
                    listvarsObj.add(varsObj);
                }
            }
            String costType = (String) spell.get("costType");
            String rangeBurn = (String) spell.get("rangeBurn");
            Image imageObj = (Image) gson.fromJson(((JSONObject) spell.get("image")).toString(), Image.class);
            try {
                resource = spell.getString("resource");
            } catch (Exception e3) {
                Log.e("errorResource", champId);
                e3.printStackTrace();
                resource = "";
            }
            spellObj.setId(idSpell);
            spellObj.setName(nameSpell);
            spellObj.setTooltip(tooltip);
            spellObj.setCooldownBurn(cooldownBurn);
            spellObj.setCostBurn(costBurn);
            spellObj.setEffectBurn(effectBurnObj);
            spellObj.setVars(listvarsObj);
            spellObj.setRangeBurn(rangeBurn);
            spellObj.setImage(imageObj);
            spellObj.setResource(resource);
            spellObj.setCostType(costType);
            listSpell.add(spellObj);
        }
        champ.setSpells(listSpell);
        JSONObject passive = (JSONObject) champion.get("passive");
        Passive passiveObj = new Passive();
        String descriptionP = (String) passive.get("description");
        Image imagePObj = (Image) gson.fromJson(((JSONObject) passive.get("image")).toString(), Image.class);
        passiveObj.setName((String) passive.get("name"));
        passiveObj.setDescription(descriptionP);
        passiveObj.setImage(imagePObj);
        champ.setPassive(passiveObj);
        return champ;
    }
}
