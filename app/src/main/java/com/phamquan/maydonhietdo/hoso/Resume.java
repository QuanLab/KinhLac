package com.phamquan.maydonhietdo.hoso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.phamquan.maydonhietdo.R;

import java.util.ArrayList;

public class Resume extends AppCompatActivity {

    private ListView lvLanKham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvLanKham = (ListView) findViewById(R.id.listViewdLanKham);
        ArrayList<String> arrLanKham = new ArrayList<>();

        arrLanKham.add("Lần khám số 1");
        arrLanKham.add("Lần khám số 2");
        arrLanKham.add("Lần khám số 2");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanKham );
        lvLanKham.setAdapter(adapter);
    }
}
