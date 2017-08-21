
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Ban {

    @SerializedName("championId")
    @Expose
    private BigInteger championId;
    @SerializedName("pickTurn")
    @Expose
    private BigInteger pickTurn;

    public BigInteger getChampionId() {
        return championId;
    }

    public void setChampionId(BigInteger championId) {
        this.championId = championId;
    }

    public BigInteger getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(BigInteger pickTurn) {
        this.pickTurn = pickTurn;
    }

}
