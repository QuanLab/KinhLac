package com.phamquan.maydonhietdo.domoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phamquan.maydonhietdo.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonInfo extends AppCompatActivity {

    private ArrayList<String> thongTin = new ArrayList<>();
    private Button btnBatDauDo;
    private EditText edtHoTen, edtDiaChi, edtSoDienThoai, edtTrieuChung, edtNgayDo;
    private String hoTen, diaChi, trieuChung, soDienThoai, ngayDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String strDateTime = dateFormat.format(cal.getTime());

        btnBatDauDo = (Button) findViewById(R.id.btnBatDauDo);

        edtHoTen = (EditText) findViewById(R.id.editText_ho_ten);
        edtDiaChi = (EditText) findViewById(R.id.editText_dia_chi);
        edtTrieuChung = (EditText) findViewById(R.id.editText_trieu_chung);
        edtSoDienThoai = (EditText) findViewById(R.id.editText_so_dien_thoai);
        edtNgayDo = (EditText) findViewById(R.id.editText_ngay_do);
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
        diaChi = edtDiaChi.getText().toString();
        trieuChung = edtTrieuChung.getText().toString();
        ngayDo = edtNgayDo.getText().toString();
        soDienThoai = edtSoDienThoai.getText().toString();

        thongTin.add(hoTen);
        thongTin.add(diaChi);
        thongTin.add(ngayDo);
        thongTin.add(soDienThoai);
        thongTin.add(trieuChung);

        Intent intent = new Intent(this, Input.class);
        intent.putExtra("thongTin", thongTin);
        startActivity(intent);
    }
}
