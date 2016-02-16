package com.phamquan.maydonhietdo.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbQuanLyBenhNhan.sqlite";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_BENH_NHAN = "tblbenhnhan";
    public static final String TABLE_KHAM_BENH = "tblkhambenh";


    private static final String DATABASE_CREATE_TABLE_BENH_NHAN =
            "CREATE TABLE 'tblbenhnhan' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    "'hoten' TEXT, 'namsinh' INTEGER, 'diachi' TEXT, 'sodienthoai' TEXT)";

    private static final String DATABASE_CREATE_TABLE_KHAM_BENH =
            "CREATE TABLE 'tblkhambenh' ('idlankham' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " +
                    "'idbenhnhan' INTEGER, 'trieuchung' TEXT, 'solieu' TEXT, 'ngaydo' TEXT )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        try{
            database.execSQL(DATABASE_CREATE_TABLE_BENH_NHAN);
            database.execSQL(DATABASE_CREATE_TABLE_KHAM_BENH);

        }catch (SQLException e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.e(DatabaseHelper.class.getName(), "Update database from version " + oldVersion + " to " + newVersion
                + ", please check to avoid losing your data!");
        db.execSQL("DROP TABLE tblbenhnhan;");
    }

}