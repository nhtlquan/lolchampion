
package vn.lequan.lienminhsamsoi.models.MatchDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Timeline {

    @SerializedName("participantId")
    @Expose
    private BigInteger participantId;
    @SerializedName("creepsPerMinDeltas")
    @Expose
    private CreepsPerMinDeltas creepsPerMinDeltas;
    @SerializedName("xpPerMinDeltas")
    @Expose
    private XpPerMinDeltas xpPerMinDeltas;
    @SerializedName("goldPerMinDeltas")
    @Expose
    private GoldPerMinDeltas goldPerMinDeltas;
    @SerializedName("csDiffPerMinDeltas")
    @Expose
    private CsDiffPerMinDeltas csDiffPerMinDeltas;
    @SerializedName("xpDiffPerMinDeltas")
    @Expose
    private XpDiffPerMinDeltas xpDiffPerMinDeltas;
    @SerializedName("damageTakenPerMinDeltas")
    @Expose
    private DamageTakenPerMinDeltas damageTakenPerMinDeltas;
    @SerializedName("damageTakenDiffPerMinDeltas")
    @Expose
    private DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("lane")
    @Expose
    private String lane;

    public BigInteger getParticipantId() {
        return participantId;
    }

    public void setParticipantId(BigInteger participantId) {
        this.participantId = participantId;
    }

    public CreepsPerMinDeltas getCreepsPerMinDeltas() {
        return creepsPerMinDeltas;
    }

    public void setCreepsPerMinDeltas(CreepsPerMinDeltas creepsPerMinDeltas) {
        this.creepsPerMinDeltas = creepsPerMinDeltas;
    }

    public XpPerMinDeltas getXpPerMinDeltas() {
        return xpPerMinDeltas;
    }

    public void setXpPerMinDeltas(XpPerMinDeltas xpPerMinDeltas) {
        this.xpPerMinDeltas = xpPerMinDeltas;
    }

    public GoldPerMinDeltas getGoldPerMinDeltas() {
        return goldPerMinDeltas;
    }

    public void setGoldPerMinDeltas(GoldPerMinDeltas goldPerMinDeltas) {
        this.goldPerMinDeltas = goldPerMinDeltas;
    }

    public CsDiffPerMinDeltas getCsDiffPerMinDeltas() {
        return csDiffPerMinDeltas;
    }

    public void setCsDiffPerMinDeltas(CsDiffPerMinDeltas csDiffPerMinDeltas) {
        this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    }

    public XpDiffPerMinDeltas getXpDiffPerMinDeltas() {
        return xpDiffPerMinDeltas;
    }

    public void setXpDiffPerMinDeltas(XpDiffPerMinDeltas xpDiffPerMinDeltas) {
        this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    }

    public DamageTakenPerMinDeltas getDamageTakenPerMinDeltas() {
        return damageTakenPerMinDeltas;
    }

    public void setDamageTakenPerMinDeltas(DamageTakenPerMinDeltas damageTakenPerMinDeltas) {
        this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    }

    public DamageTakenDiffPerMinDeltas getDamageTakenDiffPerMinDeltas() {
        return damageTakenDiffPerMinDeltas;
    }

    public void setDamageTakenDiffPerMinDeltas(DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas) {
        this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

}
