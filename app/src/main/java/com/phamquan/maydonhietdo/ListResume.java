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

public class ListResume extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resume);
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

        listViewResume = (ListView) findViewById(R.id.listViewResume);

        ArrayList<String> arrResume = new ArrayList<>();
        arrResume.add("Pham Van Quan");
        arrResume.add("Vu Thanh Huan");
        arrResume.add("Tram Van Tuan");
        arrResume.add("Hoang Tuan Anh");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrResume );
        listViewResume.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
        Intent intent = new Intent(ListResume.this, Resume.class);
        startActivity(intent);
    };
}
