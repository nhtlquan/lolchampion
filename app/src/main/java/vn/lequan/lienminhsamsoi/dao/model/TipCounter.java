package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tips_counter")
public class TipCounter {
    @DatabaseField
    private String champId;
    @DatabaseField
    private String release;
    @DatabaseField
    private String soundText;
    @DatabaseField
    private String strongAgainst;
    @DatabaseField
    private String video;
    @DatabaseField
    private String weakAgainst;

    public TipCounter() {
    }

    public TipCounter(String champId, String release, String strongAgainst, String weakAgainst, String video, String soundText) {
        this.champId = champId;
        this.release = release;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
        this.video = video;
        this.soundText = soundText;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getStrongAgainst() {
        return this.strongAgainst;
    }

    public void setStrongAgainst(String strongAgainst) {
        this.strongAgainst = strongAgainst;
    }

    public String getWeakAgainst() {
        return this.weakAgainst;
    }

    public void setWeakAgainst(String weakAgainst) {
        this.weakAgainst = weakAgainst;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getSoundText() {
        return this.soundText;
    }

    public void setSoundText(String soundText) {
        this.soundText = soundText;
    }
}
