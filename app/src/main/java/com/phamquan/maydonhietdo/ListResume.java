package com.phamquan.maydonhietdo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListResume extends AppCompatActivity {

    private ListView listViewResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewResume = (ListView) findViewById(R.id.listViewResume);

        ArrayList<BenhNhan> mangBenhNhan = new ArrayList<>();
        mangBenhNhan.add(new BenhNhan("Pham Van Quan", 1995));
        mangBenhNhan.add(new BenhNhan("Vu Thanh Huan", 1995));
        mangBenhNhan.add(new BenhNhan("Tram Van Tuan", 1995));
        mangBenhNhan.add(new BenhNhan("Hoang Tuan Anh", 1995));

        ListAdapter adapter = new ListAdapter(this, R.layout.activity_dong_benh_nhan, mangBenhNhan );
        listViewResume.setAdapter(adapter);
    }
}
