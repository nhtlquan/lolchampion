
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video_ {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("description")
    @Expose
    private List<Object> description = null;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("x")
    @Expose
    private String x;
    @SerializedName("y")
    @Expose
    private String y;
    @SerializedName("featured-champions")
    @Expose
    private List<FeaturedChampion_> featuredChampions = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Object> getDescription() {
        return description;
    }

    public void setDescription(List<Object> description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public List<FeaturedChampion_> getFeaturedChampions() {
        return featuredChampions;
    }

    public void setFeaturedChampions(List<FeaturedChampion_> featuredChampions) {
        this.featuredChampions = featuredChampions;
    }

}
