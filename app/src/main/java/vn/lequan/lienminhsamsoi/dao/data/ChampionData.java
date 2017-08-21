package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ChampionData {
    @SerializedName("allytips")
    @Expose
    private String allytips;
    @SerializedName("blurb")
    @Expose
    private String blurb;
    @SerializedName("enemytips")
    @Expose
    private String enemytips;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("lore")
    @Expose
    private String lore;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("partype")
    @Expose
    private String partype;
    @SerializedName("passive")
    @Expose
    private Passive passive;
    @SerializedName("recommended")
    @Expose
    private List<Recommended> recommended = new ArrayList();
    @SerializedName("skins")
    @Expose
    private List<SkinData> skins = new ArrayList();
    @SerializedName("spells")
    @Expose
    private List<SpellData> spells = new ArrayList();
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<SkinData> getSkins() {
        return this.skins;
    }

    public void setSkins(List<SkinData> skins) {
        this.skins = skins;
    }

    public String getLore() {
        return this.lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getBlurb() {
        return this.blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getAllytips() {
        return this.allytips;
    }

    public void setAllytips(String allytips) {
        this.allytips = allytips;
    }

    public String getEnemytips() {
        return this.enemytips;
    }

    public void setEnemytips(String enemytips) {
        this.enemytips = enemytips;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPartype() {
        return this.partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<SpellData> getSpells() {
        return this.spells;
    }

    public void setSpells(List<SpellData> spells) {
        this.spells = spells;
    }

    public Passive getPassive() {
        return this.passive;
    }

    public void setPassive(Passive passive) {
        this.passive = passive;
    }

    public List<Recommended> getRecommended() {
        return this.recommended;
    }

    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }
}
