package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SpellData {
    @SerializedName("cooldown")
    @Expose
    private List<Integer> cooldown = new ArrayList();
    @SerializedName("cooldownBurn")
    @Expose
    private String cooldownBurn;
    @SerializedName("cost")
    @Expose
    private List<Integer> cost = new ArrayList();
    @SerializedName("costBurn")
    @Expose
    private String costBurn;
    @SerializedName("costType")
    @Expose
    private String costType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("effect")
    @Expose
    private List<Object> effect = new ArrayList();
    @SerializedName("effectBurn")
    @Expose
    private List<Object> effectBurn = new ArrayList();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("leveltip")
    @Expose
    private Leveltip leveltip;
    @SerializedName("maxammo")
    @Expose
    private String maxammo;
    @SerializedName("maxrank")
    @Expose
    private Integer maxrank;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("range")
    @Expose
    private List<Integer> range = new ArrayList();
    @SerializedName("rangeBurn")
    @Expose
    private String rangeBurn;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("tooltip")
    @Expose
    private String tooltip;
    @SerializedName("vars")
    @Expose
    private List<Var> vars = new ArrayList();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public Leveltip getLeveltip() {
        return this.leveltip;
    }

    public void setLeveltip(Leveltip leveltip) {
        this.leveltip = leveltip;
    }

    public Integer getMaxrank() {
        return this.maxrank;
    }

    public void setMaxrank(Integer maxrank) {
        this.maxrank = maxrank;
    }

    public List<Integer> getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(List<Integer> cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return this.cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public List<Integer> getCost() {
        return this.cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public String getCostBurn() {
        return this.costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public List<Object> getEffect() {
        return this.effect;
    }

    public void setEffect(List<Object> effect) {
        this.effect = effect;
    }

    public List<Object> getEffectBurn() {
        return this.effectBurn;
    }

    public void setEffectBurn(List<Object> effectBurn) {
        this.effectBurn = effectBurn;
    }

    public List<Var> getVars() {
        return this.vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    public String getCostType() {
        return this.costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getMaxammo() {
        return this.maxammo;
    }

    public void setMaxammo(String maxammo) {
        this.maxammo = maxammo;
    }

    public List<Integer> getRange() {
        return this.range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public String getRangeBurn() {
        return this.rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getResource() {
        return this.resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
