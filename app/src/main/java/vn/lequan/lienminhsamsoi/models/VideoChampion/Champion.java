
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Champion {

    @SerializedName("release-date")
    @Expose
    private String releaseDate;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("video")
    @Expose
    private Video video;
    @SerializedName("associated-faction-slug")
    @Expose
    private String associatedFactionSlug;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("game-info-url")
    @Expose
    private String gameInfoUrl;
    @SerializedName("biography")
    @Expose
    private Biography biography;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getAssociatedFactionSlug() {
        return associatedFactionSlug;
    }

    public void setAssociatedFactionSlug(String associatedFactionSlug) {
        this.associatedFactionSlug = associatedFactionSlug;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGameInfoUrl() {
        return gameInfoUrl;
    }

    public void setGameInfoUrl(String gameInfoUrl) {
        this.gameInfoUrl = gameInfoUrl;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

}
