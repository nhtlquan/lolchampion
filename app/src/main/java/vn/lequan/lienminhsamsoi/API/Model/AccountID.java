
package vn.lequan.lienminhsamsoi.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountID {

    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

}
