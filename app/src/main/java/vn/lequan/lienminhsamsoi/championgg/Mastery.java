package vn.lequan.lienminhsamsoi.championgg;

public class Mastery {
    private String id;
    private int point;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Mastery(String id, int point) {
        this.id = id;
        this.point = point;
    }

    public Mastery() {
    }
}
