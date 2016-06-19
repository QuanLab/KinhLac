package com.phamquan.maydonhietdo.domoi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.Helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class CharPersonal extends AppCompatActivity {

    public int[] COLOR_LEFT;
    public int[] COLOR_RIGHT;
    public int[] COLOR_MID;


    //ti le phan tram  sau khi tinh
    private float[] benTrai;
    private float[] benPhai;
    private float[] trungBinh;

    private ArrayList<String> thongTin;

    TextView tvHoTen, tvNamSinh, tvDiaChi, tvSoDienThoai, tvTrieuChung;

    private View rootView;
    Bitmap bitmap;
    private BarChart chart;
    BarData dataTwoBar, dataOneBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_personal);

        rootView = findViewById(android.R.id.content).getRootView();
        mappingValue();

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {

            float[] tayTrai = bundle.getFloatArray("tayTrai");
            float[] tayPhai = bundle.getFloatArray("tayPhai");
            float[] chanTrai = bundle.getFloatArray("chanTrai");
            float[] chanPhai = bundle.getFloatArray("chanPhai");
            thongTin = bundle.getStringArrayList("thongTin");

            Vector phanTram = Helper.applyRule(tayTrai, tayPhai, chanTrai, chanPhai);
            benTrai = (float[]) phanTram.get(0);
            benPhai = (float[]) phanTram.get(1);
            trungBinh = (float[]) phanTram.get(2);
        }

        COLOR_LEFT = new int[12];
        COLOR_RIGHT = new int[12];
        COLOR_MID = new int[12];

        for(int i = 0; i< 12; i++){ // set color for each bar
            COLOR_LEFT[i] = Helper.getColor(benTrai[i]);
            COLOR_RIGHT[i] = Helper.getColor(benPhai[i]);
            COLOR_MID[i] = Helper.getColor(trungBinh[i]);
        }

        chart = (BarChart) findViewById(R.id.chartZoom);
        dataTwoBar = new BarData(getXAxisValues(), getDataSet(benTrai,benPhai));
        dataOneBar = new BarData(getXAxisValues(), getDataSetOneBar(trungBinh));
        dataOneBar.setDrawValues(false);
        dataTwoBar.setDrawValues(false);
    }

    public void onClick(View view){

        switch (view.getId()){

            case R.id.btnHaiCot:
                openTwoBarChart();
                break;
            case R.id.btnMotCot:
                openOneBarChart();
                break;
            case R.id.btnLuuAnh:
                bitmap = createBitmap();
                saveBitmap(bitmap);
                break;
            case R.id.btnXong:
                finish();
                break;
        }
    }

    public void openTwoBarChart(){

        setChartInfo();
        chart.setData(dataTwoBar);
        chart.setDescription("");
        chart.getXAxis().setTextSize(9);
        chart.getXAxis().setLabelsToSkip(0);
        chart.invalidate();
    }

    public void openOneBarChart(){

        setChartInfo();
        chart.setData(dataOneBar);
        chart.setDescription("");
        chart.getXAxis().setTextSize(9);
        chart.getXAxis().setLabelsToSkip(0);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet(float[] leftBar, float[] rightBar) {

        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(leftBar[0], 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(leftBar[1], 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(leftBar[2], 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(leftBar[3], 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(leftBar[4], 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(leftBar[5], 5); // Jun
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(leftBar[6], 6); // Jan
        valueSet1.add(v1e7);
        BarEntry v1e8 = new BarEntry(leftBar[7], 7); // Feb
        valueSet1.add(v1e8);
        BarEntry v1e9 = new BarEntry(leftBar[8], 8); // Mar
        valueSet1.add(v1e9);
        BarEntry v1e10 = new BarEntry(leftBar[9], 9); // Apr
        valueSet1.add(v1e10);
        BarEntry v1e11 = new BarEntry(leftBar[10], 10); // May
        valueSet1.add(v1e11);
        BarEntry v1e12 = new BarEntry(leftBar[11], 11); // Jun
        valueSet1.add(v1e12);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();

        BarEntry v2e1 = new BarEntry(rightBar[0], 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(rightBar[1], 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(rightBar[2], 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(rightBar[3], 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(rightBar[4], 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(rightBar[5], 5); // Jun
        valueSet2.add(v2e6);
        BarEntry v2e7 = new BarEntry(rightBar[6], 6); // Jan
        valueSet2.add(v2e7);
        BarEntry v2e8 = new BarEntry(rightBar[7], 7); // Feb
        valueSet2.add(v2e8);
        BarEntry v2e9 = new BarEntry(rightBar[8], 8); // Mar
        valueSet2.add(v2e9);
        BarEntry v2e10 = new BarEntry(rightBar[9], 9); // Apr
        valueSet2.add(v2e10);
        BarEntry v2e11 = new BarEntry(rightBar[10], 10); // May
        valueSet2.add(v2e11);
        BarEntry v2e12 = new BarEntry(rightBar[11], 11); // Jun
        valueSet2.add(v2e12);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Ben Trai");
        barDataSet1.setColors(COLOR_LEFT);
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Ben Phai");
        barDataSet2.setColors(COLOR_RIGHT);
        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<BarDataSet> getDataSetOneBar(float[] midBar) {

        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(midBar[0], 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(midBar[1], 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(midBar[2], 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(midBar[3], 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(midBar[4], 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(midBar[5], 5); // Jun
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(midBar[6], 6); // Jan
        valueSet1.add(v1e7);
        BarEntry v1e8 = new BarEntry(midBar[7], 7); // Feb
        valueSet1.add(v1e8);
        BarEntry v1e9 = new BarEntry(midBar[8], 8); // Mar
        valueSet1.add(v1e9);
        BarEntry v1e10 = new BarEntry(midBar[9], 9); // Apr
        valueSet1.add(v1e10);
        BarEntry v1e11 = new BarEntry(midBar[10], 10); // May
        valueSet1.add(v1e11);
        BarEntry v1e12 = new BarEntry(midBar[11], 11); // Jun
        valueSet1.add(v1e12);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "");
        barDataSet1.setColors(COLOR_MID);
        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {

        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("TÌ");
        xAxis.add("CAN");
        xAxis.add("VỊ");
        xAxis.add("ĐỞM");
        xAxis.add("THẬN");
        xAxis.add("BÀNG QUANG");
        xAxis.add("PHẾ");
        xAxis.add("ĐÂỊ TRƯỜNG");
        xAxis.add("TÂM BÀO");
        xAxis.add("TAM TIÊU");
        xAxis.add("TÂM");
        xAxis.add("TIỂU TRƯỜNG");
        return xAxis;
    }

    public Bitmap createBitmap() {

        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(false);

        if(rootView.getDrawingCache() != null) {
            Bitmap  bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheEnabled(false);
            return bitmap;
        } else {
            return null;
        }
    }


    public void saveBitmap(Bitmap bitmap) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        String strDateTime = dateFormat.format(cal.getTime());

        File imagePath = new File(Environment.getExternalStorageDirectory() + "/" + strDateTime +".png");
        Log.e(this.getClass().toString(), "" + imagePath.getAbsolutePath());
        FileOutputStream fos;

        try {

            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    public void mappingValue(){

        tvHoTen = (TextView) findViewById(R.id.tv_ho_ten);
        tvNamSinh = (TextView) findViewById(R.id.tv_ngay_sinh_c);
        tvDiaChi = (TextView) findViewById(R.id.tv_dia_chi_c);
        tvSoDienThoai = (TextView) findViewById(R.id.tv_so_dien_thoai_c);
        tvTrieuChung = (TextView) findViewById(R.id.tv_trieu_chung_c);
    }

    public void setChartInfo(){

        try{
            tvHoTen.setText(thongTin.get(0));
            tvNamSinh.setText(thongTin.get(1));
            tvDiaChi.setText(thongTin.get(2));
            tvSoDienThoai.setText(thongTin.get(3));
            tvTrieuChung.setText(thongTin.get(4));
        } catch (Exception e){

        }
    }
}
