package com.phamquan.maydonhietdo.domoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.DBAintergration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class PersonInfo extends AppCompatActivity {

    private ArrayList<String> thongTin;
    private Button btnBatDauDo;
    private EditText edtHoTen, edtNamSinh, edtDiaChi, edtSoDienThoai, edtTrieuChung, edtNgayDo;
    private static String idBenhNhan, hoTen, namSinh, diaChi, trieuChung, soDienThoai, ngayDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        reflex();

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            DBAintergration.setDaCoHoSo(true);

//            idBenhNhan = bundle.getString("idBenhNhan");
            hoTen = bundle.getString("hoTen");
            namSinh = bundle.getString("namSinh");
            diaChi = bundle.getString("diaChi");
            soDienThoai = bundle.getString("soDienThoai");

            edtHoTen.setText(hoTen);
            edtNamSinh.setText(namSinh);
            edtDiaChi.setText(diaChi);
            edtSoDienThoai.setText(soDienThoai);

        } else {
            DBAintergration.setDaCoHoSo(false);
        }

        DateFormat dateFormat = new SimpleDateFormat("ss:mm:HH dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String strDateTime = dateFormat.format(cal.getTime());

        edtNgayDo.setText(strDateTime);

        btnBatDauDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInputForm();
            }
        });
    }

    public void openInputForm(){

        hoTen = edtHoTen.getText().toString();
        namSinh = edtNamSinh.getText().toString();
        diaChi = edtDiaChi.getText().toString();
        soDienThoai = edtSoDienThoai.getText().toString();
        trieuChung = edtTrieuChung.getText().toString();
        ngayDo = edtNgayDo.getText().toString();

        thongTin = new ArrayList<>();
        thongTin.add(hoTen);
        thongTin.add(namSinh);
        thongTin.add(diaChi);
        thongTin.add(soDienThoai);
        thongTin.add(trieuChung);
        thongTin.add(ngayDo);

        Intent intent = new Intent(this, Input.class);
        intent.putExtra("thongTin", thongTin);
        startActivity(intent);
    }

    public void reflex(){

        btnBatDauDo = (Button) findViewById(R.id.btnBatDauDo);
        edtHoTen = (EditText) findViewById(R.id.editText_ho_ten);
        edtNamSinh = (EditText) findViewById(R.id.editText_ngay_sinh);
        edtDiaChi = (EditText) findViewById(R.id.editText_dia_chi);
        edtTrieuChung = (EditText) findViewById(R.id.editText_trieu_chung);
        edtSoDienThoai = (EditText) findViewById(R.id.editText_so_dien_thoai);
        edtNgayDo = (EditText) findViewById(R.id.editText_ngay_do);
    }
}
