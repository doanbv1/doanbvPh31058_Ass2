package com.doanbvph31058.doanbvph31058_ass2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;

import java.util.ArrayList;

public class Adapter_Nhan_Vien extends BaseAdapter {

    private QL_Nhan_Vien ql_nhan_vien;

    private ArrayList<model_NhanVien> list;

    private ActivityResultLauncher<Intent> myLaucher;


    public Adapter_Nhan_Vien(QL_Nhan_Vien ql_nhan_vien, ArrayList<model_NhanVien> list, ActivityResultLauncher<Intent> myLaucher) {
        this.ql_nhan_vien = ql_nhan_vien;
        this.list = list;
        this.myLaucher = myLaucher;
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

        //lay layout de set

        LayoutInflater inflater = ql_nhan_vien.getLayoutInflater();

        convertView = inflater.inflate(R.layout.item_nhan_vien,parent,false);

        model_NhanVien model_nhanVien = list.get(position);

        TextView tvId = convertView.findViewById(R.id.tv_maNv_item);
        TextView tvName = convertView.findViewById(R.id.tv_hoTen_item);
        TextView tvPhong = convertView.findViewById(R.id.tv_Phong_item);
        ImageView ivEdit = convertView.findViewById(R.id.img_pen);
        ImageView ivDelete = convertView.findViewById(R.id.img_bin);


        tvId.setText("ID NV: "+model_nhanVien.getIdNV());
        tvName.setText("Họ tên: "+model_nhanVien.getNameNV());
        tvPhong.setText(("Phòng ban: "+model_nhanVien.getPhongBan()));

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Intent intent = new Intent(ql_nhan_vien, Sua_NV_Activity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("nhanVienSua", list.get(position));
                bundle.putInt("viTriSua",position);
                intent.putExtras(bundle);
                myLaucher.launch(intent);

            }
        });
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });


        return convertView;
    }
}
