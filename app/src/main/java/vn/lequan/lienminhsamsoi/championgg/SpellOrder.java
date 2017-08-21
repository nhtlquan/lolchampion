package vn.lequan.lienminhsamsoi.championgg;

import java.util.List;

public class SpellOrder {
    private String[] lever;
    private List<Boolean> spellE;
    private List<Boolean> spellQ;
    private List<Boolean> spellR;
    private List<Boolean> spellW;
    private List<String> urlSkin;

    public List<String> getUrlSkin() {
        return this.urlSkin;
    }

    public void setUrlSkin(List<String> urlSkin) {
        this.urlSkin = urlSkin;
    }

    public String[] getLever() {
        return this.lever;
    }

    public void setLever(String[] lever) {
        this.lever = lever;
    }

    public List<Boolean> getSpellQ() {
        return this.spellQ;
    }

    public void setSpellQ(List<Boolean> spellQ) {
        this.spellQ = spellQ;
    }

    public List<Boolean> getSpellW() {
        return this.spellW;
    }

    public void setSpellW(List<Boolean> spellW) {
        this.spellW = spellW;
    }

    public List<Boolean> getSpellE() {
        return this.spellE;
    }

    public void setSpellE(List<Boolean> spellE) {
        this.spellE = spellE;
    }

    public List<Boolean> getSpellR() {
        return this.spellR;
    }

    public void setSpellR(List<Boolean> spellR) {
        this.spellR = spellR;
    }
}
