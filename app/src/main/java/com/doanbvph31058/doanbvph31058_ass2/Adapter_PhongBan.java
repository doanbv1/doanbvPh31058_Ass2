package com.doanbvph31058.doanbvph31058_ass2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_PhongBan extends BaseAdapter {

    QL_PhongBan qlPhongBan;

    ArrayList<model_PhongBan> list;

    public Adapter_PhongBan(QL_PhongBan qlPhongBan, ArrayList<model_PhongBan> list) {
        this.qlPhongBan = qlPhongBan;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Lay layout de set

        LayoutInflater inflater = qlPhongBan.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_phongban, parent, false);

        model_PhongBan model_phongBan = list.get(position);

        ImageView imgPhongBan = convertView.findViewById(R.id.img_model);
        TextView  tvName = convertView.findViewById(R.id.tv_model);

        imgPhongBan.setImageResource(model_phongBan.getImg());
        tvName.setText(model_phongBan.getName());


        return convertView;
    }
}
