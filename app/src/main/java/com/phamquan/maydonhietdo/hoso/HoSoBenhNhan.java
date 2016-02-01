package com.phamquan.maydonhietdo.hoso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.phamquan.maydonhietdo.R;

import java.util.ArrayList;

public class HoSoBenhNhan extends AppCompatActivity {

    private ListView listViewHoSoBenhNhan;
    ArrayList<String> mangLanKham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_benh_nhan);

        listViewHoSoBenhNhan = (ListView) findViewById(R.id.listViewHoSoBenhNhan);
        mangLanKham = new ArrayList();
    }

}
