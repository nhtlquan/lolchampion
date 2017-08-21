package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mastery")
public class Mastery {
    @DatabaseField
    private String description;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String image;
    @DatabaseField
    private String masteryId;
    @DatabaseField
    private String name;
    @DatabaseField
    private int ranks;

    public Mastery() {
    }

    public Mastery(Integer id, String masteryId, String name, String description, String image, int ranks) {
        this.id = id;
        this.masteryId = masteryId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.ranks = ranks;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMasteryId() {
        return this.masteryId;
    }

    public void setMasteryId(String masteryId) {
        this.masteryId = masteryId;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRanks() {
        return this.ranks;
    }

    public void setRanks(int ranks) {
        this.ranks = ranks;
    }
}
