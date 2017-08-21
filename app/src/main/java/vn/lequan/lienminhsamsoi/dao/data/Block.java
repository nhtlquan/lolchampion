package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Block {
    @SerializedName("hideIfSummonerSpell")
    @Expose
    private String hideIfSummonerSpell;
    @SerializedName("items")
    @Expose
    private List<ItemData> items = new ArrayList();
    @SerializedName("maxSummonerLevel")
    @Expose
    private Integer maxSummonerLevel;
    @SerializedName("minSummonerLevel")
    @Expose
    private Integer minSummonerLevel;
    @SerializedName("recMath")
    @Expose
    private Boolean recMath;
    @SerializedName("recSteps")
    @Expose
    private Boolean recSteps;
    @SerializedName("showIfSummonerSpell")
    @Expose
    private String showIfSummonerSpell;
    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRecMath() {
        return this.recMath;
    }

    public void setRecMath(Boolean recMath) {
        this.recMath = recMath;
    }

    public Boolean getRecSteps() {
        return this.recSteps;
    }

    public void setRecSteps(Boolean recSteps) {
        this.recSteps = recSteps;
    }

    public Integer getMinSummonerLevel() {
        return this.minSummonerLevel;
    }

    public void setMinSummonerLevel(Integer minSummonerLevel) {
        this.minSummonerLevel = minSummonerLevel;
    }

    public Integer getMaxSummonerLevel() {
        return this.maxSummonerLevel;
    }

    public void setMaxSummonerLevel(Integer maxSummonerLevel) {
        this.maxSummonerLevel = maxSummonerLevel;
    }

    public String getShowIfSummonerSpell() {
        return this.showIfSummonerSpell;
    }

    public void setShowIfSummonerSpell(String showIfSummonerSpell) {
        this.showIfSummonerSpell = showIfSummonerSpell;
    }

    public String getHideIfSummonerSpell() {
        return this.hideIfSummonerSpell;
    }

    public void setHideIfSummonerSpell(String hideIfSummonerSpell) {
        this.hideIfSummonerSpell = hideIfSummonerSpell;
    }

    public List<ItemData> getItems() {
        return this.items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }
}
