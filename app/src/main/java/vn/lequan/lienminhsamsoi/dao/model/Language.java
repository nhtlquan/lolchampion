package vn.lequan.lienminhsamsoi.dao.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "language")
public class Language {
    @DatabaseField
    private String FlatMovementSpeedMod;
    @DatabaseField
    private String PlayingAs;
    @DatabaseField
    private String _continue;
    @DatabaseField
    private String abilities;
    @DatabaseField
    private String active;
    @DatabaseField
    private String allItems;
    @DatabaseField
    private String armor;
    @DatabaseField
    private String armorPenetration;
    @DatabaseField
    private String assassin;
    @DatabaseField
    private String attack;
    @DatabaseField
    private String attackSpeed;
    @DatabaseField
    private String aura;
    @DatabaseField
    private String back;
    @DatabaseField
    private String boots;
    @DatabaseField
    private String builds;
    @DatabaseField
    private String buttonBuy;
    @DatabaseField
    private String buttonSell;
    @DatabaseField
    private String categoryChampion;
    @DatabaseField
    private String categoryItem;
    @DatabaseField
    private String categoryMastery;
    @DatabaseField
    private String categoryRune;
    @DatabaseField
    private String categorySummoner;
    @DatabaseField
    private String championInfo;
    @DatabaseField
    private String consumable;
    @DatabaseField
    private String cooldownReduction;
    @DatabaseField
    private String cost;
    @DatabaseField
    private String criticalStrike;
    @DatabaseField
    private String damage;
    @DatabaseField
    private String defense;
    @DatabaseField
    private String details;
    @DatabaseField
    private String fighter;
    @DatabaseField
    private String gold;
    @DatabaseField
    private String goldPer;
    @DatabaseField
    private String health;
    @DatabaseField
    private String healthRegen;
    @DatabaseField
    private String itemInfo;
    @DatabaseField
    private String language;
    @DatabaseField
    private String level;
    @DatabaseField
    private String lifeSteal;
    @DatabaseField
    private String lore;
    @DatabaseField
    private String mage;
    @DatabaseField
    private String magic;
    @DatabaseField
    private String magicPenetration;
    @DatabaseField
    private String mana;
    @DatabaseField
    private String manaRegen;
    @DatabaseField
    private String map1;
    @DatabaseField
    private String map10;
    @DatabaseField
    private String map12;
    @DatabaseField
    private String map8;
    @DatabaseField
    private String marksman;
    @DatabaseField
    private String masteryCunning;
    @DatabaseField
    private String masteryFerocity;
    @DatabaseField
    private String masteryResolve;
    @DatabaseField
    private String mobileNews;
    @DatabaseField
    private String mobilePleaseWait;
    @DatabaseField
    private String modeTutorial;
    @DatabaseField
    private String movement;
    @DatabaseField
    private String nativeAr;
    @DatabaseField
    private String nativeBg;
    @DatabaseField
    private String nativeCs;
    @DatabaseField
    private String nativeDe;
    @DatabaseField
    private String nativeEl;
    @DatabaseField
    private String nativeEn;
    @DatabaseField
    private String nativeEs;
    @DatabaseField
    private String nativeFr;
    @DatabaseField
    private String nativeHu;
    @DatabaseField
    private String nativeId;
    @DatabaseField
    private String nativeIt;
    @DatabaseField
    private String nativeJa;
    @DatabaseField
    private String nativeKo;
    @DatabaseField
    private String nativeNl;
    @DatabaseField
    private String nativePl;
    @DatabaseField
    private String nativePt;
    @DatabaseField
    private String nativeRo;
    @DatabaseField
    private String nativeRu;
    @DatabaseField
    private String nativeTh;
    @DatabaseField
    private String nativeTr;
    @DatabaseField
    private String nativeVn;
    @DatabaseField
    private String nativeZh;
    @DatabaseField
    private String nativeZhCN;
    @DatabaseField
    private String nativeZhMY;
    @DatabaseField
    private String nativeZhTW;
    @DatabaseField
    private String nonbootsMovement;
    @DatabaseField
    private String originalCost;
    @DatabaseField
    private String playingAgainst;
    @DatabaseField
    private String primaryRole;
    @DatabaseField
    private String rFlatHPModPerLevel;
    @DatabaseField
    private String range;
    @DatabaseField
    private String recommendedConsumables;
    @DatabaseField
    private String recommendedDefensive;
    @DatabaseField
    private String recommendedEssential;
    @DatabaseField
    private String recommendedItems;
    @DatabaseField
    private String recommendedOffensive;
    @DatabaseField
    private String recommendedStarting;
    @DatabaseField
    private String require;
    @DatabaseField
    private String sellsFor;
    @DatabaseField
    private String slow;
    @DatabaseField
    private String specialRecipeLarge;
    @DatabaseField
    private String spellBlock;
    @DatabaseField
    private String spellDamage;
    @DatabaseField
    private String spellVamp;
    @DatabaseField
    private String statAbility;
    @DatabaseField
    private String statAttack;
    @DatabaseField
    private String statDefense;
    @DatabaseField
    private String statDifficulty;
    @DatabaseField
    private String statUtility;
    @DatabaseField
    private String stats;
    @DatabaseField
    private String support;
    @DatabaseField
    private String tank;
    @DatabaseField
    private String tenacity;
    @DatabaseField
    private String tips;
    @DatabaseField
    private String upgradeCost;

