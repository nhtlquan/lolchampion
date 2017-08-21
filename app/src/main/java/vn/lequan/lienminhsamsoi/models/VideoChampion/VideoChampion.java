
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoChampion {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("champion")
    @Expose
    private Champion champion;
    @SerializedName("related-champions")
    @Expose
    private List<RelatedChampion> relatedChampions = null;
    @SerializedName("explore-champions")
    @Expose
    private List<Object> exploreChampions = null;
    @SerializedName("modules")
    @Expose
    private List<Module> modules = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public List<RelatedChampion> getRelatedChampions() {
        return relatedChampions;
    }

    public void setRelatedChampions(List<RelatedChampion> relatedChampions) {
        this.relatedChampions = relatedChampions;
    }

    public List<Object> getExploreChampions() {
        return exploreChampions;
    }

    public void setExploreChampions(List<Object> exploreChampions) {
        this.exploreChampions = exploreChampions;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

}
