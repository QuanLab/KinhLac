package com.phamquan.maydonhietdo.hoso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phamquan.maydonhietdo.R;
import com.phamquan.maydonhietdo.database.LanKham;

import java.util.List;


public class ListAdapterLanKham extends ArrayAdapter<LanKham> {

    public ListAdapterLanKham(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public ListAdapterLanKham(Context context, int resource, List<LanKham> items){
        super(context, resource, items );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v= vi.inflate(R.layout.activity_dong_benh_nhan_mau, null);
        }

        LanKham lanKham = getItem(position);

        if(lanKham!=null){
            TextView tv1 = (TextView) v.findViewById(R.id.tv_trieu_chung1);
            TextView tv2 = (TextView) v.findViewById(R.id.tv_ngay_do);
            tv1.setText(lanKham.getTrieuChung());
            tv2.setText(String.valueOf(lanKham.getNgayDo()));
        }
        return v;
    }
}
