package vn.lequan.lienminhsamsoi.models;

public class Lore {
    private float armor;
    private float armorPerLevel;
    private float attackDamage;
    private float attackDamagePerLevel;
    private int attackRange;
    private int attackRank;
    private float attackSpeedPerLevel;
    private int costIp;
    private int costRp;
    private int defenseRank;
    private int difficultyRank;
    private float hp;
    private int hpPerLevel;
    private float hpRegen;
    private float hpRegenPerLevel;
    private String id;
    private String image;
    private String lore;
    private int magicRank;
    private int moveSpeed;
    private float mp;
    private int mpPerLevel;
    private float mpRegen;
    private float mpRegenPerLevel;
    private String name;
    private float spellBlock;
    private float spellBlockPerLevel;
    private String title;

    public Lore() {
    }

    public Lore(String id, float armor, float armorPerLevel, float attackDamage, float attackDamagePerLevel, int attackRange, int attackRank, float attackSpeedPerLevel, int costIp, int costRp, int defenseRank, int difficultyRank, float hp, int hpPerLevel, float hpRegen, float hpRegenPerLevel, String image, String lore, int magicRank, int moveSpeed, float mp, int mpPerLevel, float mpRegen, float mpRegenPerLevel, String name, float spellBlock, float spellBlockPerLevel, String title) {
        this.id = id;
        this.armor = armor;
        this.armorPerLevel = armorPerLevel;
        this.attackDamage = attackDamage;
        this.attackDamagePerLevel = attackDamagePerLevel;
        this.attackRange = attackRange;
        this.attackRank = attackRank;
        this.attackSpeedPerLevel = attackSpeedPerLevel;
        this.costIp = costIp;
        this.costRp = costRp;
        this.defenseRank = defenseRank;
        this.difficultyRank = difficultyRank;
        this.hp = hp;
        this.hpPerLevel = hpPerLevel;
        this.hpRegen = hpRegen;
        this.hpRegenPerLevel = hpRegenPerLevel;
        this.image = image;
        this.lore = lore;
        this.magicRank = magicRank;
        this.moveSpeed = moveSpeed;
        this.mp = mp;
        this.mpPerLevel = mpPerLevel;
        this.mpRegen = mpRegen;
        this.mpRegenPerLevel = mpRegenPerLevel;
        this.name = name;
        this.spellBlock = spellBlock;
        this.spellBlockPerLevel = spellBlockPerLevel;
        this.title = title;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getArmor() {
        return this.armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public float getArmorPerLevel() {
        return this.armorPerLevel;
    }

    public void setArmorPerLevel(float armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

    public float getAttackDamagePerLevel() {
        return this.attackDamagePerLevel;
    }

    public void setAttackDamagePerLevel(float attackDamagePerLevel) {
        this.attackDamagePerLevel = attackDamagePerLevel;
    }

    public int getAttackRange() {
        return this.attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackRank() {
        return this.attackRank;
    }

    public void setAttackRank(int attackRank) {
        this.attackRank = attackRank;
    }

    public float getAttackSpeedPerLevel() {
        return this.attackSpeedPerLevel;
    }

    public void setAttackSpeedPerLevel(float attackSpeedPerLevel) {
        this.attackSpeedPerLevel = attackSpeedPerLevel;
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

    public int getDefenseRank() {
        return this.defenseRank;
    }

    public void setDefenseRank(int defenseRank) {
        this.defenseRank = defenseRank;
    }

    public int getDifficultyRank() {
        return this.difficultyRank;
    }

    public void setDifficultyRank(int difficultyRank) {
        this.difficultyRank = difficultyRank;
    }

    public float getHp() {
        return this.hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getHpPerLevel() {
        return this.hpPerLevel;
    }

    public void setHpPerLevel(int hpPerLevel) {
        this.hpPerLevel = hpPerLevel;
    }

    public float getHpRegen() {
        return this.hpRegen;
    }

    public void setHpRegen(float hpRegen) {
        this.hpRegen = hpRegen;
    }

    public float getHpRegenPerLevel() {
        return this.hpRegenPerLevel;
    }

    public void setHpRegenPerLevel(float hpRegenPerLevel) {
        this.hpRegenPerLevel = hpRegenPerLevel;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLore() {
        return this.lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public int getMagicRank() {
        return this.magicRank;
    }

    public void setMagicRank(int magicRank) {
        this.magicRank = magicRank;
    }

    public int getMoveSpeed() {
        return this.moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getMp() {
        return this.mp;
    }

    public void setMp(float mp) {
        this.mp = mp;
    }

    public int getMpPerLevel() {
        return this.mpPerLevel;
    }

    public void setMpPerLevel(int mpPerLevel) {
        this.mpPerLevel = mpPerLevel;
    }

    public float getMpRegen() {
        return this.mpRegen;
    }

    public void setMpRegen(float mpRegen) {
        this.mpRegen = mpRegen;
    }

    public float getMpRegenPerLevel() {
        return this.mpRegenPerLevel;
    }

    public void setMpRegenPerLevel(float mpRegenPerLevel) {
        this.mpRegenPerLevel = mpRegenPerLevel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSpellBlock() {
        return this.spellBlock;
    }

    public void setSpellBlock(float spellBlock) {
        this.spellBlock = spellBlock;
    }

    public float getSpellBlockPerLevel() {
        return this.spellBlockPerLevel;
    }

    public void setSpellBlockPerLevel(float spellBlockPerLevel) {
        this.spellBlockPerLevel = spellBlockPerLevel;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
