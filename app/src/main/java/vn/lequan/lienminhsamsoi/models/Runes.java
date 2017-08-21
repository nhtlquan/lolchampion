package vn.lequan.lienminhsamsoi.models;

public class Runes {
    private String count;
    private String description;
    private String image;
    private String name;
    private String runeId;

    public Runes(String runeId, String name, String description, String image, String count) {
        this.runeId = runeId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getRuneId() {
        return this.runeId;
    }

    public void setRuneId(String runeId) {
        this.runeId = runeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
