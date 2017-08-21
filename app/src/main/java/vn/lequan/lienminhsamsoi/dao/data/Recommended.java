package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Recommended {
    @SerializedName("blocks")
    @Expose
    private List<Block> blocks = new ArrayList();
    @SerializedName("champion")
    @Expose
    private String champion;
    @SerializedName("customPanel")
    @Expose
    private Object customPanel;
    @SerializedName("customTag")
    @Expose
    private String customTag;
    @SerializedName("extensionPage")
    @Expose
    private Boolean extensionPage;
    @SerializedName("map")
    @Expose
    private String map;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;

    public String getChampion() {
        return this.champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMap() {
        return this.map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomTag() {
        return this.customTag;
    }

    public void setCustomTag(String customTag) {
        this.customTag = customTag;
    }

    public Boolean getExtensionPage() {
        return this.extensionPage;
    }

    public void setExtensionPage(Boolean extensionPage) {
        this.extensionPage = extensionPage;
    }

    public Object getCustomPanel() {
        return this.customPanel;
    }

    public void setCustomPanel(Object customPanel) {
        this.customPanel = customPanel;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
