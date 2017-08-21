
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

import vn.lequan.lienminhsamsoi.API.Model.History.*;

public class Participant {

    @SerializedName("participantId")
    @Expose
    private BigInteger participantId;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("championId")
    @Expose
    private BigInteger championId;
    @SerializedName("spell1Id")
    @Expose
    private BigInteger spell1Id;
    @SerializedName("spell2Id")
    @Expose
    private BigInteger spell2Id;
    @SerializedName("highestAchievedSeasonTier")
    @Expose
    private String highestAchievedSeasonTier;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("timeline")
    @Expose
    private Timeline timeline;
    @SerializedName("runes")
    @Expose
    private List<Rune> runes;
    @SerializedName("masteries")
    @Expose
    private List<Mastery> masteries;

    public List<Rune> getRunes() {
        return runes;
    }

    public void setRunes(List<Rune> runes) {
        this.runes = runes;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    public BigInteger getParticipantId() {
        return participantId;
    }

    public void setParticipantId(BigInteger participantId) {
        this.participantId = participantId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public BigInteger getChampionId() {
        return championId;
    }

    public void setChampionId(BigInteger championId) {
        this.championId = championId;
    }

    public BigInteger getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(BigInteger spell1Id) {
        this.spell1Id = spell1Id;
    }

    public BigInteger getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(BigInteger spell2Id) {
        this.spell2Id = spell2Id;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

}
