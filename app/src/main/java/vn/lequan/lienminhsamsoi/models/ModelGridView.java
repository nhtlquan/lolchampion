package vn.lequan.lienminhsamsoi.models;

public class ModelGridView {
    private String id;
    private String image;
    private String key;
    private String name;

    public ModelGridView(String id, String name, String image, String key) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.key = key;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public void setImage(String paramString) {
        this.image = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
