package vn.lequan.lienminhsamsoi.models;

import java.util.List;

public class ChampBuild {
    private String accoutId;
    private String champId;
    private String createTime;
    private int id;
    private List<Item> itemCore;
    private List<Item> itemDamage;
    private List<Item> itemDefense;
    private List<Item> itemFull;
    private List<Item> itemStart;
    private int likeCount;
    private List<Runes> runesList;
    private String spellD;
    private String spellF;
    private String title;
    private String updateTime;

    public ChampBuild(int id, String champId, String accoutId, String title, int likeCount, String spellD, String spellF, List<Runes> runesList, List<Item> itemStart, List<Item> itemCore, List<Item> itemDefense, List<Item> itemDamage, List<Item> itemFull, String createTime, String updateTime) {
        this.id = id;
        this.champId = champId;
        this.accoutId = accoutId;
        this.title = title;
        this.likeCount = likeCount;
        this.spellD = spellD;
        this.spellF = spellF;
        this.runesList = runesList;
        this.itemStart = itemStart;
        this.itemCore = itemCore;
        this.itemDefense = itemDefense;
        this.itemDamage = itemDamage;
        this.itemFull = itemFull;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccoutId() {
        return this.accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getSpellD() {
        return this.spellD;
    }

    public void setSpellD(String spellD) {
        this.spellD = spellD;
    }

    public String getSpellF() {
        return this.spellF;
    }

    public void setSpellF(String spellF) {
        this.spellF = spellF;
    }

    public List<Runes> getRunesList() {
        return this.runesList;
    }

    public void setRunesList(List<Runes> runesList) {
        this.runesList = runesList;
    }

    public List<Item> getItemStart() {
        return this.itemStart;
    }

    public void setItemStart(List<Item> itemStart) {
        this.itemStart = itemStart;
    }

    public List<Item> getItemCore() {
        return this.itemCore;
    }

    public void setItemCore(List<Item> itemCore) {
        this.itemCore = itemCore;
    }

    public List<Item> getItemDefense() {
        return this.itemDefense;
    }

    public void setItemDefense(List<Item> itemDefense) {
        this.itemDefense = itemDefense;
    }

    public List<Item> getItemDamage() {
        return this.itemDamage;
    }

    public void setItemDamage(List<Item> itemDamage) {
        this.itemDamage = itemDamage;
    }

    public List<Item> getItemFull() {
        return this.itemFull;
    }

    public void setItemFull(List<Item> itemFull) {
        this.itemFull = itemFull;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
