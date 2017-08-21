package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "spell")
public class Spell {
    @DatabaseField
    private String champId;
    @DatabaseField
    private String cooldownBurn;
    @DatabaseField
    private String costBurn;
    @DatabaseField
    private String costType;
    @DatabaseField
    private String description;
    @DatabaseField
    private int f61i;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String image;
    @DatabaseField
    private int maxRank;
    @DatabaseField
    private String name;
    @DatabaseField
    private String rangeBurn;
    @DatabaseField
    private String resource;
    @DatabaseField
    private String spellId;

    public Spell(Integer id) {
        this.id = id;
    }

    public Spell(Integer id, String spellId, String champId, int i, String name, String description, String resource, String cooldownBurn, String costBurn, String costType, int maxRank, String rangeBurn, String image) {
        this.id = id;
        this.spellId = spellId;
        this.champId = champId;
        this.f61i = i;
        this.name = name;
        this.description = description;
        this.resource = resource;
        this.cooldownBurn = cooldownBurn;
        this.costBurn = costBurn;
        this.costType = costType;
        this.maxRank = maxRank;
        this.rangeBurn = rangeBurn;
        this.image = image;
    }

    public Spell() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpellId() {
        return this.spellId;
    }

    public void setSpellId(String spellId) {
        this.spellId = spellId;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public int getI() {
        return this.f61i;
    }

    public void setI(int i) {
        this.f61i = i;
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

    public String getResource() {
        return this.resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getCooldownBurn() {
        return this.cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public String getCostBurn() {
        return this.costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return this.costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public int getMaxRank() {
        return this.maxRank;
    }

    public void setMaxRank(int maxRank) {
        this.maxRank = maxRank;
    }

    public String getRangeBurn() {
        return this.rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
