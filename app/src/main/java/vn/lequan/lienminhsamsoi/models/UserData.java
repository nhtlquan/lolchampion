package vn.lequan.lienminhsamsoi.models;

public class UserData {
    private String imageUrl;
    private long joinDate;
    private String userId;
    private String userName;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
