package com.phamquan.maydonhietdo.hoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.BenhNhanDataSource;
import com.phamquan.maydonhietdo.database.LanKham;
import com.phamquan.maydonhietdo.domoi.PersonInfo;

import java.util.ArrayList;


public class HoSoBenhNhan extends AppCompatActivity {

    private ListView lv_lan_kham;
    private ArrayList<LanKham> mangLanKham;
    private TextView tvHoTen, tvNamSinh, tvDiaChi, tvSoDienThoai;
    private EditText edtLanX, edtLanY;
    private Button btnSoSanh, btnDoMoi;
    private BenhNhanDataSource datasource;
    private static String hoTen, namSinh, diaChi, soDienThoai;
    private static int idBenhNhan;

    ArrayList<String> thongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_benh_nhan);

        reflexHoSo();
        thongTin = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();

        String _id = bundle.getString("idBenhNhan");
        idBenhNhan = Integer.parseInt(_id);
        hoTen = bundle.getString("hoTen");
        namSinh = bundle.getString("namSinh");
        diaChi = bundle.getString("diaChi");
        soDienThoai = bundle.getString("soDienThoai");

        tvHoTen.setText(hoTen);
        tvNamSinh.setText(namSinh);
        tvDiaChi.setText(diaChi);
        tvSoDienThoai.setText(soDienThoai);

        datasource = new BenhNhanDataSource(this);
        datasource.open();

        try{
            mangLanKham = datasource.getAllLanKham();
            Log.e(this.getClass().toString(), "lay tat ca lan kham thanh cong");
        } catch (Exception e){
            Log.e(this.getClass().toString(), "lay tat ca lan kham bi loi" + e);
        }

        btnSoSanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soSanh();
            }
        });

        btnDoMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doMoi();
            }
        });
    }

    public void doMoi() {

        Intent intent = new Intent(this, PersonInfo.class);
        intent.putExtra("idBenhNhan", idBenhNhan);
        intent.putExtra("hoTen", hoTen);
        intent.putExtra("namSinh", namSinh);
        intent.putExtra("diaChi", diaChi);
        intent.putExtra("soDienThoai", soDienThoai);
        startActivity(intent);
    }

    public void soSanh() {

        int size = mangLanKham.size();

        if (size >= 2) {

            String chuoiLanX = edtLanX.getText().toString();
            String chuoiLanY = edtLanY.getText().toString();
            int lanX = Integer.parseInt(chuoiLanX);
            int lanY = Integer.parseInt(chuoiLanY);

            if ((lanX >= 0) && (lanY >= 0) && (lanX <= size) && (lanY <= size) && (lanX != lanY)) {

                Intent intent2 = new Intent(this, CompareTwoChart.class);
                startActivity(intent2);

            } else {
                Toast.makeText(this, "Nhập số chuẩn đi ông bạn!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Có lần đo nào đâu mà so sánh", Toast.LENGTH_LONG).show();
        }
    }

    private void reflexHoSo() {

        btnSoSanh = (Button) findViewById(R.id.btn_so_sanh);
        btnDoMoi = (Button) findViewById(R.id.btn_do_moi);
        tvHoTen = (TextView) findViewById(R.id.tv_ho_ten);
        tvNamSinh = (TextView) findViewById(R.id.tv_ngay_sinh);
        tvDiaChi = (TextView) findViewById(R.id.tv_dia_chi);
        tvSoDienThoai = (TextView) findViewById(R.id.tv_so_dien_thoai);

        edtLanX = (EditText) findViewById(R.id.edt_lan_x);
        edtLanY = (EditText) findViewById(R.id.edt_lan_y);
    }

}
