
package vn.lequan.lienminhsamsoi.API.Model.MasteryTree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resolve {

    @SerializedName("masteryId")
    @Expose
    private String masteryId;
    @SerializedName("prereq")
    @Expose
    private String prereq;

    public String getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(String masteryId) {
        this.masteryId = masteryId;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

}
