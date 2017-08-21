package vn.lequan.lienminhsamsoi.championgg;

public class Runes {
    private String count;
    private String detail;
    private String image;

    public Runes(String id, String detail, String count) {
        this.image = id;
        this.detail = detail;
        this.count = count;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
