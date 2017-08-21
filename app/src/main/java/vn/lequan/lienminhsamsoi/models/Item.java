package vn.lequan.lienminhsamsoi.models;

public class Item {
    private String detail;
    private String from;
    private String goldBase;
    private String goldTotal;
    private String id;
    private String into;
    private String name;

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Item() {
    }

    public Item(String id, String name, String goldBase, String goldTotal, String into, String from, String detail) {
        this.id = id;
        this.name = name;
        this.goldBase = goldBase;
        this.goldTotal = goldTotal;
        this.into = into;
        this.from = from;
        this.detail = detail;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoldBase() {
        return this.goldBase;
    }

    public void setGoldBase(String goldBase) {
        this.goldBase = goldBase;
    }

    public String getGoldTotal() {
        return this.goldTotal;
    }

    public void setGoldTotal(String goldTotal) {
        this.goldTotal = goldTotal;
    }

    public String getInto() {
        return this.into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
