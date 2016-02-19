package com.phamquan.maydonhietdo.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class BenhNhanDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {"_id", "hoten", "namsinh", "diachi", "sodienthoai"};
    private String[] allColunmLanKham = {"idlankham", "idbenhnhan", "trieuchung", "solieu", "ngaydo"};

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

        ContentValues contentValues = new ContentValues();

        contentValues.put("hoten", benhNhan.getHoTen());
        contentValues.put("namsinh", benhNhan.getNamSinh());
        contentValues.put("diachi", benhNhan.getDiaChi());
        contentValues.put("sodienthoai", benhNhan.getSoDienThoai());
        try {
            database.insert(DatabaseHelper.TABLE_BENH_NHAN, null, contentValues);

        } catch (SQLException e) {

        }
    }

    public int countBenhNhan(){

        Cursor cursor = null;
        try {
            cursor = database.query(DatabaseHelper.TABLE_BENH_NHAN, allColumns, null, null, null, null, null);
        } catch (SQLException e) {

        }
        return cursor.getCount();
    }

    public ArrayList<BenhNhan> getAllBenhNhan() {

        ArrayList<BenhNhan> danhSachBenhNhan = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.query(DatabaseHelper.TABLE_BENH_NHAN, allColumns, null, null, null, null, null);

        } catch (SQLException e) {

        }
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            BenhNhan benhNhan = new BenhNhan();

            benhNhan.setId(cursor.getInt(0));
            benhNhan.setHoTen(cursor.getString(1));
            benhNhan.setNamSinh(cursor.getString(2));
            benhNhan.setDiaChi(cursor.getString(3));
            benhNhan.setSoDienThoai(cursor.getString(4));

            danhSachBenhNhan.add(benhNhan);
            cursor.moveToNext();
        }

        cursor.close();
        return danhSachBenhNhan;
    }

    public void insertLanKham(LanKham lanKham) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("idbenhnhan", lanKham.getBenhNhan().getId());
        contentValues.put("trieuchung", lanKham.getTrieuChung());
        contentValues.put("solieu", lanKham.getSoLieu());
        contentValues.put("ngaydo", lanKham.getNgayDo());

        try {
            database.insert(DatabaseHelper.TABLE_KHAM_BENH, null, contentValues);
            Log.e("insertLanKham: ", "Chen du lieu thanh cong");

        } catch (Exception e) {
            Log.e("insertLanKham: ", "Loi chen du lieu trong insertLanKham" + e);
        }
    }

    public ArrayList<LanKham> getAllLanKham(BenhNhan benhNhan) {

        ArrayList<LanKham> danhSachLanKham = new ArrayList<>();
        Cursor cursor = null;
        int idBenhNhan = benhNhan.getId();
        String whereArgs = "idbenhnhan=" + String.valueOf(idBenhNhan);
        Log.e("getAllLanKham: ", "Menh de where: " + whereArgs);

        try {
            cursor = database.query(DatabaseHelper.TABLE_KHAM_BENH, allColunmLanKham, whereArgs, null, null, null, null);
            Log.e("getAllLanKham:", "Lay thanh cong du lieu tu bang lan kham");

        } catch (Exception e) {
            Log.e("getAllLanKham:", "Loi get du lieu tu bang lan kham");
        }
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            LanKham lanKham = new LanKham();

            lanKham.setIdLanKham(cursor.getInt(0));
            lanKham.setBenhNhan(new BenhNhan(cursor.getInt(1)));
            lanKham.setTrieuChung(cursor.getString(2));
            lanKham.setSoLieu(cursor.getString(3));
            lanKham.setNgayDo(cursor.getString(4));
            danhSachLanKham.add(lanKham);

            cursor.moveToNext();
        }

        cursor.close();
        return danhSachLanKham;
    }
}
