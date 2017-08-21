package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "skin")
public class Skin {
    @DatabaseField
    private String champId;
    @DatabaseField
    private int costRp;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private int num;
    @DatabaseField
    private String skinId;

    public Skin(Integer id) {
        this.id = id;
    }

    public Skin() {
    }

    public Skin(Integer id, String skinId, String champId, int costRp, String name, int num) {
        this.id = id;
        this.skinId = skinId;
        this.champId = champId;
        this.costRp = costRp;
        this.name = name;
        this.num = num;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkinId() {
        return this.skinId;
    }

    public void setSkinId(String skinId) {
        this.skinId = skinId;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public int getCostRp() {
        return this.costRp;
    }

    public void setCostRp(int costRp) {
        this.costRp = costRp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
