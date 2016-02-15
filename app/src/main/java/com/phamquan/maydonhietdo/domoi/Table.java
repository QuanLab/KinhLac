package com.phamquan.maydonhietdo.domoi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phamquan.maydonhietdo.R;

public class Table extends AppCompatActivity {

    private Button btnClose;

    private EditText edtTieuTruong, edtTieuTruong_,
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
    protected void onCreate(Bundle savedInstanceState) throws  ArrayIndexOutOfBoundsException{

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        reflex();

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            float[] benTrai = bundle.getFloatArray("benTrai");
            float[] benPhai = bundle.getFloatArray("benPhai");

            edtTieuTruong.setText(String.valueOf(benTrai[0]));
            edtTieuTruong_.setText(String.valueOf(benPhai[0]));
            edtTam.setText(String.valueOf(benTrai[1]));
            edtTam_.setText(String.valueOf(benPhai[1]));
            edtTamTieu.setText(String.valueOf(benTrai[2]));
            edtTamTieu_.setText(String.valueOf(benPhai[2]));
            edtTamBao.setText(String.valueOf(benTrai[3]));
            edtTamBao_.setText(String.valueOf(benPhai[3]));
            edtDaiTruong.setText(String.valueOf(benTrai[4]));
            edtDaiTruong_.setText(String.valueOf(benPhai[4]));
            edtPhe.setText(String.valueOf(benTrai[5]));
            edtPhe_.setText(String.valueOf(benPhai[5]));

            edtBangQuang.setText(String.valueOf(benTrai[6]));
            edtBangQuang_.setText(String.valueOf(benPhai[6]));
            edtThan.setText(String.valueOf(benTrai[7]));
            edtThan_.setText(String.valueOf(benPhai[7]));
            edtDom.setText(String.valueOf(benTrai[8]));
            edtDom_.setText(String.valueOf(benPhai[8]));
            edtVi.setText(String.valueOf(benTrai[9]));
            edtVi_.setText(String.valueOf(benPhai[9]));
            edtCan.setText(String.valueOf(benTrai[10]));
            edtCan_.setText(String.valueOf(benPhai[10]));
            edtTi.setText(String.valueOf(benTrai[11]));
            edtTi_.setText(String.valueOf(benPhai[11]));
        }

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void reflex(){

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

        btnClose = (Button) findViewById(R.id.btnClose);
    }
}
