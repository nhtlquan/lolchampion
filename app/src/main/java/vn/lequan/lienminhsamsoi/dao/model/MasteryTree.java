package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mastery_tree")
public class MasteryTree {
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String masteryId;
    @DatabaseField
    private String slot1;
    @DatabaseField
    private String slot2;
    @DatabaseField
    private String slot3;
    @DatabaseField
    private String slot4;
    @DatabaseField
    private String slot5;
    @DatabaseField
    private String slot6;
    @DatabaseField
    private String tree;

    public MasteryTree(Integer id, String tree, String slot1, String slot2, String slot3, String slot4, String slot5, String slot6, String masteryId) {
        this.id = id;
        this.tree = tree;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;
        this.slot5 = slot5;
        this.slot6 = slot6;
        this.masteryId = masteryId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTree() {
        return this.tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public String getSlot1() {
        return this.slot1;
    }

    public void setSlot1(String slot1) {
        this.slot1 = slot1;
    }

    public String getSlot2() {
        return this.slot2;
    }

    public void setSlot2(String slot2) {
        this.slot2 = slot2;
    }

    public String getSlot3() {
        return this.slot3;
    }

    public void setSlot3(String slot3) {
        this.slot3 = slot3;
    }

    public String getSlot4() {
        return this.slot4;
    }

    public void setSlot4(String slot4) {
        this.slot4 = slot4;
    }

    public String getSlot5() {
        return this.slot5;
    }

    public void setSlot5(String slot5) {
        this.slot5 = slot5;
    }

    public String getSlot6() {
        return this.slot6;
    }

    public void setSlot6(String slot6) {
        this.slot6 = slot6;
    }

    public String getMasteryId() {
        return this.masteryId;
    }

    public void setMasteryId(String masteryId) {
        this.masteryId = masteryId;
    }
}