    public Language(String back, String _continue, String language, String itemInfo, String playingAgainst, String range, String details, String primaryRole, String mobilePleaseWait, String mobileNews, String modeTutorial, String map1, String map8, String map10, String map12, String categoryChampion, String categoryItem, String categoryMastery, String categoryRune, String categorySummoner, String gold, String level, String abilities, String championInfo, String lore, String stats, String tips, String statAbility, String statAttack, String statDefense, String statDifficulty, String statUtility, String assassin, String fighter, String marksman, String mage, String support, String tank, String allItems, String armor, String attack, String attackSpeed, String consumable, String cooldownReduction, String criticalStrike, String damage, String defense, String health, String healthRegen, String lifeSteal, String magic, String mana, String manaRegen, String movement, String spellBlock, String spellDamage, String boots, String nonbootsMovement, String tenacity, String spellVamp, String goldPer, String slow, String aura, String active, String magicPenetration, String armorPenetration, String recommendedItems, String recommendedStarting, String recommendedEssential, String recommendedOffensive, String recommendedDefensive, String recommendedConsumables, String require, String cost, String originalCost, String sellsFor, String upgradeCost, String builds, String buttonBuy, String buttonSell, String specialRecipeLarge, String masteryFerocity, String masteryCunning, String masteryResolve, String nativeAr, String nativeBg, String nativeCs, String nativeDe, String nativeEl, String nativeEn, String nativeEs, String nativeFr, String nativeHu, String nativeId, String nativeIt, String nativeJa, String nativeKo, String nativeNl, String nativePl, String nativePt, String nativeRo, String nativeRu, String nativeTh, String nativeTr, String nativeVn, String nativeZh, String nativeZhCN, String nativeZhMY, String nativeZhTW, String rFlatHPModPerLevel, String FlatMovementSpeedMod, String PlayingAs) {
        this.back = back;
        this._continue = _continue;
        this.language = language;
        this.itemInfo = itemInfo;
        this.playingAgainst = playingAgainst;
        this.range = range;
        this.details = details;
        this.primaryRole = primaryRole;
        this.mobilePleaseWait = mobilePleaseWait;
        this.mobileNews = mobileNews;
        this.modeTutorial = modeTutorial;
        this.map1 = map1;
        this.map8 = map8;
        this.map10 = map10;
        this.map12 = map12;
        this.categoryChampion = categoryChampion;
        this.categoryItem = categoryItem;
        this.categoryMastery = categoryMastery;
        this.categoryRune = categoryRune;
        this.categorySummoner = categorySummoner;
        this.gold = gold;
        this.level = level;
        this.abilities = abilities;
        this.championInfo = championInfo;
        this.lore = lore;
        this.stats = stats;
        this.tips = tips;
        this.statAbility = statAbility;
        this.statAttack = statAttack;
        this.statDefense = statDefense;
        this.statDifficulty = statDifficulty;
        this.statUtility = statUtility;
        this.assassin = assassin;
        this.fighter = fighter;
        this.marksman = marksman;
        this.mage = mage;
        this.support = support;
        this.tank = tank;
        this.allItems = allItems;
        this.armor = armor;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.consumable = consumable;
        this.cooldownReduction = cooldownReduction;
        this.criticalStrike = criticalStrike;
        this.damage = damage;
        this.defense = defense;
        this.health = health;
        this.healthRegen = healthRegen;
        this.lifeSteal = lifeSteal;
        this.magic = magic;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.movement = movement;
        this.spellBlock = spellBlock;
        this.spellDamage = spellDamage;
        this.boots = boots;
        this.nonbootsMovement = nonbootsMovement;
        this.tenacity = tenacity;
        this.spellVamp = spellVamp;
        this.goldPer = goldPer;
        this.slow = slow;
        this.aura = aura;
        this.active = active;
        this.magicPenetration = magicPenetration;
        this.armorPenetration = armorPenetration;
        this.recommendedItems = recommendedItems;
        this.recommendedStarting = recommendedStarting;
        this.recommendedEssential = recommendedEssential;
        this.recommendedOffensive = recommendedOffensive;
        this.recommendedDefensive = recommendedDefensive;
        this.recommendedConsumables = recommendedConsumables;
        this.require = require;
        this.cost = cost;
        this.originalCost = originalCost;
        this.sellsFor = sellsFor;
        this.upgradeCost = upgradeCost;
        this.builds = builds;
        this.buttonBuy = buttonBuy;
        this.buttonSell = buttonSell;
        this.specialRecipeLarge = specialRecipeLarge;
        this.masteryFerocity = masteryFerocity;
        this.masteryCunning = masteryCunning;
        this.masteryResolve = masteryResolve;
        this.nativeAr = nativeAr;
        this.nativeBg = nativeBg;
        this.nativeCs = nativeCs;
        this.nativeDe = nativeDe;
        this.nativeEl = nativeEl;
        this.nativeEn = nativeEn;
        this.nativeEs = nativeEs;
        this.nativeFr = nativeFr;
        this.nativeHu = nativeHu;
        this.nativeId = nativeId;
        this.nativeIt = nativeIt;
        this.nativeJa = nativeJa;
        this.nativeKo = nativeKo;
        this.nativeNl = nativeNl;
        this.nativePl = nativePl;
        this.nativePt = nativePt;
        this.nativeRo = nativeRo;
        this.nativeRu = nativeRu;
        this.nativeTh = nativeTh;
        this.nativeTr = nativeTr;
        this.nativeVn = nativeVn;
        this.nativeZh = nativeZh;
        this.nativeZhCN = nativeZhCN;
        this.nativeZhMY = nativeZhMY;
        this.nativeZhTW = nativeZhTW;
        this.rFlatHPModPerLevel = rFlatHPModPerLevel;
        this.FlatMovementSpeedMod = FlatMovementSpeedMod;
        this.PlayingAs = PlayingAs;
    }

