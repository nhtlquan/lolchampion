package vn.lequan.lienminhsamsoi.championgg;

import java.util.List;

public class DataRole {
    private String header;
    private List<Role> roles;
    private String timeUpdate;

    public String getTimeUpdate() {
        return this.timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
