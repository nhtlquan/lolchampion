package vn.lequan.lienminhsamsoi.championgg;

public class Role {
    private String role;
    private String roleRate;

    public Role(String role, String roleRate) {
        this.role = role;
        this.roleRate = roleRate;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleRate() {
        return this.roleRate;
    }

    public void setRoleRate(String roleRate) {
        this.roleRate = roleRate;
    }
}
