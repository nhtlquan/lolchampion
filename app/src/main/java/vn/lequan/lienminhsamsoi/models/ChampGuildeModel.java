package vn.lequan.lienminhsamsoi.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ChampGuildeModel {
    @DatabaseField
    private String body;
    @DatabaseField(uniqueCombo = true)
    private String champId;
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(uniqueCombo = true)
    private String roleId;

    public ChampGuildeModel() {
    }

    public ChampGuildeModel(Integer id, String champId, String roleId, String body) {
        this.id = id;
        this.champId = champId;
        this.roleId = roleId;
        this.body = body;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
