
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedChampion {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("release-date")
    @Expose
    private String releaseDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("echelon")
    @Expose
    private Integer echelon;
    @SerializedName("associated-faction")
    @Expose
    private String associatedFaction;
    @SerializedName("associated-faction-slug")
    @Expose
    private String associatedFactionSlug;
    @SerializedName("image")
    @Expose
    private Image__ image;
    @SerializedName("role")
    @Expose
    private List<Role__> role = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getEchelon() {
        return echelon;
    }

    public void setEchelon(Integer echelon) {
        this.echelon = echelon;
    }

    public String getAssociatedFaction() {
        return associatedFaction;
    }

    public void setAssociatedFaction(String associatedFaction) {
        this.associatedFaction = associatedFaction;
    }

    public String getAssociatedFactionSlug() {
        return associatedFactionSlug;
    }

    public void setAssociatedFactionSlug(String associatedFactionSlug) {
        this.associatedFactionSlug = associatedFactionSlug;
    }

    public Image__ getImage() {
        return image;
    }

    public void setImage(Image__ image) {
        this.image = image;
    }

    public List<Role__> getRole() {
        return role;
    }

    public void setRole(List<Role__> role) {
        this.role = role;
    }

}
