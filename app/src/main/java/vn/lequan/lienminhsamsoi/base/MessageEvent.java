package vn.lequan.lienminhsamsoi.base;

public class MessageEvent {
    private String key;
    private Object object;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public MessageEvent(Object o, String key) {
        this.object = o;
        this.key = key;
    }

    public MessageEvent(String key) {
        this.key = key;
    }
}
