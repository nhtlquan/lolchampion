package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "spell_passive")
public class SpellPassive {
    @DatabaseField
    private String champId;
    @DatabaseField
    private String description;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String image;
    @DatabaseField
    private String name;

    public SpellPassive(Integer id) {
        this.id = id;
    }

    public SpellPassive() {
    }

    public SpellPassive(Integer id, String champId, String name, String description, String image) {
        this.id = id;
        this.champId = champId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
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
}
