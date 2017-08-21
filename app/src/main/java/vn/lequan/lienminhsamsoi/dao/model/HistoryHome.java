package vn.lequan.lienminhsamsoi.dao.model;

/**
 * Created by Le Quan on 07/07/2017.
 */

public class HistoryHome {
    private int id;
    private String name;
    private int id_icon;

    public HistoryHome(int id, String name, int id_icon) {
        this.id = id;
        this.name = name;
        this.id_icon = id_icon;
    }

    public int getId_icon() {
        return id_icon;
    }

    public void setId_icon(int id_icon) {
        this.id_icon = id_icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
