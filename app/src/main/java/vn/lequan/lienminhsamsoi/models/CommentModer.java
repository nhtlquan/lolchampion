package vn.lequan.lienminhsamsoi.models;

public class CommentModer {
    private String body;
    private String conversionId;
    private long timeUpdated;
    private String type;
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

    public String getConversionId() {
        return this.conversionId;
    }

    public void setConversionId(String conversionId) {
        this.conversionId = conversionId;
    }

    public long getTimeUpdated() {
        return this.timeUpdated;
    }

    public void setTimeUpdated(long timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
