
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

public class Team {

    @SerializedName("teamId")
    @Expose
    private BigInteger teamId;
    @SerializedName("win")
    @Expose
    private String win;
    @SerializedName("firstBlood")
    @Expose
    private Boolean firstBlood;
    @SerializedName("firstTower")
    @Expose
    private Boolean firstTower;
    @SerializedName("firstInhibitor")
    @Expose
    private Boolean firstInhibitor;
    @SerializedName("firstBaron")
    @Expose
    private Boolean firstBaron;
    @SerializedName("firstDragon")
    @Expose
    private Boolean firstDragon;
    @SerializedName("firstRiftHerald")
    @Expose
    private Boolean firstRiftHerald;
    @SerializedName("towerKills")
    @Expose
    private BigInteger towerKills;
    @SerializedName("inhibitorKills")
    @Expose
    private BigInteger inhibitorKills;
    @SerializedName("baronKills")
    @Expose
    private BigInteger baronKills;
    @SerializedName("dragonKills")
    @Expose
    private BigInteger dragonKills;
    @SerializedName("vilemawKills")
    @Expose
    private BigInteger vilemawKills;
    @SerializedName("riftHeraldKills")
    @Expose
    private BigInteger riftHeraldKills;
    @SerializedName("dominionVictoryScore")
    @Expose
    private BigInteger dominionVictoryScore;
    @SerializedName("bans")
    @Expose
    private List<Ban> bans = null;

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Boolean getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(Boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    public Boolean getFirstTower() {
        return firstTower;
    }

    public void setFirstTower(Boolean firstTower) {
        this.firstTower = firstTower;
    }

    public Boolean getFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor(Boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    public Boolean getFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron(Boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    public Boolean getFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon(Boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    public Boolean getFirstRiftHerald() {
        return firstRiftHerald;
    }

    public void setFirstRiftHerald(Boolean firstRiftHerald) {
        this.firstRiftHerald = firstRiftHerald;
    }

    public BigInteger getTowerKills() {
        return towerKills;
    }

    public void setTowerKills(BigInteger towerKills) {
        this.towerKills = towerKills;
    }

    public BigInteger getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(BigInteger inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public BigInteger getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(BigInteger baronKills) {
        this.baronKills = baronKills;
    }

    public BigInteger getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(BigInteger dragonKills) {
        this.dragonKills = dragonKills;
    }

    public BigInteger getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills(BigInteger vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    public BigInteger getRiftHeraldKills() {
        return riftHeraldKills;
    }

    public void setRiftHeraldKills(BigInteger riftHeraldKills) {
        this.riftHeraldKills = riftHeraldKills;
    }

    public BigInteger getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore(BigInteger dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public List<Ban> getBans() {
        return bans;
    }

    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

}
