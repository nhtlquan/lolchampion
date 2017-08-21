package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkinData {
    @SerializedName("chromas")
    @Expose
    private Boolean chromas;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private Integer num;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChromas() {
        return this.chromas;
    }

    public void setChromas(Boolean chromas) {
        this.chromas = chromas;
    }
}
