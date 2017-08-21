package vn.lequan.lienminhsamsoi.models;

/**
 * Created by Le Quan on 09/08/2017.
 */

public class News {
    private String title;
    private String url;
    private String image_url;
    private String description;

    public News(String title, String url, String image_url, String description) {
        this.title = title;
        this.url = url;
        this.image_url = image_url;
        this.description = description;
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
