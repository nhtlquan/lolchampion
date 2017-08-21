package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("armor")
    @Expose
    private Double armor;
    @SerializedName("armorperlevel")
    @Expose
    private Double armorperlevel;
    @SerializedName("attackdamage")
    @Expose
    private Double attackdamage;
    @SerializedName("attackdamageperlevel")
    @Expose
    private Double attackdamageperlevel;
    @SerializedName("attackrange")
    @Expose
    private Double attackrange;
    @SerializedName("attackspeedoffset")
    @Expose
    private Double attackspeedoffset;
    @SerializedName("attackspeedperlevel")
    @Expose
    private Double attackspeedperlevel;
    @SerializedName("crit")
    @Expose
    private Double crit;
    @SerializedName("critperlevel")
    @Expose
    private Double critperlevel;
    @SerializedName("hp")
    @Expose
    private Double hp;
    @SerializedName("hpperlevel")
    @Expose
    private Double hpperlevel;
    @SerializedName("hpregen")
    @Expose
    private Double hpregen;
    @SerializedName("hpregenperlevel")
    @Expose
    private Double hpregenperlevel;
    @SerializedName("movespeed")
    @Expose
    private Double movespeed;
    @SerializedName("mp")
    @Expose
    private Double mp;
    @SerializedName("mpperlevel")
    @Expose
    private Double mpperlevel;
    @SerializedName("mpregen")
    @Expose
    private Double mpregen;
    @SerializedName("mpregenperlevel")
    @Expose
    private Double mpregenperlevel;
    @SerializedName("spellblock")
    @Expose
    private Double spellblock;
    @SerializedName("spellblockperlevel")
    @Expose
    private Double spellblockperlevel;

    public Double getHp() {
        return this.hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getHpperlevel() {
        return this.hpperlevel;
    }

    public void setHpperlevel(Double hpperlevel) {
        this.hpperlevel = hpperlevel;
    }

    public Double getMp() {
        return this.mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }

    public Double getMpperlevel() {
        return this.mpperlevel;
    }

    public void setMpperlevel(Double mpperlevel) {
        this.mpperlevel = mpperlevel;
    }

    public Double getMovespeed() {
        return this.movespeed;
    }

    public void setMovespeed(Double movespeed) {
        this.movespeed = movespeed;
    }

    public Double getArmor() {
        return this.armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getArmorperlevel() {
        return this.armorperlevel;
    }

    public void setArmorperlevel(Double armorperlevel) {
        this.armorperlevel = armorperlevel;
    }

    public Double getSpellblock() {
        return this.spellblock;
    }

    public void setSpellblock(Double spellblock) {
        this.spellblock = spellblock;
    }

    public Double getSpellblockperlevel() {
        return this.spellblockperlevel;
    }

    public void setSpellblockperlevel(Double spellblockperlevel) {
        this.spellblockperlevel = spellblockperlevel;
    }

    public Double getAttackrange() {
        return this.attackrange;
    }

    public void setAttackrange(Double attackrange) {
        this.attackrange = attackrange;
    }

    public Double getHpregen() {
        return this.hpregen;
    }

    public void setHpregen(Double hpregen) {
        this.hpregen = hpregen;
    }

    public Double getHpregenperlevel() {
        return this.hpregenperlevel;
    }

    public void setHpregenperlevel(Double hpregenperlevel) {
        this.hpregenperlevel = hpregenperlevel;
    }

    public Double getMpregen() {
        return this.mpregen;
    }

    public void setMpregen(Double mpregen) {
        this.mpregen = mpregen;
    }

    public Double getMpregenperlevel() {
        return this.mpregenperlevel;
    }

    public void setMpregenperlevel(Double mpregenperlevel) {
        this.mpregenperlevel = mpregenperlevel;
    }

    public Double getCrit() {
        return this.crit;
    }

    public void setCrit(Double crit) {
        this.crit = crit;
    }

    public Double getCritperlevel() {
        return this.critperlevel;
    }

    public void setCritperlevel(Double critperlevel) {
        this.critperlevel = critperlevel;
    }

    public Double getAttackdamage() {
        return this.attackdamage;
    }

    public void setAttackdamage(Double attackdamage) {
        this.attackdamage = attackdamage;
    }

    public Double getAttackdamageperlevel() {
        return this.attackdamageperlevel;
    }

    public void setAttackdamageperlevel(Double attackdamageperlevel) {
        this.attackdamageperlevel = attackdamageperlevel;
    }

    public Double getAttackspeedoffset() {
        return this.attackspeedoffset;
    }

    public void setAttackspeedoffset(Double attackspeedoffset) {
        this.attackspeedoffset = attackspeedoffset;
    }

    public Double getAttackspeedperlevel() {
        return this.attackspeedperlevel;
    }

    public void setAttackspeedperlevel(Double attackspeedperlevel) {
        this.attackspeedperlevel = attackspeedperlevel;
    }
}
