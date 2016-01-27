package com.phamquan.maydonhietdo;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    private View mChart;
    private String[] mMonth = new String[]{
            "Tì", "Can", "Vị", "Đởm", "Thận", "Bàng quang",
            "Phế", "Đại trường", "Tâm bào", "Tam tiêu", "Tâm", "Tiểu trường"
    };

    private float[] benTrai;
    private float[] benPhai;
    private float[] trungBinh;
    private Button btnXong, btnBieuDoMotCot, btnBieuDoHaiCot;
    private TextView tvHoTen, tvDiaChi, tvSoDienThoai;
    private ArrayList<String> thongTin;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        btnXong = (Button) findViewById(R.id.btnXong);
        btnBieuDoMotCot = (Button) findViewById(R.id.btnMotCot);
        btnBieuDoHaiCot = (Button)  findViewById(R.id.btnHaiCot);
        tvHoTen = (TextView) findViewById(R.id.textViewHoTen);
        tvDiaChi = (TextView) findViewById(R.id.textViewDiaChi);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {
            benTrai = bundle.getFloatArray("benTrai");
            benPhai = bundle.getFloatArray("benPhai");
            trungBinh = bundle.getFloatArray("trungBinh");
            thongTin = bundle.getStringArrayList("thongTin");
        }

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBieuDoMotCot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChartOneBar();
            }
        });

        btnBieuDoHaiCot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChart();
            }
        });
    }

    private void openChart() {
        setChartInfo();
        int[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        float [] income = benTrai;
        float [] expense = benPhai;

        XYSeries incomeSeries = new XYSeries("Trai");
        XYSeries expenseSeries = new XYSeries("Phai");

        for (int i = 0; i < x.length; i++) {
            incomeSeries.add(i, income[i]);
            expenseSeries.add(i, expense[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(incomeSeries);
        dataset.addSeries(expenseSeries);

        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer tayTraiRenderer = new XYSeriesRenderer();
        tayTraiRenderer.setColor(Color.CYAN);
        tayTraiRenderer.setFillPoints(true);
        tayTraiRenderer.setLineWidth(2);
//        tayTraiRenderer.setDisplayChartValues(true);
        tayTraiRenderer.setDisplayChartValuesDistance(10); //setting chart value distance

        // Creating XYSeriesRenderer to customize expenseSeries
        XYSeriesRenderer tayPhaiRenderer = new XYSeriesRenderer();
        tayPhaiRenderer.setColor(Color.GREEN);
        tayPhaiRenderer.setFillPoints(true);
        tayPhaiRenderer.setLineWidth(2);
//        tayPhaiRenderer.setDisplayChartValues(true);

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Biểu đồ kết quả đo");
        multiRenderer.setXTitle("Các bộ phận");
        multiRenderer.setYTitle("Phần trăm");

        /***
         * Customizing graphs
         */
//setting text size of the title
        multiRenderer.setChartTitleTextSize(28);
        //setting text size of the axis title
        multiRenderer.setAxisTitleTextSize(24);
        //setting text size of the graph lable
        multiRenderer.setLabelsTextSize(24);
        //setting zoom buttons visiblity
        multiRenderer.setZoomButtonsVisible(false);
        //setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        //setting click false on graph
        multiRenderer.setClickEnabled(false);
        //setting zoom to false on both axis
        multiRenderer.setZoomEnabled(false, false);
        //setting lines to display on y axis
        multiRenderer.setShowGridY(false);
        //setting lines to display on x axis
        multiRenderer.setShowGridX(false);
        //setting legend to fit the screen size
        multiRenderer.setFitLegend(true);
        //setting displaying line on grid
        multiRenderer.setShowGrid(false);
        //setting zoom to false
        multiRenderer.setZoomEnabled(false);
        //setting external zoom functions to false
        multiRenderer.setExternalZoomEnabled(false);
        //setting displaying lines on graph to be formatted(like using graphics)
        multiRenderer.setAntialiasing(true);
        //setting to in scroll to false
        multiRenderer.setInScroll(false);
        //setting to set legend height of the graph
        multiRenderer.setLegendHeight(30);
        //setting x axis label align
        multiRenderer.setXLabelsAlign(Align.CENTER);
        //setting y axis label to align
        multiRenderer.setYLabelsAlign(Align.LEFT);
        //setting text style
        multiRenderer.setTextTypeface("sans_serif", Typeface.NORMAL);
        //setting no of values to display in y axis
        multiRenderer.setYLabels(10);
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(400);
        //setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-0.5);
        //setting max values to be display in x axis
        multiRenderer.setXAxisMax(12);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.colorPrimary));
        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30});

        for (int i = 0; i < x.length; i++) {
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding tayTraiRenderer and tayPhaiRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(tayTraiRenderer);
        multiRenderer.addSeriesRenderer(tayPhaiRenderer);

        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(Chart.this, dataset, multiRenderer, Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);
    }

    public void openChartOneBar(){

        setChartInfo();
        int[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        float [] income = trungBinh;

        XYSeries incomeSeries = new XYSeries("Trai");

        for (int i = 0; i < x.length; i++) {
            incomeSeries.add(i, income[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(incomeSeries);

        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer tayTraiRenderer = new XYSeriesRenderer();
        tayTraiRenderer.setColor(Color.CYAN);
        tayTraiRenderer.setFillPoints(true);
        tayTraiRenderer.setLineWidth(2);
//        tayTraiRenderer.setDisplayChartValues(true);
        tayTraiRenderer.setDisplayChartValuesDistance(10); //setting chart value distance

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Biểu đồ kết quả đo");
        multiRenderer.setXTitle("Các bộ phận");
        multiRenderer.setYTitle("Phần trăm");

        /***
         * Customizing graphs
         */
        //setting text size of the title
        multiRenderer.setChartTitleTextSize(28);
        //setting text size of the axis title
        multiRenderer.setAxisTitleTextSize(24);
        //setting text size of the graph lable
        multiRenderer.setLabelsTextSize(24);
        //setting zoom buttons visiblity
        multiRenderer.setZoomButtonsVisible(false);
        //setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        //setting click false on graph
        multiRenderer.setClickEnabled(false);
        //setting zoom to false on both axis
        multiRenderer.setZoomEnabled(false, false);
        //setting lines to display on y axis
        multiRenderer.setShowGridY(false);
        //setting lines to display on x axis
        multiRenderer.setShowGridX(false);
        //setting legend to fit the screen size
        multiRenderer.setFitLegend(true);
        //setting displaying line on grid
        multiRenderer.setShowGrid(false);
        //setting zoom to false
        multiRenderer.setZoomEnabled(false);
        //setting external zoom functions to false
        multiRenderer.setExternalZoomEnabled(false);
        //setting displaying lines on graph to be formatted(like using graphics)
        multiRenderer.setAntialiasing(true);
        //setting to in scroll to false
        multiRenderer.setInScroll(false);
        //setting to set legend height of the graph
        multiRenderer.setLegendHeight(30);
        //setting x axis label align
        multiRenderer.setXLabelsAlign(Align.CENTER);
        //setting y axis label to align
        multiRenderer.setYLabelsAlign(Align.LEFT);
        //setting text style
        multiRenderer.setTextTypeface("sans_serif", Typeface.NORMAL);
        //setting no of values to display in y axis
        multiRenderer.setYLabels(10);
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(400);
        //setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-0.5);
        //setting max values to be display in x axis
        multiRenderer.setXAxisMax(12);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.colorPrimary));

        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30});

        for (int i = 0; i < x.length; i++) {
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }
        // Adding tayTraiRenderer and tayPhaiRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(tayTraiRenderer);

        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(Chart.this, dataset, multiRenderer, Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);
    }

    public void setChartInfo(){
//        String ten = (String)thongTin.get(0);
        tvHoTen.setText((String)thongTin.get(0));
        String diaChi = (String)thongTin.get(1);
        tvDiaChi.setText(diaChi);
    }
}
