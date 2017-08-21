package vn.lequan.lienminhsamsoi.models;

public class Effect {
    private String data;
    private String key;

    public Effect(String key, String data) {
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
