
package vn.lequan.lienminhsamsoi.API.Model.History;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant {

    @SerializedName("participantId")
    @Expose
    private Integer participantId;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("championId")
    @Expose
    private Integer championId;
    @SerializedName("spell1Id")
    @Expose
    private Integer spell1Id;
    @SerializedName("spell2Id")
    @Expose
    private Integer spell2Id;
    @SerializedName("masteries")
    @Expose
    private List<Mastery> masteries = null;
    @SerializedName("runes")
    @Expose
    private List<Rune> runes = null;
    @SerializedName("highestAchievedSeasonTier")
    @Expose
    private String highestAchievedSeasonTier;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("timeline")
    @Expose
    private Timeline timeline;

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    public Integer getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(Integer spell1Id) {
        this.spell1Id = spell1Id;
    }

    public Integer getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(Integer spell2Id) {
        this.spell2Id = spell2Id;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public void setRunes(List<Rune> runes) {
        this.runes = runes;
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
