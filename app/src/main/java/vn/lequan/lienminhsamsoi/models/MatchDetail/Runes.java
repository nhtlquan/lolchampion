
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Runes {

    @SerializedName("runeId")
    @Expose
    private String runeId;

    @SerializedName("rank")
    @Expose
    private String rank;

    public String getRuneId() {
        return runeId;
    }

    public void setRuneId(String runeId) {
        this.runeId = runeId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
