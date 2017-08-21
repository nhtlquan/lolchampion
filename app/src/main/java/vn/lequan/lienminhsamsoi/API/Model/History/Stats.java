
package vn.lequan.lienminhsamsoi.API.Model.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("participantId")
    @Expose
    private Integer participantId;
    @SerializedName("win")
    @Expose
    private Boolean win;
    @SerializedName("item0")
    @Expose
    private Integer item0;
    @SerializedName("item1")
    @Expose
    private Integer item1;
    @SerializedName("item2")
    @Expose
    private Integer item2;
    @SerializedName("item3")
    @Expose
    private Integer item3;
    @SerializedName("item4")
    @Expose
    private Integer item4;
    @SerializedName("item5")
    @Expose
    private Integer item5;
    @SerializedName("item6")
    @Expose
    private Integer item6;
    @SerializedName("kills")
    @Expose
    private Integer kills;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("assists")
    @Expose
    private Integer assists;
    @SerializedName("largestKillingSpree")
    @Expose
    private Integer largestKillingSpree;
    @SerializedName("largestMultiKill")
    @Expose
    private Integer largestMultiKill;
    @SerializedName("killingSprees")
    @Expose
    private Integer killingSprees;
    @SerializedName("longestTimeSpentLiving")
    @Expose
    private Integer longestTimeSpentLiving;
    @SerializedName("doubleKills")
    @Expose
    private Integer doubleKills;
    @SerializedName("tripleKills")
    @Expose
    private Integer tripleKills;
    @SerializedName("quadraKills")
    @Expose
    private Integer quadraKills;
    @SerializedName("pentaKills")
    @Expose
    private Integer pentaKills;
    @SerializedName("unrealKills")
    @Expose
    private Integer unrealKills;
    @SerializedName("totalDamageDealt")
    @Expose
    private Integer totalDamageDealt;
    @SerializedName("magicDamageDealt")
    @Expose
    private Integer magicDamageDealt;
    @SerializedName("physicalDamageDealt")
    @Expose
    private Integer physicalDamageDealt;
    @SerializedName("trueDamageDealt")
    @Expose
    private Integer trueDamageDealt;
    @SerializedName("largestCriticalStrike")
    @Expose
    private Integer largestCriticalStrike;
    @SerializedName("totalDamageDealtToChampions")
    @Expose
    private Integer totalDamageDealtToChampions;
    @SerializedName("magicDamageDealtToChampions")
    @Expose
    private Integer magicDamageDealtToChampions;
    @SerializedName("physicalDamageDealtToChampions")
    @Expose
    private Integer physicalDamageDealtToChampions;
    @SerializedName("trueDamageDealtToChampions")
    @Expose
    private Integer trueDamageDealtToChampions;
    @SerializedName("totalHeal")
    @Expose
    private Integer totalHeal;
    @SerializedName("totalUnitsHealed")
    @Expose
    private Integer totalUnitsHealed;
    @SerializedName("totalDamageTaken")
    @Expose
    private Integer totalDamageTaken;
    @SerializedName("magicalDamageTaken")
    @Expose
    private Integer magicalDamageTaken;
    @SerializedName("physicalDamageTaken")
    @Expose
    private Integer physicalDamageTaken;
    @SerializedName("trueDamageTaken")
    @Expose
    private Integer trueDamageTaken;
    @SerializedName("goldEarned")
    @Expose
    private Integer goldEarned;
    @SerializedName("goldSpent")
    @Expose
    private Integer goldSpent;
    @SerializedName("turretKills")
    @Expose
    private Integer turretKills;
    @SerializedName("inhibitorKills")
    @Expose
    private Integer inhibitorKills;
    @SerializedName("totalMinionsKilled")
    @Expose
    private Integer totalMinionsKilled;
    @SerializedName("neutralMinionsKilled")
    @Expose
    private Integer neutralMinionsKilled;
    @SerializedName("neutralMinionsKilledTeamJungle")
    @Expose
    private Integer neutralMinionsKilledTeamJungle;
    @SerializedName("neutralMinionsKilledEnemyJungle")
    @Expose
    private Integer neutralMinionsKilledEnemyJungle;
    @SerializedName("totalTimeCrowdControlDealt")
    @Expose
    private Integer totalTimeCrowdControlDealt;
    @SerializedName("champLevel")
    @Expose
    private Integer champLevel;
    @SerializedName("visionWardsBoughtInGame")
    @Expose
    private Integer visionWardsBoughtInGame;
    @SerializedName("sightWardsBoughtInGame")
    @Expose
    private Integer sightWardsBoughtInGame;
    @SerializedName("wardsPlaced")
    @Expose
    private Integer wardsPlaced;
    @SerializedName("wardsKilled")
    @Expose
    private Integer wardsKilled;
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
    @SerializedName("firstInhibitorKill")
    @Expose
    private Boolean firstInhibitorKill;
    @SerializedName("firstInhibitorAssist")
    @Expose
    private Boolean firstInhibitorAssist;
    @SerializedName("combatPlayerScore")
    @Expose
    private Integer combatPlayerScore;
    @SerializedName("objectivePlayerScore")
    @Expose
    private Integer objectivePlayerScore;
    @SerializedName("totalPlayerScore")
    @Expose
    private Integer totalPlayerScore;
    @SerializedName("totalScoreRank")
    @Expose
    private Integer totalScoreRank;

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Integer getItem0() {
        return item0;
    }

    public void setItem0(Integer item0) {
        this.item0 = item0;
    }

    public Integer getItem1() {
        return item1;
    }

    public void setItem1(Integer item1) {
        this.item1 = item1;
    }

    public Integer getItem2() {
        return item2;
    }

    public void setItem2(Integer item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return item3;
    }

    public void setItem3(Integer item3) {
        this.item3 = item3;
    }

    public Integer getItem4() {
        return item4;
    }

    public void setItem4(Integer item4) {
        this.item4 = item4;
    }

    public Integer getItem5() {
        return item5;
    }

    public void setItem5(Integer item5) {
        this.item5 = item5;
    }

    public Integer getItem6() {
        return item6;
    }

    public void setItem6(Integer item6) {
        this.item6 = item6;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(Integer largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public Integer getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(Integer largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public Integer getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(Integer killingSprees) {
        this.killingSprees = killingSprees;
    }

    public Integer getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public void setLongestTimeSpentLiving(Integer longestTimeSpentLiving) {
        this.longestTimeSpentLiving = longestTimeSpentLiving;
    }

    public Integer getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(Integer doubleKills) {
        this.doubleKills = doubleKills;
    }

    public Integer getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(Integer tripleKills) {
        this.tripleKills = tripleKills;
    }

    public Integer getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(Integer quadraKills) {
        this.quadraKills = quadraKills;
    }

    public Integer getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(Integer pentaKills) {
        this.pentaKills = pentaKills;
    }

    public Integer getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(Integer unrealKills) {
        this.unrealKills = unrealKills;
    }

    public Integer getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(Integer totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public Integer getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(Integer magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public Integer getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(Integer physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public Integer getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(Integer trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public Integer getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(Integer largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public Integer getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(Integer totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public Integer getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(Integer magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public Integer getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(Integer physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public Integer getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(Integer trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public Integer getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(Integer totalHeal) {
        this.totalHeal = totalHeal;
    }

    public Integer getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(Integer totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public Integer getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(Integer totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public Integer getMagicalDamageTaken() {
        return magicalDamageTaken;
    }

    public void setMagicalDamageTaken(Integer magicalDamageTaken) {
        this.magicalDamageTaken = magicalDamageTaken;
    }

    public Integer getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(Integer physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public Integer getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(Integer trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public Integer getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(Integer goldEarned) {
        this.goldEarned = goldEarned;
    }

    public Integer getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(Integer goldSpent) {
        this.goldSpent = goldSpent;
    }

    public Integer getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(Integer turretKills) {
        this.turretKills = turretKills;
    }

    public Integer getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(Integer inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public Integer getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(Integer totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public Integer getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(Integer neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public Integer getNeutralMinionsKilledTeamJungle() {
        return neutralMinionsKilledTeamJungle;
    }

    public void setNeutralMinionsKilledTeamJungle(Integer neutralMinionsKilledTeamJungle) {
        this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    }

    public Integer getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    public void setNeutralMinionsKilledEnemyJungle(Integer neutralMinionsKilledEnemyJungle) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    public Integer getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt(Integer totalTimeCrowdControlDealt) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public Integer getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(Integer champLevel) {
        this.champLevel = champLevel;
    }

    public Integer getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(Integer visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public Integer getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(Integer sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public Integer getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(Integer wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public Integer getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(Integer wardsKilled) {
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

    public Boolean getFirstInhibitorKill() {
        return firstInhibitorKill;
    }

    public void setFirstInhibitorKill(Boolean firstInhibitorKill) {
        this.firstInhibitorKill = firstInhibitorKill;
    }

    public Boolean getFirstInhibitorAssist() {
        return firstInhibitorAssist;
    }

    public void setFirstInhibitorAssist(Boolean firstInhibitorAssist) {
        this.firstInhibitorAssist = firstInhibitorAssist;
    }

    public Integer getCombatPlayerScore() {
        return combatPlayerScore;
    }

    public void setCombatPlayerScore(Integer combatPlayerScore) {
        this.combatPlayerScore = combatPlayerScore;
    }

    public Integer getObjectivePlayerScore() {
        return objectivePlayerScore;
    }

    public void setObjectivePlayerScore(Integer objectivePlayerScore) {
        this.objectivePlayerScore = objectivePlayerScore;
    }

    public Integer getTotalPlayerScore() {
        return totalPlayerScore;
    }

    public void setTotalPlayerScore(Integer totalPlayerScore) {
        this.totalPlayerScore = totalPlayerScore;
    }

    public Integer getTotalScoreRank() {
        return totalScoreRank;
    }

    public void setTotalScoreRank(Integer totalScoreRank) {
        this.totalScoreRank = totalScoreRank;
    }

}
