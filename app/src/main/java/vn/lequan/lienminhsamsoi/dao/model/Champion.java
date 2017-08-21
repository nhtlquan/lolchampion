package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "champion")
public class Champion {
    @DatabaseField
    private String allytips;
    @DatabaseField
    private double armor;
    @DatabaseField
    private double armorPerLevel;
    @DatabaseField
    private double attackDamage;
    @DatabaseField
    private double attackDamagePerLevel;
    @DatabaseField
    private double attackRange;
    @DatabaseField
    private int attackRank;
    @DatabaseField
    private double attackSpeedOffset;
    @DatabaseField
    private double attackSpeedPerLevel;
    @DatabaseField
    private String champId;
    @DatabaseField
    private String champKey;
    @DatabaseField
    private int costIp;
    @DatabaseField
    private int costRp;
    @DatabaseField
    private int defenseRank;
    @DatabaseField
    private int difficultyRank;
    @DatabaseField
    private String enemytips;
    @DatabaseField
    private int freeToPlay;
    @DatabaseField
    private double hp;
    @DatabaseField
    private double hpPerLevel;
    @DatabaseField
    private double hpRegen;
    @DatabaseField
    private double hpRegenPerLevel;
    @DatabaseField(columnName = "_id")
    private Integer id;
    @DatabaseField
    private String lore;
    @DatabaseField
    private int magicRank;
    @DatabaseField
    private double moveSpeed;
    @DatabaseField
    private double mp;
    @DatabaseField
    private double mpPerLevel;
    @DatabaseField
    private double mpRegen;
    @DatabaseField
    private double mpRegenPerLevel;
    @DatabaseField
    private String name;
    @DatabaseField
    private double spellBlock;
    @DatabaseField
    private double spellBlockPerLevel;
    @DatabaseField
    private String tags;
    @DatabaseField
    private String title;

    public Champion() {
    }

    public Champion(Integer id) {
        this.id = id;
    }

