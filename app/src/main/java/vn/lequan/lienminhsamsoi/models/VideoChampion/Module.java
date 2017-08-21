
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Module {

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
    private String description;
    @SerializedName("story-slug")
    @Expose
    private String storySlug;
    @SerializedName("background")
    @Expose
    private Background background;
    @SerializedName("word-count")
    @Expose
    private Integer wordCount;
    @SerializedName("minutes-to-read")
    @Expose
    private Integer minutesToRead;
    @SerializedName("section-title")
    @Expose
    private String sectionTitle;
    @SerializedName("isFanArt")
    @Expose
    private Boolean isFanArt;
    @SerializedName("fan-art-url")
    @Expose
    private String fanArtUrl;
    @SerializedName("assets")
    @Expose
    private List<Asset> assets = null;
    @SerializedName("featured-champions")
    @Expose
    private List<FeaturedChampion> featuredChampions = null;
    @SerializedName("video")
    @Expose
    private Video_ video;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStorySlug() {
        return storySlug;
    }

    public void setStorySlug(String storySlug) {
        this.storySlug = storySlug;
    }



    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getMinutesToRead() {
        return minutesToRead;
    }

    public void setMinutesToRead(Integer minutesToRead) {
        this.minutesToRead = minutesToRead;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public Boolean getIsFanArt() {
        return isFanArt;
    }

    public void setIsFanArt(Boolean isFanArt) {
        this.isFanArt = isFanArt;
    }

    public String getFanArtUrl() {
        return fanArtUrl;
    }

    public void setFanArtUrl(String fanArtUrl) {
        this.fanArtUrl = fanArtUrl;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<FeaturedChampion> getFeaturedChampions() {
        return featuredChampions;
    }

    public void setFeaturedChampions(List<FeaturedChampion> featuredChampions) {
        this.featuredChampions = featuredChampions;
    }

    public Video_ getVideo() {
        return video;
    }

    public void setVideo(Video_ video) {
        this.video = video;
    }

}
