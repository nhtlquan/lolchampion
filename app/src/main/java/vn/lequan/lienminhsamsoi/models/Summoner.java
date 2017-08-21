package vn.lequan.lienminhsamsoi.models;

public class Summoner {
    private String description;
    private String id;
    private String image;
    private String lever;
    private String name;

    public Summoner(String id, String name, String image, String lever, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.lever = lever;
        this.description = description;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLever() {
        return this.lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
