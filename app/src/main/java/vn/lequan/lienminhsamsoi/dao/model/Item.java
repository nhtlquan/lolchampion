package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "item")
public class Item {
    @DatabaseField
    private String description;
    @DatabaseField
    private String from;
    @DatabaseField
    private int goldBase;
    @DatabaseField
    private int goldSell;
    @DatabaseField
    private int goldTotal;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String into;
    @DatabaseField
    private String itemId;
    @DatabaseField
    private String maps;
    @DatabaseField
    private String name;
    @DatabaseField
    private int purchasable;
    @DatabaseField
    private String tags;

    public Item(Integer id) {
        this.id = id;
    }

    public Item() {
    }

    public Item(Integer id, String itemId, String name, String description, int goldBase, int goldSell, int goldTotal, int purchasable) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.goldBase = goldBase;
        this.goldSell = goldSell;
        this.goldTotal = goldTotal;
        this.purchasable = purchasable;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGoldBase() {
        return this.goldBase;
    }

    public void setGoldBase(int goldBase) {
        this.goldBase = goldBase;
    }

    public int getGoldSell() {
        return this.goldSell;
    }

    public void setGoldSell(int goldSell) {
        this.goldSell = goldSell;
    }

    public int getGoldTotal() {
        return this.goldTotal;
    }

    public void setGoldTotal(int goldTotal) {
        this.goldTotal = goldTotal;
    }

    public int getPurchasable() {
        return this.purchasable;
    }

    public void setPurchasable(int purchasable) {
        this.purchasable = purchasable;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInto() {
        return this.into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMaps() {
        return this.maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }
}
