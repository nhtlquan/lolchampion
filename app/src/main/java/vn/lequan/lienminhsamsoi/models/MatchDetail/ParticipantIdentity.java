
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class ParticipantIdentity {

    @SerializedName("participantId")
    @Expose
    private BigInteger participantId;
    @SerializedName("player")
    @Expose
    private Player player;

    public BigInteger getParticipantId() {
        return participantId;
    }

    public void setParticipantId(BigInteger participantId) {
        this.participantId = participantId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
