package com.phamquan.maydonhietdo.hoso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phamquan.maydonhietdo.database.BenhNhan;
import com.phamquan.maydonhietdo.R;

import java.util.List;


public class ListAdapter extends ArrayAdapter<BenhNhan>{

    public ListAdapter(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<BenhNhan> items){
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

        BenhNhan p = getItem(position);

        if(p!=null){
            TextView tv1 = (TextView) v.findViewById(R.id.textViewHoTen);
            TextView tv2 = (TextView) v.findViewById(R.id.textViewNamSinh);
            tv1.setText(p.getHoTen());
            tv2.setText(String.valueOf(p.getNamSinh()));
        }

        return v;
    }
}
