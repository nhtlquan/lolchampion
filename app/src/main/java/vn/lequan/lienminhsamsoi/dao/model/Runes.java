package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "runes")
public class Runes {
    @DatabaseField
    private String description;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String image;
    @DatabaseField
    private String itemId;
    @DatabaseField
    private String name;
    @DatabaseField
    private String tier;
    @DatabaseField
    private String type;

    public Runes(Integer id, String itemId, String name, String description, String type, String tier, String image) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.tier = tier;
        this.image = image;
    }

    public Runes() {
    }

    public Runes(Integer id) {
        this.id = id;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTier() {
        return this.tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
