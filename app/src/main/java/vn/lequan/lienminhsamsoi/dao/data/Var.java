package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Var {
    @SerializedName("coeff")
    @Expose
    private List<Double> coeff;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("link")
    @Expose
    private String link;

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Double> getCoeff() {
        return this.coeff;
    }

    public void setCoeff(List<Double> coeff) {
        this.coeff = coeff;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
