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
import com.phamquan.maydonhietdo.database.BenhNhan;
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
    private static String hoTen, namSinh, diaChi, soDienThoai, idBenhNhan;

    ArrayList<String> thongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_benh_nhan);

        reflexHoSo();

        thongTin = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();

        idBenhNhan = bundle.getString("idBenhNhan");
        hoTen = bundle.getString("hoTen");
        namSinh = bundle.getString("namSinh");
        diaChi = bundle.getString("diaChi");
        soDienThoai = bundle.getString("soDienThoai");

        thongTin.add(hoTen);
        thongTin.add(namSinh);
        thongTin.add(diaChi);
        thongTin.add(soDienThoai);

        tvHoTen.setText(hoTen);
        tvNamSinh.setText(namSinh);
        tvDiaChi.setText(diaChi);
        tvSoDienThoai.setText(soDienThoai);

        datasource = new BenhNhanDataSource(this);
        datasource.open();

        try {
            mangLanKham = datasource.getAllLanKham(new BenhNhan(Integer.parseInt(idBenhNhan)));
            Log.e("HoSoBenhNhan:", "Lay tat ca lan kham thanh cong");
        } catch (Exception e) {
            Log.e("HoSoBenhNhan:", "Lay tat ca lan kham bi loi" + e);
        }

        ListAdapterLanKham adapter = new ListAdapterLanKham(this, R.layout.activity_dong_benh_nhan_mau, mangLanKham);
        lv_lan_kham.setAdapter(adapter);

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

    public boolean soSanh() {

        int size = mangLanKham.size();
        Log.e("Kich thuoc: ", "" + size);

        if (size >= 2) {

            String chuoiLanX = edtLanX.getText().toString();
            String chuoiLanY = edtLanY.getText().toString();

            if(chuoiLanX.isEmpty()||chuoiLanY.isEmpty()){
                Toast.makeText(this, "Không nhập số rồi ông ơi!", Toast.LENGTH_LONG).show();
                return false;
            }

            int lanThuX = Integer.parseInt(chuoiLanX);
            int lanThuY = Integer.parseInt(chuoiLanY);

            if ((lanThuX >0) && (lanThuY >0) && (lanThuX <= size) && (lanThuY <= size) && (lanThuX != lanThuY)) {

                LanKham lanKhamX = mangLanKham.get(lanThuX-1);
                LanKham lanKhamY = mangLanKham.get(lanThuY-1);
                String soLieuX = lanKhamX.getSoLieu();
                String soLieuY = lanKhamY.getSoLieu();

                Intent compareChart = new Intent(this, CompareChart.class);
                compareChart.putExtra("soLieuX", soLieuX );
                compareChart.putExtra("soLieuY", soLieuY );
                compareChart.putExtra("thongTin", thongTin);
                startActivity(compareChart);

            } else {
                Toast.makeText(this, "Nhập số chuẩn đi ông bạn!", Toast.LENGTH_LONG).show();
            }
        } else if(size==0){
            Toast.makeText(this, "Có lần đo nào đâu mà so sánh!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Có một lần đo so sánh thế nào hả ông lão!", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    private void reflexHoSo() {

        lv_lan_kham = (ListView) findViewById(R.id.listViewHoSoBenhNhan);

        btnSoSanh = (Button) findViewById(R.id.btn_so_sanh);
        btnDoMoi = (Button) findViewById(R.id.btn_do_moi);
        tvHoTen = (TextView) findViewById(R.id.tv_ho_ten);
        tvNamSinh = (TextView) findViewById(R.id.tv_ngay_sinh);
        tvDiaChi = (TextView) findViewById(R.id.tv_dia_chi_c);
        tvSoDienThoai = (TextView) findViewById(R.id.tv_trieu_chung_c);

        edtLanX = (EditText) findViewById(R.id.edt_lan_x);
        edtLanY = (EditText) findViewById(R.id.edt_lan_y);
    }

}
