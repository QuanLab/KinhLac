package com.phamquan.maydonhietdo.hoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView.*;

import com.phamquan.maydonhietdo.BenhNhan;
import com.phamquan.maydonhietdo.R;


public class ListResume extends AppCompatActivity {

    private ListView listViewResume;
    ArrayList<BenhNhan> mangBenhNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewResume = (ListView) findViewById(R.id.listViewResume);

        mangBenhNhan = new ArrayList<>();
        mangBenhNhan.add(new BenhNhan("Pham Van Quan", 1995));
        mangBenhNhan.add(new BenhNhan("Vu Thanh Huan", 1995));
        mangBenhNhan.add(new BenhNhan("Tram Van Tuan", 1995));
        mangBenhNhan.add(new BenhNhan("Hoang Tuan Anh", 1995));

        ListAdapter adapter = new ListAdapter(this, R.layout.activity_dong_benh_nhan, mangBenhNhan );
        listViewResume.setAdapter(adapter);
        listViewResume.setOnItemClickListener(new ListClickHandler());
    }

    public class ListClickHandler implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // TODO Auto-generated method stub
            String hoTen = mangBenhNhan.get(position).getHoTen();
            Intent intent = new Intent(ListResume.this, HoSoBenhNhan.class);
            intent.putExtra("hoTen", hoTen );
            startActivity(intent);
        }
    }
}