    public Language() {
    }

    public String getPlayingAs() {
        return this.PlayingAs;
    }

    public String getFlatMovementSpeedMod() {
        return this.FlatMovementSpeedMod;
    }

    public String getBack() {
        return this.back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String get_continue() {
        return this._continue;
    }

    public void set_continue(String _continue) {
        this._continue = _continue;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getItemInfo() {
        return this.itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getPlayingAgainst() {
        return this.playingAgainst;
    }

    public void setPlayingAgainst(String playingAgainst) {
        this.playingAgainst = playingAgainst;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrimaryRole() {
        return this.primaryRole;
    }

    public void setPrimaryRole(String primaryRole) {
        this.primaryRole = primaryRole;
    }

    public String getMobilePleaseWait() {
        return this.mobilePleaseWait;
    }

    public void setMobilePleaseWait(String mobilePleaseWait) {
        this.mobilePleaseWait = mobilePleaseWait;
    }

    public String getMobileNews() {
        return this.mobileNews;
    }

    public void setMobileNews(String mobileNews) {
        this.mobileNews = mobileNews;
    }

    public String getModeTutorial() {
        return this.modeTutorial;
    }

    public void setModeTutorial(String modeTutorial) {
        this.modeTutorial = modeTutorial;
    }

    public String getMap1() {
        return this.map1;
    }

    public void setMap1(String map1) {
        this.map1 = map1;
    }

    public String getMap8() {
        return this.map8;
    }

    public void setMap8(String map8) {
        this.map8 = map8;
    }

    public String getMap10() {
        return this.map10;
    }

    public void setMap10(String map10) {
        this.map10 = map10;
    }

    public String getMap12() {
        return this.map12;
    }

    public void setMap12(String map12) {
        this.map12 = map12;
    }

    public String getCategoryChampion() {
        return this.categoryChampion;
    }

    public void setCategoryChampion(String categoryChampion) {
        this.categoryChampion = categoryChampion;
    }

    public String getCategoryItem() {
        return this.categoryItem;
    }

    public void setCategoryItem(String categoryItem) {
        this.categoryItem = categoryItem;
    }

    public String getCategoryMastery() {
        return this.categoryMastery;
    }

    public void setCategoryMastery(String categoryMastery) {
        this.categoryMastery = categoryMastery;
    }

    public String getCategoryRune() {
        return this.categoryRune;
    }

    public void setCategoryRune(String categoryRune) {
        this.categoryRune = categoryRune;
    }

    public String getCategorySummoner() {
        return this.categorySummoner;
    }

    public void setCategorySummoner(String categorySummoner) {
        this.categorySummoner = categorySummoner;
    }

    public String getGold() {
        return this.gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAbilities() {
        return this.abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getChampionInfo() {
        return this.championInfo;
    }

    public void setChampionInfo(String championInfo) {
        this.championInfo = championInfo;
    }

    public String getLore() {
        return this.lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getStats() {
        return this.stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getStatAbility() {
        return this.statAbility;
    }

    public void setStatAbility(String statAbility) {
        this.statAbility = statAbility;
    }

    public String getStatAttack() {
        return this.statAttack;
    }

    public void setStatAttack(String statAttack) {
        this.statAttack = statAttack;
    }

    public String getStatDefense() {
        return this.statDefense;
    }

    public void setStatDefense(String statDefense) {
        this.statDefense = statDefense;
    }

    public String getStatDifficulty() {
        return this.statDifficulty;
    }

    public void setStatDifficulty(String statDifficulty) {
        this.statDifficulty = statDifficulty;
    }

    public String getStatUtility() {
        return this.statUtility;
    }

    public void setStatUtility(String statUtility) {
        this.statUtility = statUtility;
    }

    public String getAssassin() {
        return this.assassin;
    }

    public void setAssassin(String assassin) {
        this.assassin = assassin;
    }

    public String getFighter() {
        return this.fighter;
    }

    public void setFighter(String fighter) {
        this.fighter = fighter;
    }

    public String getMarksman() {
        return this.marksman;
    }

    public void setMarksman(String marksman) {
        this.marksman = marksman;
    }

    public String getMage() {
        return this.mage;
    }

    public void setMage(String mage) {
        this.mage = mage;
    }

    public String getSupport() {
        return this.support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getTank() {
        return this.tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public String getAllItems() {
        return this.allItems;
    }

    public void setAllItems(String allItems) {
        this.allItems = allItems;
    }

    public String getArmor() {
        return this.armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getAttack() {
        return this.attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getAttackSpeed() {
        return this.attackSpeed;
    }

    public void setAttackSpeed(String attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getConsumable() {
        return this.consumable;
    }

    public void setConsumable(String consumable) {
        this.consumable = consumable;
    }

    public String getCooldownReduction() {
        return this.cooldownReduction;
    }

    public void setCooldownReduction(String cooldownReduction) {
        this.cooldownReduction = cooldownReduction;
    }

    public String getCriticalStrike() {
        return this.criticalStrike;
    }

    public void setCriticalStrike(String criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    public String getDamage() {
        return this.damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDefense() {
        return this.defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getHealth() {
        return this.health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthRegen() {
        return this.healthRegen;
    }

    public void setHealthRegen(String healthRegen) {
        this.healthRegen = healthRegen;
    }

    public String getLifeSteal() {
        return this.lifeSteal;
    }

    public void setLifeSteal(String lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    public String getMagic() {
        return this.magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getMana() {
        return this.mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getManaRegen() {
        return this.manaRegen;
    }

    public void setManaRegen(String manaRegen) {
        this.manaRegen = manaRegen;
    }

    public String getMovement() {
        return this.movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getSpellBlock() {
        return this.spellBlock;
    }

    public void setSpellBlock(String spellBlock) {
        this.spellBlock = spellBlock;
    }

    public String getSpellDamage() {
        return this.spellDamage;
    }

    public void setSpellDamage(String spellDamage) {
        this.spellDamage = spellDamage;
    }

    public String getBoots() {
        return this.boots;
    }

    public void setBoots(String boots) {
        this.boots = boots;
    }

    public String getNonbootsMovement() {
        return this.nonbootsMovement;
    }

    public void setNonbootsMovement(String nonbootsMovement) {
        this.nonbootsMovement = nonbootsMovement;
    }

    public String getTenacity() {
        return this.tenacity;
    }

    public void setTenacity(String tenacity) {
        this.tenacity = tenacity;
    }

    public String getSpellVamp() {
        return this.spellVamp;
    }

    public void setSpellVamp(String spellVamp) {
        this.spellVamp = spellVamp;
    }

    public String getGoldPer() {
        return this.goldPer;
    }

    public void setGoldPer(String goldPer) {
        this.goldPer = goldPer;
    }

    public String getSlow() {
        return this.slow;
    }

    public void setSlow(String slow) {
        this.slow = slow;
    }

    public String getAura() {
        return this.aura;
    }

    public void setAura(String aura) {
        this.aura = aura;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getMagicPenetration() {
        return this.magicPenetration;
    }

    public void setMagicPenetration(String magicPenetration) {
        this.magicPenetration = magicPenetration;
    }

    public String getArmorPenetration() {
        return this.armorPenetration;
    }

    public void setArmorPenetration(String armorPenetration) {
        this.armorPenetration = armorPenetration;
    }

    public String getRecommendedItems() {
        return this.recommendedItems;
    }

    public void setRecommendedItems(String recommendedItems) {
        this.recommendedItems = recommendedItems;
    }

    public String getRecommendedStarting() {
        return this.recommendedStarting;
    }

    public void setRecommendedStarting(String recommendedStarting) {
        this.recommendedStarting = recommendedStarting;
    }

    public String getRecommendedEssential() {
        return this.recommendedEssential;
    }

    public void setRecommendedEssential(String recommendedEssential) {
        this.recommendedEssential = recommendedEssential;
    }

    public String getRecommendedOffensive() {
        return this.recommendedOffensive;
    }

    public void setRecommendedOffensive(String recommendedOffensive) {
        this.recommendedOffensive = recommendedOffensive;
    }

    public String getRecommendedDefensive() {
        return this.recommendedDefensive;
    }

    public void setRecommendedDefensive(String recommendedDefensive) {
        this.recommendedDefensive = recommendedDefensive;
    }

    public String getRecommendedConsumables() {
        return this.recommendedConsumables;
    }

    public void setRecommendedConsumables(String recommendedConsumables) {
        this.recommendedConsumables = recommendedConsumables;
    }

    public String getRequire() {
        return this.require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOriginalCost() {
        return this.originalCost;
    }

    public void setOriginalCost(String originalCost) {
        this.originalCost = originalCost;
    }

    public String getSellsFor() {
        return this.sellsFor;
    }

    public void setSellsFor(String sellsFor) {
        this.sellsFor = sellsFor;
    }

    public String getUpgradeCost() {
        return this.upgradeCost;
    }

    public void setUpgradeCost(String upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public String getBuilds() {
        return this.builds;
    }

    public void setBuilds(String builds) {
        this.builds = builds;
    }

    public String getButtonBuy() {
        return this.buttonBuy;
    }

    public void setButtonBuy(String buttonBuy) {
        this.buttonBuy = buttonBuy;
    }

    public String getButtonSell() {
        return this.buttonSell;
    }

    public void setButtonSell(String buttonSell) {
        this.buttonSell = buttonSell;
    }

    public String getSpecialRecipeLarge() {
        return this.specialRecipeLarge;
    }

    public void setSpecialRecipeLarge(String specialRecipeLarge) {
        this.specialRecipeLarge = specialRecipeLarge;
    }

    public String getMasteryFerocity() {
        return this.masteryFerocity;
    }

    public void setMasteryFerocity(String masteryFerocity) {
        this.masteryFerocity = masteryFerocity;
    }

    public String getMasteryCunning() {
        return this.masteryCunning;
    }

    public void setMasteryCunning(String masteryCunning) {
        this.masteryCunning = masteryCunning;
    }

    public String getMasteryResolve() {
        return this.masteryResolve;
    }

    public void setMasteryResolve(String masteryResolve) {
        this.masteryResolve = masteryResolve;
    }

    public String getNativeAr() {
        return this.nativeAr;
    }

    public void setNativeAr(String nativeAr) {
        this.nativeAr = nativeAr;
    }

    public String getNativeBg() {
        return this.nativeBg;
    }

    public void setNativeBg(String nativeBg) {
        this.nativeBg = nativeBg;
    }

    public String getNativeCs() {
        return this.nativeCs;
    }

    public void setNativeCs(String nativeCs) {
        this.nativeCs = nativeCs;
    }

    public String getNativeDe() {
        return this.nativeDe;
    }

    public void setNativeDe(String nativeDe) {
        this.nativeDe = nativeDe;
    }

    public String getNativeEl() {
        return this.nativeEl;
    }

    public void setNativeEl(String nativeEl) {
        this.nativeEl = nativeEl;
    }

    public String getNativeEn() {
        return this.nativeEn;
    }

    public void setNativeEn(String nativeEn) {
        this.nativeEn = nativeEn;
    }

    public String getNativeEs() {
        return this.nativeEs;
    }

    public void setNativeEs(String nativeEs) {
        this.nativeEs = nativeEs;
    }

    public String getNativeFr() {
        return this.nativeFr;
    }

    public void setNativeFr(String nativeFr) {
        this.nativeFr = nativeFr;
    }

    public String getNativeHu() {
        return this.nativeHu;
    }

    public void setNativeHu(String nativeHu) {
        this.nativeHu = nativeHu;
    }

    public String getNativeId() {
        return this.nativeId;
    }

    public void setNativeId(String nativeId) {
        this.nativeId = nativeId;
    }

    public String getNativeIt() {
        return this.nativeIt;
    }

    public void setNativeIt(String nativeIt) {
        this.nativeIt = nativeIt;
    }

    public String getNativeJa() {
        return this.nativeJa;
    }

    public void setNativeJa(String nativeJa) {
        this.nativeJa = nativeJa;
    }

    public String getNativeKo() {
        return this.nativeKo;
    }

    public void setNativeKo(String nativeKo) {
        this.nativeKo = nativeKo;
    }

    public String getNativeNl() {
        return this.nativeNl;
    }

    public void setNativeNl(String nativeNl) {
        this.nativeNl = nativeNl;
    }

    public String getNativePl() {
        return this.nativePl;
    }

    public void setNativePl(String nativePl) {
        this.nativePl = nativePl;
    }

    public String getNativePt() {
        return this.nativePt;
    }

    public void setNativePt(String nativePt) {
        this.nativePt = nativePt;
    }

    public String getNativeRo() {
        return this.nativeRo;
    }

    public void setNativeRo(String nativeRo) {
        this.nativeRo = nativeRo;
    }

    public String getNativeRu() {
        return this.nativeRu;
    }

    public void setNativeRu(String nativeRu) {
        this.nativeRu = nativeRu;
    }

    public String getNativeTh() {
        return this.nativeTh;
    }

    public void setNativeTh(String nativeTh) {
        this.nativeTh = nativeTh;
    }

    public String getNativeTr() {
        return this.nativeTr;
    }

    public void setNativeTr(String nativeTr) {
        this.nativeTr = nativeTr;
    }

    public String getNativeVn() {
        return this.nativeVn;
    }

    public void setNativeVn(String nativeVn) {
        this.nativeVn = nativeVn;
    }

    public String getNativeZh() {
        return this.nativeZh;
    }

    public void setNativeZh(String nativeZh) {
        this.nativeZh = nativeZh;
    }

    public String getNativeZhCN() {
        return this.nativeZhCN;
    }

    public void setNativeZhCN(String nativeZhCN) {
        this.nativeZhCN = nativeZhCN;
    }

    public String getNativeZhMY() {
        return this.nativeZhMY;
    }

    public void setNativeZhMY(String nativeZhMY) {
        this.nativeZhMY = nativeZhMY;
    }

    public String getNativeZhTW() {
        return this.nativeZhTW;
    }

    public void setNativeZhTW(String nativeZhTW) {
        this.nativeZhTW = nativeZhTW;
    }

    public String getrFlatHPModPerLevel() {
        return this.rFlatHPModPerLevel;
    }

    public void setrFlatHPModPerLevel(String rFlatHPModPerLevel) {
        this.rFlatHPModPerLevel = rFlatHPModPerLevel;
    }
}
