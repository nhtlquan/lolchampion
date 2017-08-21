package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemData {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("hideCount")
    @Expose
    private Boolean hideCount;
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getHideCount() {
        return this.hideCount;
    }

    public void setHideCount(Boolean hideCount) {
        this.hideCount = hideCount;
    }
}
