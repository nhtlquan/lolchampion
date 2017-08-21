
package vn.lequan.lienminhsamsoi.API.Model.MasteryTree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MasteryTree {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("tree")
    @Expose
    private Tree tree;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

}
