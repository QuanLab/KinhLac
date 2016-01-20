package com.phamquan.maydonhietdo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Input extends AppCompatActivity {

    Button btnKetQuaBang, btnChart;
    EditText edtTieuTruong, edtTieuTruong_,
            edtTam, edtTam_,
            edtTamTieu, edtTamTieu_,
            edtTamBao, edtTamBao_,
            edtDaiTruong, edtDaiTruong_,
            edtPhe, edtPhe_,

            edtBangQuang, edtBangQuang_,
            edtThan, edtThan_,
            edtDom, edtDom_,
            edtVi, edtVi_,
            edtCan, edtCan_,
            edtTi, edtTi_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
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

        btnKetQuaBang = (Button) findViewById(R.id.btnKetQuaBang);
        btnChart = (Button) findViewById(R.id.btnXemBieuDo);

        edtTieuTruong = (EditText) findViewById(R.id.EditTextTieuTruong);
        edtTieuTruong_ = (EditText) findViewById(R.id.EditTextTieuTruong_);
        edtTam = (EditText) findViewById(R.id.EditTextTam);
        edtTam_ = (EditText) findViewById(R.id.EditTextTam_);
        edtTamTieu = (EditText) findViewById(R.id.EditTextTamTieu);
        edtTamTieu_ = (EditText) findViewById(R.id.EditTextTamTieu_);
        edtTamBao = (EditText) findViewById(R.id.EditTextTamBao);
        edtTamBao_ = (EditText) findViewById(R.id.EditTextTamBao_);
        edtDaiTruong = (EditText) findViewById(R.id.EditTextDaiTruong);
        edtDaiTruong_ = (EditText) findViewById(R.id.EditTextDaiTruong_);
        edtPhe = (EditText) findViewById(R.id.EditTextPhe);
        edtPhe_ = (EditText) findViewById(R.id.EditTextPhe_);

        edtBangQuang = (EditText) findViewById(R.id.EditTextBangQuang);
        edtBangQuang_ = (EditText) findViewById(R.id.EditTextBangQuang_);
        edtThan = (EditText) findViewById(R.id.EditTextThan);
        edtThan_ = (EditText) findViewById(R.id.EditTextThan_);
        edtDom = (EditText) findViewById(R.id.EditTextDom);
        edtDom_ = (EditText) findViewById(R.id.EditTextDom_);
        edtVi = (EditText) findViewById(R.id.EditTextVi);
        edtVi_ = (EditText) findViewById(R.id.EditTextVi_);
        edtCan = (EditText) findViewById(R.id.EditTextCan);
        edtCan_ = (EditText) findViewById(R.id.EditTextCan_);
        edtTi = (EditText) findViewById(R.id.EditTextTi);
        edtTi_ = (EditText) findViewById(R.id.EditTextTi_);

        btnKetQuaBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTable();
            }
        });

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChart();
            }
        });
    }

    public void openTable() {
        Intent intent = new Intent(this, Table.class);
        startActivity(intent);
    }

    public void openChart(){
        Intent intent = new Intent(Input.this, Chart.class);
        startActivity(intent);
    }

    public float getMin(float[] arrFloat){

        float min = arrFloat[0];
        for(int i = 0; i< arrFloat.length; i++){
            if(arrFloat[i]<min){
                min = arrFloat[i];
            }
        }
        return min;
    }

    public float getMax(float[] arrFloat) {

        float max = arrFloat[0];
        for (int i = 0; i < arrFloat.length; i++) {
            if (arrFloat[i] > max) {
                max = arrFloat[i];
            }
        }
        return max;
    }
}
