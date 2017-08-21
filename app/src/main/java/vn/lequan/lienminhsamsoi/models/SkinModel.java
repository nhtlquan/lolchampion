package vn.lequan.lienminhsamsoi.models;

public class SkinModel {
    private String image;
    private String name;

    public SkinModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
