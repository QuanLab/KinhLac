package com.phamquan.maydonhietdo.hoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView.*;
import com.phamquan.maydonhietdo.database.BenhNhan;
import com.phamquan.maydonhietdo.database.BenhNhanDataSource;
import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.LanKham;

//Danh sach ho so benh nhan

public class ListResume extends AppCompatActivity {

    private ListView listViewResume;
    private BenhNhanDataSource datasource;
    ArrayList<BenhNhan> mangBenhNhan;
    ArrayList<String> thongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewResume = (ListView) findViewById(R.id.listViewResume);

        datasource = new BenhNhanDataSource(this);
        datasource.open();
        mangBenhNhan = datasource.getAllBenhNhan();

        ListAdapter adapter = new ListAdapter(this, R.layout.activity_dong_benh_nhan_mau, mangBenhNhan );
        listViewResume.setAdapter(adapter);
        listViewResume.setOnItemClickListener(new ListClickHandler());
    }

    public class ListClickHandler implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {

            thongTin = new ArrayList<>();
            BenhNhan benhNhan = mangBenhNhan.get(position);

            Intent intent = new Intent(ListResume.this, HoSoBenhNhan.class);

            intent.putExtra("idBenhNhan" , String.valueOf(position +1));  //index trong SQLite bat dau tu 1
            intent.putExtra("hoTen" , benhNhan.getHoTen());
            intent.putExtra("namSinh" , benhNhan.getNamSinh());
            intent.putExtra("diaChi" , benhNhan.getDiaChi());
            intent.putExtra("soDienThoai" , benhNhan.getSoDienThoai());

            startActivity(intent);
        }
    }
}
