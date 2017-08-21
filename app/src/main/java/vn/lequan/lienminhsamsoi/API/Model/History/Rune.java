
package vn.lequan.lienminhsamsoi.API.Model.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rune {

    @SerializedName("runeId")
    @Expose
    private Integer runeId;
    @SerializedName("rank")
    @Expose
    private Integer rank;

    public Integer getRuneId() {
        return runeId;
    }

    public void setRuneId(Integer runeId) {
        this.runeId = runeId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
