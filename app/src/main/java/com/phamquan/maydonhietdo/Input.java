package com.phamquan.maydonhietdo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Input extends AppCompatActivity {

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnKetQuaBang = (Button) findViewById(R.id.btnKetQuaBang);
        Button btnChart = (Button) findViewById(R.id.btnXemBieuDo);
        btnKetQuaBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTable();
            }
        });

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChart();
            }
        });
    }

    public void openTable() {
        Intent intent = new Intent(this, Table.class);
        startActivity(intent);
    }

    public void openChart(){
        Intent intent = new Intent(Input.this, Chart.class);
        startActivity(intent);
    }
}
