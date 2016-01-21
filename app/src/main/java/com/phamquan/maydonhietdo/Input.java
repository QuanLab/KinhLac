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

    private float maxHaiTay, minHaiTay, maxHaiChan, minHaiChan;
    private float maxTayTrai,minTayTrai, maxTayPhai, minTayPhai ;
    private float maxChanTrai, minChanTrai, maxChanPhai, minChanPhai;

    // nhom nhiet do tren cac phan co the
    private float[] tayTrai = new float[6];
    private float[] tayPhai = new float[6];
    private float[] chanTrai = new float[6];
    private float[] chanPhai = new float[6];

    //ti le phan tram  sau khi tinh
    private static float[] phanTramTrai = new float[12];
    private static float[] phanTramPhai = new float[12];

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnKetQuaBang = (Button) findViewById(R.id.btnKetQuaBang);
        btnChart = (Button) findViewById(R.id.btnClose);

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
                caculateInit();
                openTable();
            }
        });

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculateInit();
                openChart();
            }
        });
    }

    public void openTable() {

        Intent intent = new Intent(this, Table.class);
        intent.putExtra("benTrai", phanTramTrai);
        intent.putExtra("benPhai", phanTramPhai);
        startActivity(intent);
    }

    public void openChart(){

        Intent intent = new Intent(Input.this, Chart.class);
        intent.putExtra("benTrai", phanTramTrai);
        intent.putExtra("benPhai", phanTramPhai);
        startActivity(intent);
    }

    public void caculateInit() {

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

        float tieuTruong = Float.parseFloat(tieu_truong);
        float tieuTruong_ = Float.parseFloat(tieu_truong_);
        float tamT =Float.parseFloat(tam);
        float tamP = Float.parseFloat(tam_);
        float tamTieu = Float.parseFloat(tam_tieu);
        float tamTieu_ = Float.parseFloat(tam_tieu_);
        float tamBao = Float.parseFloat(tam_bao);
        float tamBao_ = Float.parseFloat(tam_bao_);
        float daiTruong = Float.parseFloat(dai_truong);
        float daiTruong_ = Float.parseFloat(dai_truong_);
        float pheT = Float.parseFloat(phe);
        float pheP = Float.parseFloat(phe_);

        tayTrai[0] = tieuTruong; tayTrai[1] = tamT; tayTrai[2] = tamTieu;
        tayTrai[3] = tamBao; tayTrai[4]= daiTruong; tayTrai[5] = pheT;

        tayPhai[0] = tieuTruong_; tayPhai[1]= tamP; tayPhai[2] = tamTieu_;
        tayPhai[3] = tamBao_; tayPhai[4] = daiTruong_; tayPhai[5] = pheP;

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

        chanTrai[0] = bangQuang; chanTrai[1] = thanT; chanTrai[2] = domT;
        chanTrai[3] = viT; chanTrai[4] = canT; chanTrai [5] = tiT;

        chanPhai[0] = bangQuang_; chanPhai[1] = thanP; chanPhai[2] = domP;
        chanPhai[3] = viP; chanPhai[4] = canP; chanPhai [5] = tiP;

        maxTayTrai = getMax(tayTrai);
        maxTayPhai = getMax(tayPhai);
        maxHaiTay = Math.max(maxTayTrai, maxTayPhai);

        maxChanTrai = getMax(chanTrai);
        maxChanPhai = getMax(chanPhai);
        maxHaiChan = Math.max(maxChanTrai, maxChanPhai);

        //ti le phan tram theo cac bo phan tren co the
        float pTieuTruong, pTieuTruong_, pTam, pTam_, pTamTieu, pTamTieu_, pTamBao, pTamBao_,
                pDaiTuong, pDaiTruong_, pPhe, pPhe_, pBangQuang, pBangQuang_, pThan, pThan_,
                pDom, pDom_, pVi, pVi_, pCan, pCan_, pTi, pTi_;

        float percentTayTrai;
        float percenetChanTrai;
        float percentTayPhai;
        float percentChanPhai;

        float maxMinHaiTay = maxHaiTay - minHaiTay;
        float maxMinHaiChan = maxHaiChan - minHaiChan;

        int j = 6;

        for(int i = 0; i<6; i++){
        /*
        * 3*(nhietDoTayTrai + nhietDoTayPhai - nhietDoMaxOTay - nhietDoMinOTay)
        * /(nhietDoMax - nhietDoMin)
        * */
            percentTayTrai = 300 * (tayTrai[i] + tayPhai[i] - maxTayTrai - minTayTrai) / maxMinHaiTay;
            percenetChanTrai = 300 * (chanTrai[i] + chanPhai[i] - maxChanTrai - minChanTrai) / maxMinHaiChan;

            percentTayPhai = 300 * (tayTrai[i] + tayPhai[i] - maxTayPhai - minTayPhai) / maxMinHaiTay;
            percentChanPhai = 300 * (chanTrai[i] + chanPhai[i] - maxChanPhai - minChanPhai) / maxMinHaiChan;

            phanTramTrai[i] = percentTayTrai;
            phanTramTrai[j] = percenetChanTrai;

            phanTramPhai[i] = percentTayPhai;
            phanTramPhai[j] = percentChanPhai;
            ++j;
        }
    }

    public float getMin(float[] arrFloat) {

        float min = arrFloat[0];
        for (int i = 0; i < arrFloat.length; i++) {
            if (arrFloat[i] < min) {
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
