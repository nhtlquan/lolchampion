
package vn.lequan.lienminhsamsoi.API.Model.MasteryTree;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tree {

    @SerializedName("Ferocity")
    @Expose
    private List<List<Ferocity>> ferocity = null;
    @SerializedName("Cunning")
    @Expose
    private List<List<Cunning>> cunning = null;
    @SerializedName("Resolve")
    @Expose
    private List<List<Resolve>> resolve = null;

    public List<List<Ferocity>> getFerocity() {
        return ferocity;
    }

    public void setFerocity(List<List<Ferocity>> ferocity) {
        this.ferocity = ferocity;
    }

    public List<List<Cunning>> getCunning() {
        return cunning;
    }

    public void setCunning(List<List<Cunning>> cunning) {
        this.cunning = cunning;
    }

    public List<List<Resolve>> getResolve() {
        return resolve;
    }

    public void setResolve(List<List<Resolve>> resolve) {
        this.resolve = resolve;
    }

}
