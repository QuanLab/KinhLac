package com.phamquan.maydonhietdo.database;


import java.util.ArrayList;

public class BenhNhan {

    public int id;
    private String hoTen;
    private String namSinh;
    private String diaChi;
    private String soDienThoai;
    private ArrayList<LanKham> danhSachLanKham;

    public BenhNhan(String hoTen, String namSinh, String diaChi, String soDienThoai) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public BenhNhan(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ArrayList<LanKham> getDanhSachLanKham() {
        return danhSachLanKham;
    }

    public void setDanhSachLanKham(ArrayList<LanKham> danhSachLanKham) {
        this.danhSachLanKham = danhSachLanKham;
    }
}
