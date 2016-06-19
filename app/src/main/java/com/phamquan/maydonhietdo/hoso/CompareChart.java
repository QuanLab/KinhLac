package com.phamquan.maydonhietdo.hoso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.Helper;

import java.util.ArrayList;
import java.util.Vector;

public class CompareChart extends AppCompatActivity {

    private TextView tvHoTen, tvNamSinh, tvDiaChi, tvSoDienThoai;
    private ArrayList<String> thongTin;
    String soLieuX, soLieuY;

    public int[] COLOR_LEFT;
    public int[] COLOR_RIGHT;
    private static float[] benTrai;
    private static float[] benPhai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_chart);

        thongTin = new ArrayList<>();
        benTrai = new float[12];
        benPhai = new float[12];
        COLOR_LEFT = new int[12];
        COLOR_RIGHT = new int[12];

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            thongTin = bundle.getStringArrayList("thongTin");
            soLieuX = bundle.getString("soLieuX");
            soLieuY = bundle.getString("soLieuY");

            float[] soX = Helper.stringToFloat(soLieuX);
            float[] soY = Helper.stringToFloat(soLieuY);

            float[] tayTraiX = new float[6];
            float[] tayPhaiX = new float[6];
            float[] chanTraiX = new float[6];
            float[] chanPhaiX = new float[6];

            float[] tayTraiY = new float[6];
            float[] tayPhaiY = new float[6];
            float[] chanTraiY = new float[6];
            float[] chanPhaiY = new float[6];

            for(int i= 0; i < 6; i++){

                tayTraiX[i] = soX[i];
                tayPhaiX[i] = soX[i + 6];
                chanTraiX[i] = soX[i + 12];
                chanPhaiX[i] = soX[i + 18];

                tayTraiY[i] = soY[i];
                tayPhaiY[i] = soY[i + 6];
                chanTraiY[i] = soY[i + 12];
                chanPhaiY[i] = soY[i + 18];

            }

            Vector phanTramX = Helper.applyRule(tayTraiX, tayPhaiX, chanTraiX, chanPhaiX);
            Vector phanTramY = Helper.applyRule(tayTraiY, tayPhaiY, chanTraiY, chanPhaiY);

            benTrai = (float[]) phanTramX.get(2); //lay pham tram trung binh hai tay trong lan do X
            benPhai = (float[]) phanTramY.get(2);
        }

        if(!thongTin.isEmpty()){
//            setChartInfo();
        }

        for(int i = 0; i< 12; i++){
            COLOR_LEFT[i] = Helper.getColor(benTrai[i]);
            COLOR_RIGHT[i] = Helper.getColor(benPhai[i]);
        }

        BarChart chart = (BarChart) findViewById(R.id.chartZoo);

        BarData data = new BarData(getXAxisValues(), getDataSet(benTrai, benPhai));
        chart.setData(data);
        data.setDrawValues(false);
        chart.setDescription("");
        chart.getXAxis().setTextSize(9);
        chart.getXAxis().setLabelsToSkip(0);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet(float[] leftBar, float[] rightBar) {

        ArrayList<BarDataSet> dataSets;

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

        BarEntry v2e1 = new BarEntry(rightBar[0], 0); // Jul
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(rightBar[1], 1); // Aug
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(rightBar[2], 2); // Sep
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(rightBar[3], 3); // Oct
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(rightBar[4], 4); // Nov
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

    public void setChartInfo(){

        tvHoTen.setText(thongTin.get(0));
        tvNamSinh.setText(thongTin.get(1));
        tvDiaChi.setText(thongTin.get(2));
        tvSoDienThoai.setText(thongTin.get(3));
    }

}
