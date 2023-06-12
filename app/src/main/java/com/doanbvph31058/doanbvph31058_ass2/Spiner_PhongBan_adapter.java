package com.doanbvph31058.doanbvph31058_ass2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Spiner_PhongBan_adapter extends BaseAdapter {
    private Context context;

    private ArrayList<model_PhongBan> ListPB;

    public Spiner_PhongBan_adapter(Context context, ArrayList<model_PhongBan> listPB) {
        this.context = context;
        ListPB = listPB;
    }

    @Override
    public int getCount() {
        return ListPB.size();
    }

    @Override
    public Object getItem(int position) {
        return ListPB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater  inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(android.R.layout.simple_dropdown_item_1line,parent,false);

        model_PhongBan model_phongBan = ListPB.get(position);

        TextView tvName = convertView.findViewById(android.R.id.text1);

        tvName.setText(model_phongBan.getName());


        return convertView;
    }
}