    public Champion(Integer id, String champId, String champKey, int freeToPlay, String tags, String strongAgainst, String weakAgainst, int costIp, int costRp, int attackRank, int defenseRank, int magicRank, int difficultyRank, String name, String title, String lore, double armor, double armorPerLevel, double attackDamage, double attackDamagePerLevel, double attackRange, double attackSpeedOffset, double attackSpeedPerLevel, double hp, double hpPerLevel, double hpRegen, double hpRegenPerLevel, double moveSpeed, double mp, double mpPerLevel, double mpRegen, double mpRegenPerLevel, double spellBlock, double spellBlockPerLevel) {
        this.id = id;
        this.champId = champId;
        this.champKey = champKey;
        this.freeToPlay = freeToPlay;
        this.tags = tags;
        this.allytips = strongAgainst;
        this.enemytips = weakAgainst;
        this.costIp = costIp;
        this.costRp = costRp;
        this.attackRank = attackRank;
        this.defenseRank = defenseRank;
        this.magicRank = magicRank;
        this.difficultyRank = difficultyRank;
        this.name = name;
        this.title = title;
        this.lore = lore;
        this.armor = armor;
        this.armorPerLevel = armorPerLevel;
        this.attackDamage = attackDamage;
        this.attackDamagePerLevel = attackDamagePerLevel;
        this.attackRange = attackRange;
        this.attackSpeedOffset = attackSpeedOffset;
        this.attackSpeedPerLevel = attackSpeedPerLevel;
        this.hp = hp;
        this.hpPerLevel = hpPerLevel;
        this.hpRegen = hpRegen;
        this.hpRegenPerLevel = hpRegenPerLevel;
        this.moveSpeed = moveSpeed;
        this.mp = mp;
        this.mpPerLevel = mpPerLevel;
        this.mpRegen = mpRegen;
        this.mpRegenPerLevel = mpRegenPerLevel;
        this.spellBlock = spellBlock;
        this.spellBlockPerLevel = spellBlockPerLevel;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChampId() {
        return this.champId;
    }

    public void setChampId(String champId) {
        this.champId = champId;
    }

    public String getChampKey() {
        return this.champKey;
    }

    public void setChampKey(String champKey) {
        this.champKey = champKey;
    }

    public int getFreeToPlay() {
        return this.freeToPlay;
    }

    public void setFreeToPlay(int freeToPlay) {
        this.freeToPlay = freeToPlay;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStrongAgainst() {
        return this.allytips;
    }

    public void setStrongAgainst(String strongAgainst) {
        this.allytips = strongAgainst;
    }

    public String getWeakAgainst() {
        return this.enemytips;
    }

    public void setWeakAgainst(String weakAgainst) {
        this.enemytips = weakAgainst;
    }

    public int getCostIp() {
        return this.costIp;
    }

    public void setCostIp(int costIp) {
        this.costIp = costIp;
    }

    public int getCostRp() {
        return this.costRp;
    }

    public void setCostRp(int costRp) {
        this.costRp = costRp;
    }

    public int getAttackRank() {
        return this.attackRank;
    }

    public void setAttackRank(int attackRank) {
        this.attackRank = attackRank;
    }

    public int getDefenseRank() {
        return this.defenseRank;
    }

    public void setDefenseRank(int defenseRank) {
        this.defenseRank = defenseRank;
    }

    public int getMagicRank() {
        return this.magicRank;
    }

    public void setMagicRank(int magicRank) {
        this.magicRank = magicRank;
    }

    public int getDifficultyRank() {
        return this.difficultyRank;
    }

    public void setDifficultyRank(int difficultyRank) {
        this.difficultyRank = difficultyRank;
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

    public String getLore() {
        return this.lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public double getArmor() {
        return this.armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getArmorPerLevel() {
        return this.armorPerLevel;
    }

    public void setArmorPerLevel(double armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    public double getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackDamagePerLevel() {
        return this.attackDamagePerLevel;
    }

    public void setAttackDamagePerLevel(double attackDamagePerLevel) {
        this.attackDamagePerLevel = attackDamagePerLevel;
    }

    public double getAttackRange() {
        return this.attackRange;
    }

    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    public double getAttackSpeedOffset() {
        return this.attackSpeedOffset;
    }

    public void setAttackSpeedOffset(double attackSpeedOffset) {
        this.attackSpeedOffset = attackSpeedOffset;
    }

    public double getAttackSpeedPerLevel() {
        return this.attackSpeedPerLevel;
    }

    public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
        this.attackSpeedPerLevel = attackSpeedPerLevel;
    }

    public double getHp() {
        return this.hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHpPerLevel() {
        return this.hpPerLevel;
    }

    public void setHpPerLevel(double hpPerLevel) {
        this.hpPerLevel = hpPerLevel;
    }

    public double getHpRegen() {
        return this.hpRegen;
    }

    public void setHpRegen(double hpRegen) {
        this.hpRegen = hpRegen;
    }

    public double getHpRegenPerLevel() {
        return this.hpRegenPerLevel;
    }

    public void setHpRegenPerLevel(double hpRegenPerLevel) {
        this.hpRegenPerLevel = hpRegenPerLevel;
    }

    public double getMoveSpeed() {
        return this.moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public double getMp() {
        return this.mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public double getMpPerLevel() {
        return this.mpPerLevel;
    }

    public void setMpPerLevel(double mpPerLevel) {
        this.mpPerLevel = mpPerLevel;
    }

    public double getMpRegen() {
        return this.mpRegen;
    }

    public void setMpRegen(double mpRegen) {
        this.mpRegen = mpRegen;
    }

    public double getMpRegenPerLevel() {
        return this.mpRegenPerLevel;
    }

    public void setMpRegenPerLevel(double mpRegenPerLevel) {
        this.mpRegenPerLevel = mpRegenPerLevel;
    }

    public double getSpellBlock() {
        return this.spellBlock;
    }

    public void setSpellBlock(double spellBlock) {
        this.spellBlock = spellBlock;
    }

    public double getSpellBlockPerLevel() {
        return this.spellBlockPerLevel;
    }

    public void setSpellBlockPerLevel(double spellBlockPerLevel) {
        this.spellBlockPerLevel = spellBlockPerLevel;
    }
}
