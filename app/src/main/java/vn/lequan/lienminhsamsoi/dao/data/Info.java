package vn.lequan.lienminhsamsoi.dao.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("attack")
    @Expose
    private Integer attack;
    @SerializedName("defense")
    @Expose
    private Integer defense;
    @SerializedName("difficulty")
    @Expose
    private Integer difficulty;
    @SerializedName("magic")
    @Expose
    private Integer magic;

    public Integer getAttack() {
        return this.attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return this.defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getMagic() {
        return this.magic;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public Integer getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }
}
