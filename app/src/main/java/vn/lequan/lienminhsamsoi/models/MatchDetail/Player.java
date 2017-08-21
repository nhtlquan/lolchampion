
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Player {

    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("accountId")
    @Expose
    private BigInteger accountId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("summonerId")
    @Expose
    private BigInteger summonerId;
    @SerializedName("currentPlatformId")
    @Expose
    private String currentPlatformId;
    @SerializedName("currentAccountId")
    @Expose
    private BigInteger currentAccountId;
    @SerializedName("matchHistoryUri")
    @Expose
    private String matchHistoryUri;
    @SerializedName("profileIcon")
    @Expose
    private BigInteger profileIcon;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public BigInteger getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(BigInteger summonerId) {
        this.summonerId = summonerId;
    }

    public String getCurrentPlatformId() {
        return currentPlatformId;
    }

    public void setCurrentPlatformId(String currentPlatformId) {
        this.currentPlatformId = currentPlatformId;
    }

    public BigInteger getCurrentAccountId() {
        return currentAccountId;
    }

    public void setCurrentAccountId(BigInteger currentAccountId) {
        this.currentAccountId = currentAccountId;
    }

    public String getMatchHistoryUri() {
        return matchHistoryUri;
    }

    public void setMatchHistoryUri(String matchHistoryUri) {
        this.matchHistoryUri = matchHistoryUri;
    }

    public BigInteger getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(BigInteger profileIcon) {
        this.profileIcon = profileIcon;
    }

}
