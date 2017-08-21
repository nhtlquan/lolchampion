package vn.lequan.lienminhsamsoi.championgg;

import java.util.List;

public class Masteries {
    private List<Mastery> cuongBao;
    private List<Mastery> kheoLeo;
    private List<Mastery> kienDinh;
    private int sumCuongBao;
    private int sumKheoLeo;
    private int sumKienDinh;

    public Masteries() {
    }

    public Masteries(List<Mastery> cuongBao, List<Mastery> kheoLeo, List<Mastery> kienDinh, int sumCuongBao, int sumKheoLeo, int sumKienDinh) {
        this.cuongBao = cuongBao;
        this.kheoLeo = kheoLeo;
        this.kienDinh = kienDinh;
        this.sumCuongBao = sumCuongBao;
        this.sumKheoLeo = sumKheoLeo;
        this.sumKienDinh = sumKienDinh;
    }

    public int getSumCuongBao() {
        return this.sumCuongBao;
    }

    public void setSumCuongBao(int sumCuongBao) {
        this.sumCuongBao = sumCuongBao;
    }

    public int getSumKheoLeo() {
        return this.sumKheoLeo;
    }

    public void setSumKheoLeo(int sumKheoLeo) {
        this.sumKheoLeo = sumKheoLeo;
    }

    public int getSumKienDinh() {
        return this.sumKienDinh;
    }

    public void setSumKienDinh(int sumKienDinh) {
        this.sumKienDinh = sumKienDinh;
    }

    public List<Mastery> getCuongBao() {
        return this.cuongBao;
    }

    public void setCuongBao(List<Mastery> cuongBao) {
        this.cuongBao = cuongBao;
    }

    public List<Mastery> getKheoLeo() {
        return this.kheoLeo;
    }

    public void setKheoLeo(List<Mastery> kheoLeo) {
        this.kheoLeo = kheoLeo;
    }

    public List<Mastery> getKienDinh() {
        return this.kienDinh;
    }

    public void setKienDinh(List<Mastery> kienDinh) {
        this.kienDinh = kienDinh;
    }
}
