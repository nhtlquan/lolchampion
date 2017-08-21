package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("h")
    @Expose
    private Integer f57h;
    @SerializedName("sprite")
    @Expose
    private String sprite;
    @SerializedName("w")
    @Expose
    private Integer f58w;
    @SerializedName("x")
    @Expose
    private Integer f59x;
    @SerializedName("y")
    @Expose
    private Integer f60y;

    public String getFull() {
        return this.full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getSprite() {
        return this.sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getX() {
        return this.f59x;
    }

    public void setX(Integer x) {
        this.f59x = x;
    }

    public Integer getY() {
        return this.f60y;
    }

    public void setY(Integer y) {
        this.f60y = y;
    }

    public Integer getW() {
        return this.f58w;
    }

    public void setW(Integer w) {
        this.f58w = w;
    }

    public Integer getH() {
        return this.f57h;
    }

    public void setH(Integer h) {
        this.f57h = h;
    }
}
