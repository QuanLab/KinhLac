package com.phamquan.maydonhietdo.database;


import android.media.Image;

public class LanKham {

    private BenhNhan benhNhan;

    private int idLanKham;
    private String trieuChung;
    private String ngayDo;
    private String soLieu;
    private Image image;

    public LanKham(String trieuChung, String soLieu, String ngayDo){

        this.trieuChung = trieuChung;
        this.soLieu = soLieu;
        this.ngayDo = ngayDo;
    }

    public LanKham(){

    }

    public int getIdLanKham() {
        return idLanKham;
    }

    public void setIdLanKham(int idLanKham) {
        this.idLanKham = idLanKham;
    }

    public String getNgayDo() {
        return ngayDo;
    }

    public void setNgayDo(String ngayDo) {
        this.ngayDo = ngayDo;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public String getSoLieu() {
        return soLieu;
    }

    public void setSoLieu(String soLieu) {
        this.soLieu = soLieu;
    }

}
