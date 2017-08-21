
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;

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

}
