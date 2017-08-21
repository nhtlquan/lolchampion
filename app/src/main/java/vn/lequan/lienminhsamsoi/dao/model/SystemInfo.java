package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "system")
public class SystemInfo {
    @DatabaseField
    private Integer id;
    @DatabaseField
    private String language;
    @DatabaseField
    private String updateTime;
    @DatabaseField
    private String version;

    public SystemInfo() {
    }

    public SystemInfo(Integer id, String version, String updateTime, String language) {
        this.id = id;
        this.version = version;
        this.updateTime = updateTime;
        this.language = language;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
