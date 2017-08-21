
package vn.lequan.lienminhsamsoi.API.Model.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class History {

    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("games")
    @Expose
    private Games games;
    @SerializedName("shownQueues")
    @Expose
    private List<Integer> shownQueues = null;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public List<Integer> getShownQueues() {
        return shownQueues;
    }

    public void setShownQueues(List<Integer> shownQueues) {
        this.shownQueues = shownQueues;
    }

}
