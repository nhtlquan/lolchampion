package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Leveltip {
    @SerializedName("effect")
    @Expose
    private List<String> effect = new ArrayList();
    @SerializedName("label")
    @Expose
    private List<String> label = new ArrayList();

    public List<String> getLabel() {
        return this.label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public List<String> getEffect() {
        return this.effect;
    }

    public void setEffect(List<String> effect) {
        this.effect = effect;
    }
}
