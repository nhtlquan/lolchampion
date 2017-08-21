package vn.lequan.lienminhsamsoi.models;

public class Spell {
    private String cooldown;
    private String cost;
    private String detail;
    private String image;
    private String name;
    private String range;
    private String spellId;

    public Spell(String spellId, String image, String name, String cooldown, String cost, String range, String detail) {
        this.spellId = spellId;
        this.image = image;
        this.name = name;
        this.cooldown = cooldown;
        this.cost = cost;
        this.range = range;
        this.detail = detail;
    }

    public String getSpellId() {
        return this.spellId;
    }

    public void setSpellId(String spellId) {
        this.spellId = spellId;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(String cooldown) {
        this.cooldown = cooldown;
    }

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
