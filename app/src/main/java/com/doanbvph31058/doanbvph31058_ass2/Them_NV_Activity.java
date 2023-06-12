package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Them_NV_Activity extends AppCompatActivity {

    String tenPhongBan="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);

        EditText edtMa= findViewById(R.id.edt_maNV);
        EditText edtName= findViewById(R.id.edt_tenNhanVien);
        Spinner spPB = findViewById(R.id.sp_PhongBan);
        Button btnAdd = findViewById(R.id.btn_add_NV);
        Button btntrove = findViewById(R.id.btn_TroVe);

        //set adapter cho spiner
        ArrayList<model_PhongBan> arr = new QL_PhongBan().getDSPB();

        Spiner_PhongBan_adapter spiner_phongBan_adapter = new Spiner_PhongBan_adapter(Them_NV_Activity.this,arr);
        spPB.setAdapter(spiner_phongBan_adapter);

        spPB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(Them_NV_Activity.this, arr.get(position).getName(), Toast.LENGTH_SHORT).show();
                tenPhongBan = arr.get(position).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMa.getText().toString();
                String name = edtName.getText().toString();

                model_NhanVien nhanVienMoi = new model_NhanVien(maNV,name,tenPhongBan);

                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putSerializable("NhanVienMoi",nhanVienMoi);

                intent.putExtras(bundle);

                setResult(1,intent);
                finish();

            }
        });
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}