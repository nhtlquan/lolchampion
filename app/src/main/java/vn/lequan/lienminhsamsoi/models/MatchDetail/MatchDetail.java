
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

public class MatchDetail {

    @SerializedName("gameId")
    @Expose
    private BigInteger gameId;
    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("gameCreation")
    @Expose
    private BigInteger gameCreation;
    @SerializedName("gameDuration")
    @Expose
    private BigInteger gameDuration;
    @SerializedName("queueId")
    @Expose
    private BigInteger queueId;
    @SerializedName("mapId")
    @Expose
    private BigInteger mapId;
    @SerializedName("seasonId")
    @Expose
    private BigInteger seasonId;
    @SerializedName("gameVersion")
    @Expose
    private String gameVersion;
    @SerializedName("gameMode")
    @Expose
    private String gameMode;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = null;
    @SerializedName("participantIdentities")
    @Expose
    private List<ParticipantIdentity> participantIdentities = null;

    public BigInteger getGameId() {
        return gameId;
    }

    public void setGameId(BigInteger gameId) {
        this.gameId = gameId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public BigInteger getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(BigInteger gameCreation) {
        this.gameCreation = gameCreation;
    }

    public BigInteger getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(BigInteger gameDuration) {
        this.gameDuration = gameDuration;
    }

    public BigInteger getQueueId() {
        return queueId;
    }

    public void setQueueId(BigInteger queueId) {
        this.queueId = queueId;
    }

    public BigInteger getMapId() {
        return mapId;
    }

    public void setMapId(BigInteger mapId) {
        this.mapId = mapId;
    }

    public BigInteger getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(BigInteger seasonId) {
        this.seasonId = seasonId;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

}
