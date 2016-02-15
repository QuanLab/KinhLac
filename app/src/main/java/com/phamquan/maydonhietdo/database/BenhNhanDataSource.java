package com.phamquan.maydonhietdo.database;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class BenhNhanDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {"_id", "hoten", "namsinh", "diachi", "sodienthoai"};
    private String[] allColunmLanKham = {"idlankham", "idbenhnhan", "trieuchung", "solieu", "ngaydo", "image"};

    public BenhNhanDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertBenhNhan(BenhNhan benhNhan) {

        String hoten = benhNhan.getHoTen();
        String namsinh = benhNhan.getNamSinh();
        String diachi = benhNhan.getDiaChi();
        String soDienThoai = benhNhan.getSoDienThoai();
        String sql = "INSERT INTO tblbenhnhan VALUES ( null, '" + hoten + "', '" + namsinh + "', '" + diachi + "', '" + soDienThoai + "');";

        try {
            database.execSQL(sql);

        } catch (Exception e) {
            Log.e(this.getClass().toString(), "Loi chen du lieu insertBenhNhan" + e);
        }
    }


    public ArrayList<BenhNhan> getAllBenhNhan() {

        ArrayList<BenhNhan> danhSachBenhNhan = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.query("tblbenhnhan", allColumns, null, null, null, null, null);
//            Log.i(this.getClass().toString(), "Lay thanh cong du lieu tu bang");
        } catch (Exception e) {
            Log.e(this.getClass().toString(), "Loi lay du lieu tu bang" + e);
        }
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            BenhNhan benhNhan = cursorToBenhNhan(cursor);
            danhSachBenhNhan.add(benhNhan);
            cursor.moveToNext();
        }

        cursor.close();
        return danhSachBenhNhan;
    }

    private BenhNhan cursorToBenhNhan(Cursor cursor) {

        BenhNhan benhNhan = new BenhNhan();

        benhNhan.setId(cursor.getInt(0));
        benhNhan.setHoTen(cursor.getString(1));
        benhNhan.setNamSinh(cursor.getString(2));
        benhNhan.setDiaChi(cursor.getString(3));
        benhNhan.setSoDienThoai(cursor.getString(4));

        return benhNhan;
    }

    public void insertLanKham(LanKham lanKham) {

//        BenhNhan benhNhan = lanKham.getBenhNhan();
//
//        int idBenhNhan = benhNhan.getId();
//        String ngaydo = lanKham.getNgayDo();
//        String trieuchung = lanKham.getTrieuChung();
//        String solieu = lanKham.getSoLieu();

        String sql = "INSERT INTO 'tblkhambenh' VALUES ( null, 0, 'trieu chung o day', 'so lieu se o day', 'ngay do se o day', 'image');";

        try {
            database.execSQL(sql);
            Log.e(this.getClass().toString(), "Chen du lieu thanh cong tai insertLanKham");

        } catch (Exception e) {
            Log.e(this.getClass().toString(), "Loi chen du lieu trong insertLanKham" + e);
        }
    }

    public ArrayList<LanKham> getAllLanKham() {

        ArrayList<LanKham> danhSachLanKham = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = database.query("tblkhambenh", allColunmLanKham, null, null, null, null, null);
            Log.e(this.getClass().toString(), "Lay thanh cong du lieu tu bang lan kham");

        } catch (Exception e) {
            Log.e(this.getClass().toString(), "Err loi lay du lieu tu bang lan kham" + e);
        }
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            LanKham lanKham = cursorToLanKham(cursor);
            danhSachLanKham.add(lanKham);
            cursor.moveToNext();
        }

        cursor.close();
        return danhSachLanKham;
    }

    private LanKham cursorToLanKham(Cursor cursor) {

        LanKham lanKham = new LanKham();
        lanKham.setIdLanKham(cursor.getInt(0));
        lanKham.getBenhNhan().setId(cursor.getInt(1));
        lanKham.setNgayDo(cursor.getString(2));
        lanKham.setTrieuChung(cursor.getString(3));
        return lanKham;
    }
}
