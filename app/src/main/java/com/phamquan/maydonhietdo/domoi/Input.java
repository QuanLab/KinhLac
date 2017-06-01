package com.phamquan.maydonhietdo.domoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.BenhNhan;
import com.phamquan.maydonhietdo.database.BenhNhanDataSource;
import com.phamquan.maydonhietdo.database.Helper;
import com.phamquan.maydonhietdo.database.LanKham;

import java.util.ArrayList;

public class Input extends AppCompatActivity {

    private ArrayList<String> thongTin;
    private BenhNhanDataSource dataSource;
    private static int idBenhNhan = -1;

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

    // nhom nhiet do tren cac phan co the
    private float[] tayTrai = new float[6];
    private float[] tayPhai = new float[6];
    private float[] chanTrai = new float[6];
    private float[] chanPhai = new float[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        reflex();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            thongTin = bundle.getStringArrayList("thongTin");
        }
    }

    public void onClick(View view) {

        if (getInputValue()) {

           if(!Helper.isDataSaved()){
               taoHoSoBenhNhan();
               Helper.setDataSaved(true);
           }

            switch (view.getId()) {

                case R.id.btnKetQuaBang:
                    openTable();
                    break;

                case R.id.btnXemBieuDo:
                    openChart();
                    break;
            }
        }
    }

    public void openTable() {

        Intent intent = new Intent(this, Table.class);
        intent.putExtra("tayTrai", tayTrai);
        intent.putExtra("tayPhai", tayPhai);
        intent.putExtra("chanTrai", chanTrai);
        intent.putExtra("chanPhai", chanPhai);
        intent.putExtra("thongTin", thongTin);
        startActivity(intent);
    }

    public void openChart() {

        Intent intent = new Intent(Input.this, ChartPersonal.class);
        intent.putExtra("tayTrai", tayTrai);
        intent.putExtra("tayPhai", tayPhai);
        intent.putExtra("chanTrai", chanTrai);
        intent.putExtra("chanPhai", chanPhai);
        intent.putExtra("thongTin", thongTin);
        startActivity(intent);
    }

    public boolean getInputValue() {

        String tieu_truong = edtTieuTruong.getText().toString();
        String tieu_truong_ = edtTieuTruong_.getText().toString();
        String tam = edtTam.getText().toString();
        String tam_ = edtTam_.getText().toString();
        String tam_tieu = edtTamTieu.getText().toString();
        String tam_tieu_ = edtTamTieu_.getText().toString();
        String tam_bao = edtTamBao.getText().toString();
        String tam_bao_ = edtTamBao_.getText().toString();
        String dai_truong = edtDaiTruong.getText().toString();
        String dai_truong_ = edtDaiTruong_.getText().toString();
        String phe = edtPhe.getText().toString();
        String phe_ = edtPhe_.getText().toString();

        String bang_quang = edtBangQuang.getText().toString();
        String bang_quang_ = edtBangQuang_.getText().toString();
        String than = edtThan.getText().toString();
        String than_ = edtThan_.getText().toString();
        String dom = edtDom.getText().toString();
        String dom_ = edtDom_.getText().toString();
        String vi = edtVi.getText().toString();
        String vi_ = edtVi_.getText().toString();
        String can = edtCan.getText().toString();
        String can_ = edtCan_.getText().toString();
        String ti = edtTi.getText().toString();
        String ti_ = edtTi_.getText().toString();

        if (tieu_truong.isEmpty() || tieu_truong_.isEmpty() || tam.isEmpty() || tam_.isEmpty()
                || tam_tieu.isEmpty() || tam_tieu_.isEmpty() || tam_bao.isEmpty() || tam_bao_.isEmpty()
                || dai_truong.isEmpty() || dai_truong_.isEmpty() || phe.isEmpty()
                || bang_quang.isEmpty() || bang_quang_.isEmpty()
                || than.isEmpty() || than_.isEmpty() || dom.isEmpty() || dom_.isEmpty()
                || vi.isEmpty() || vi_.isEmpty() || can.isEmpty() || can_.isEmpty() || ti.isEmpty() || ti_.isEmpty()) {
            showE();
            return false;
        }

        float tieuTruong = Float.parseFloat(tieu_truong);
        float tieuTruong_ = Float.parseFloat(tieu_truong_);
        float tamT = Float.parseFloat(tam);
        float tamP = Float.parseFloat(tam_);
        float tamTieu = Float.parseFloat(tam_tieu);
        float tamTieu_ = Float.parseFloat(tam_tieu_);
        float tamBao = Float.parseFloat(tam_bao);
        float tamBao_ = Float.parseFloat(tam_bao_);
        float daiTruong = Float.parseFloat(dai_truong);
        float daiTruong_ = Float.parseFloat(dai_truong_);
        float pheT = Float.parseFloat(phe);
        float pheP = Float.parseFloat(phe_);


        tayTrai[0] = tieuTruong/10;
        tayTrai[1] = tamT/10;
        tayTrai[2] = tamTieu/10;
        tayTrai[3] = tamBao/10;
        tayTrai[4] = daiTruong/10;
        tayTrai[5] = pheT/10;

        tayPhai[0] = tieuTruong_/10;
        tayPhai[1] = tamP/10;
        tayPhai[2] = tamTieu_/10;
        tayPhai[3] = tamBao_/10;
        tayPhai[4] = daiTruong_/10;
        tayPhai[5] = pheP/10;

        float bangQuang = Float.parseFloat(bang_quang);
        float bangQuang_ = Float.parseFloat(bang_quang_);
        float thanT = Float.parseFloat(than);
        float thanP = Float.parseFloat(than_);
        float domT = Float.parseFloat(dom);
        float domP = Float.parseFloat(dom_);
        float viT = Float.parseFloat(vi);
        float viP = Float.parseFloat(vi_);
        float canT = Float.parseFloat(can);
        float canP = Float.parseFloat(can_);
        float tiT = Float.parseFloat(ti);
        float tiP = Float.parseFloat(ti_);

        chanTrai[0] = bangQuang/10;
        chanTrai[1] = thanT/10;
        chanTrai[2] = domT/10;
        chanTrai[3] = viT/10;
        chanTrai[4] = canT/10;
        chanTrai[5] = tiT/10;

        chanPhai[0] = bangQuang_/10;
        chanPhai[1] = thanP/10;
        chanPhai[2] = domP/10;
        chanPhai[3] = viP/10;
        chanPhai[4] = canP/10;
        chanPhai[5] = tiP/10;

        return true;
    }

    public void taoHoSoBenhNhan() {

        dataSource = new BenhNhanDataSource(this);
        dataSource.open();

        if(!Helper.isDaCoHoSo()){
            dataSource.insertBenhNhan(new BenhNhan(thongTin.get(0), thongTin.get(1), thongTin.get(2), thongTin.get(3)));
            idBenhNhan = dataSource.countBenhNhan();
        }

        StringBuilder soLieuBuffer = new StringBuilder();
        soLieuBuffer.append(Helper.floatToString(tayTrai));
        soLieuBuffer.append(Helper.floatToString(tayPhai));
        soLieuBuffer.append(Helper.floatToString(chanTrai));
        soLieuBuffer.append(Helper.floatToString(chanPhai));
        String soLieu = new String(soLieuBuffer);

        String trieuChung = thongTin.get(4);
        String ngayDo = thongTin.get(5);

        if(idBenhNhan <0){
            String idString = thongTin.get(6);
            idBenhNhan = Integer.parseInt(idString);
        }

        LanKham lanKham = new LanKham(trieuChung, soLieu, ngayDo);
        lanKham.setBenhNhan(new BenhNhan(idBenhNhan));

        dataSource.insertLanKham(lanKham);
    }

    public void showE() {
        Toast.makeText(this, "Nhập thiếu số liệu rồi ông bạn ơi!", Toast.LENGTH_SHORT).show();
    }

    private void reflex() {

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
    }
}
