
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Stats {

    @SerializedName("participantId")
    @Expose
    private BigInteger participantId;
    @SerializedName("win")
    @Expose
    private Boolean win;
    @SerializedName("item0")
    @Expose
    private BigInteger item0;
    @SerializedName("item1")
    @Expose
    private BigInteger item1;
    @SerializedName("item2")
    @Expose
    private BigInteger item2;
    @SerializedName("item3")
    @Expose
    private BigInteger item3;
    @SerializedName("item4")
    @Expose
    private BigInteger item4;
    @SerializedName("item5")
    @Expose
    private BigInteger item5;
    @SerializedName("item6")
    @Expose
    private BigInteger item6;
    @SerializedName("kills")
    @Expose
    private BigInteger kills;
    @SerializedName("deaths")
    @Expose
    private BigInteger deaths;
    @SerializedName("assists")
    @Expose
    private BigInteger assists;
    @SerializedName("largestKillingSpree")
    @Expose
    private BigInteger largestKillingSpree;
    @SerializedName("largestMultiKill")
    @Expose
    private BigInteger largestMultiKill;
    @SerializedName("killingSprees")
    @Expose
    private BigInteger killingSprees;
    @SerializedName("longestTimeSpentLiving")
    @Expose
    private BigInteger longestTimeSpentLiving;
    @SerializedName("doubleKills")
    @Expose
    private BigInteger doubleKills;
    @SerializedName("tripleKills")
    @Expose
    private BigInteger tripleKills;
    @SerializedName("quadraKills")
    @Expose
    private BigInteger quadraKills;
    @SerializedName("pentaKills")
    @Expose
    private BigInteger pentaKills;
    @SerializedName("unrealKills")
    @Expose
    private BigInteger unrealKills;
    @SerializedName("totalDamageDealt")
    @Expose
    private BigInteger totalDamageDealt;
    @SerializedName("magicDamageDealt")
    @Expose
    private BigInteger magicDamageDealt;
    @SerializedName("physicalDamageDealt")
    @Expose
    private BigInteger physicalDamageDealt;
    @SerializedName("trueDamageDealt")
    @Expose
    private BigInteger trueDamageDealt;
    @SerializedName("largestCriticalStrike")
    @Expose
    private BigInteger largestCriticalStrike;
    @SerializedName("totalDamageDealtToChampions")
    @Expose
    private BigInteger totalDamageDealtToChampions;
    @SerializedName("magicDamageDealtToChampions")
    @Expose
    private BigInteger magicDamageDealtToChampions;
    @SerializedName("physicalDamageDealtToChampions")
    @Expose
    private BigInteger physicalDamageDealtToChampions;
    @SerializedName("trueDamageDealtToChampions")
    @Expose
    private BigInteger trueDamageDealtToChampions;
    @SerializedName("totalHeal")
    @Expose
    private BigInteger totalHeal;
    @SerializedName("totalUnitsHealed")
    @Expose
    private BigInteger totalUnitsHealed;
    @SerializedName("damageSelfMitigated")
    @Expose
    private BigInteger damageSelfMitigated;
    @SerializedName("damageDealtToObjectives")
    @Expose
    private BigInteger damageDealtToObjectives;
    @SerializedName("damageDealtToTurrets")
    @Expose
    private BigInteger damageDealtToTurrets;
    @SerializedName("visionScore")
    @Expose
    private BigInteger visionScore;
    @SerializedName("timeCCingOthers")
    @Expose
    private BigInteger timeCCingOthers;
    @SerializedName("totalDamageTaken")
    @Expose
    private BigInteger totalDamageTaken;
    @SerializedName("magicalDamageTaken")
    @Expose
    private BigInteger magicalDamageTaken;
    @SerializedName("physicalDamageTaken")
    @Expose
    private BigInteger physicalDamageTaken;
    @SerializedName("trueDamageTaken")
    @Expose
    private BigInteger trueDamageTaken;
    @SerializedName("goldEarned")
    @Expose
    private int goldEarned;
    @SerializedName("goldSpent")
    @Expose
    private BigInteger goldSpent;
    @SerializedName("turretKills")
    @Expose
    private BigInteger turretKills;
    @SerializedName("inhibitorKills")
    @Expose
    private BigInteger inhibitorKills;
    @SerializedName("totalMinionsKilled")
    @Expose
    private BigInteger totalMinionsKilled;
    @SerializedName("neutralMinionsKilled")
    @Expose
    private BigInteger neutralMinionsKilled;
    @SerializedName("neutralMinionsKilledTeamJungle")
    @Expose
    private BigInteger neutralMinionsKilledTeamJungle;
    @SerializedName("neutralMinionsKilledEnemyJungle")
    @Expose
    private BigInteger neutralMinionsKilledEnemyJungle;
    @SerializedName("totalTimeCrowdControlDealt")
    @Expose
    private BigInteger totalTimeCrowdControlDealt;
    @SerializedName("champLevel")
    @Expose
    private BigInteger champLevel;
    @SerializedName("visionWardsBoughtInGame")
    @Expose
    private BigInteger visionWardsBoughtInGame;
    @SerializedName("sightWardsBoughtInGame")
    @Expose
    private BigInteger sightWardsBoughtInGame;
    @SerializedName("wardsPlaced")
    @Expose
    private BigInteger wardsPlaced;
    @SerializedName("wardsKilled")
    @Expose
    private BigInteger wardsKilled;
    @SerializedName("firstBloodKill")
    @Expose
    private Boolean firstBloodKill;
    @SerializedName("firstBloodAssist")
    @Expose
    private Boolean firstBloodAssist;
    @SerializedName("firstTowerKill")
    @Expose
    private Boolean firstTowerKill;
    @SerializedName("firstTowerAssist")
    @Expose
    private Boolean firstTowerAssist;
    @SerializedName("combatPlayerScore")
    @Expose
    private BigInteger combatPlayerScore;
    @SerializedName("objectivePlayerScore")
    @Expose
    private BigInteger objectivePlayerScore;
    @SerializedName("totalPlayerScore")
    @Expose
    private BigInteger totalPlayerScore;
    @SerializedName("totalScoreRank")
    @Expose
    private BigInteger totalScoreRank;

    public BigInteger getParticipantId() {
        return participantId;
    }

    public void setParticipantId(BigInteger participantId) {
        this.participantId = participantId;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public BigInteger getItem0() {
        return item0;
    }

    public void setItem0(BigInteger item0) {
        this.item0 = item0;
    }

    public BigInteger getItem1() {
        return item1;
    }

    public void setItem1(BigInteger item1) {
        this.item1 = item1;
    }

    public BigInteger getItem2() {
        return item2;
    }

    public void setItem2(BigInteger item2) {
        this.item2 = item2;
    }

    public BigInteger getItem3() {
        return item3;
    }

    public void setItem3(BigInteger item3) {
        this.item3 = item3;
    }

    public BigInteger getItem4() {
        return item4;
    }

    public void setItem4(BigInteger item4) {
        this.item4 = item4;
    }

    public BigInteger getItem5() {
        return item5;
    }

    public void setItem5(BigInteger item5) {
        this.item5 = item5;
    }

    public BigInteger getItem6() {
        return item6;
    }

    public void setItem6(BigInteger item6) {
        this.item6 = item6;
    }

    public BigInteger getKills() {
        return kills;
    }

    public void setKills(BigInteger kills) {
        this.kills = kills;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public void setDeaths(BigInteger deaths) {
        this.deaths = deaths;
    }

    public BigInteger getAssists() {
        return assists;
    }

    public void setAssists(BigInteger assists) {
        this.assists = assists;
    }

    public BigInteger getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(BigInteger largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public BigInteger getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(BigInteger largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public BigInteger getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(BigInteger killingSprees) {
        this.killingSprees = killingSprees;
    }

    public BigInteger getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public void setLongestTimeSpentLiving(BigInteger longestTimeSpentLiving) {
        this.longestTimeSpentLiving = longestTimeSpentLiving;
    }

    public BigInteger getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(BigInteger doubleKills) {
        this.doubleKills = doubleKills;
    }

    public BigInteger getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(BigInteger tripleKills) {
        this.tripleKills = tripleKills;
    }

    public BigInteger getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(BigInteger quadraKills) {
        this.quadraKills = quadraKills;
    }

    public BigInteger getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(BigInteger pentaKills) {
        this.pentaKills = pentaKills;
    }

    public BigInteger getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(BigInteger unrealKills) {
        this.unrealKills = unrealKills;
    }

    public BigInteger getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(BigInteger totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public BigInteger getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(BigInteger magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public BigInteger getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(BigInteger physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public BigInteger getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(BigInteger trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public BigInteger getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(BigInteger largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public BigInteger getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(BigInteger totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public BigInteger getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(BigInteger magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public BigInteger getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(BigInteger physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public BigInteger getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(BigInteger trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public BigInteger getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(BigInteger totalHeal) {
        this.totalHeal = totalHeal;
    }

    public BigInteger getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(BigInteger totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public BigInteger getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public void setDamageSelfMitigated(BigInteger damageSelfMitigated) {
        this.damageSelfMitigated = damageSelfMitigated;
    }

    public BigInteger getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public void setDamageDealtToObjectives(BigInteger damageDealtToObjectives) {
        this.damageDealtToObjectives = damageDealtToObjectives;
    }

    public BigInteger getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public void setDamageDealtToTurrets(BigInteger damageDealtToTurrets) {
        this.damageDealtToTurrets = damageDealtToTurrets;
    }

    public BigInteger getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(BigInteger visionScore) {
        this.visionScore = visionScore;
    }

    public BigInteger getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public void setTimeCCingOthers(BigInteger timeCCingOthers) {
        this.timeCCingOthers = timeCCingOthers;
    }

    public BigInteger getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(BigInteger totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public BigInteger getMagicalDamageTaken() {
        return magicalDamageTaken;
    }

    public void setMagicalDamageTaken(BigInteger magicalDamageTaken) {
        this.magicalDamageTaken = magicalDamageTaken;
    }

    public BigInteger getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(BigInteger physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public BigInteger getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(BigInteger trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public BigInteger getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(BigInteger goldSpent) {
        this.goldSpent = goldSpent;
    }

    public BigInteger getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(BigInteger turretKills) {
        this.turretKills = turretKills;
    }

    public BigInteger getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(BigInteger inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public BigInteger getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(BigInteger totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public BigInteger getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(BigInteger neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public BigInteger getNeutralMinionsKilledTeamJungle() {
        return neutralMinionsKilledTeamJungle;
    }

    public void setNeutralMinionsKilledTeamJungle(BigInteger neutralMinionsKilledTeamJungle) {
        this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    }

    public BigInteger getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    public void setNeutralMinionsKilledEnemyJungle(BigInteger neutralMinionsKilledEnemyJungle) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    public BigInteger getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt(BigInteger totalTimeCrowdControlDealt) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public BigInteger getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(BigInteger champLevel) {
        this.champLevel = champLevel;
    }

    public BigInteger getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(BigInteger visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public BigInteger getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(BigInteger sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public BigInteger getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(BigInteger wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public BigInteger getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(BigInteger wardsKilled) {
        this.wardsKilled = wardsKilled;
    }

    public Boolean getFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill(Boolean firstBloodKill) {
        this.firstBloodKill = firstBloodKill;
    }

    public Boolean getFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist(Boolean firstBloodAssist) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public Boolean getFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill(Boolean firstTowerKill) {
        this.firstTowerKill = firstTowerKill;
    }

    public Boolean getFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist(Boolean firstTowerAssist) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public BigInteger getCombatPlayerScore() {
        return combatPlayerScore;
    }

    public void setCombatPlayerScore(BigInteger combatPlayerScore) {
        this.combatPlayerScore = combatPlayerScore;
    }

    public BigInteger getObjectivePlayerScore() {
        return objectivePlayerScore;
    }

    public void setObjectivePlayerScore(BigInteger objectivePlayerScore) {
        this.objectivePlayerScore = objectivePlayerScore;
    }

    public BigInteger getTotalPlayerScore() {
        return totalPlayerScore;
    }

    public void setTotalPlayerScore(BigInteger totalPlayerScore) {
        this.totalPlayerScore = totalPlayerScore;
    }

    public BigInteger getTotalScoreRank() {
        return totalScoreRank;
    }

    public void setTotalScoreRank(BigInteger totalScoreRank) {
        this.totalScoreRank = totalScoreRank;
    }

}
