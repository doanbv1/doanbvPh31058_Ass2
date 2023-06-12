package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Sua_NV_Activity extends AppCompatActivity {
        private ArrayList<model_PhongBan> arr;
       private String tenPhongBan = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_nv);

        EditText edtMa= findViewById(R.id.edt_maNV);
        EditText edtName= findViewById(R.id.edt_tenNhanVien);
        Spinner spPB = findViewById(R.id.sp_PhongBan);
        Button btnSua = findViewById(R.id.btn_sua_NV);
        Button btntrove = findViewById(R.id.btn_TroVe);


        //set adapter cho spiner
          arr = new QL_PhongBan().getDSPB();

        Spiner_PhongBan_adapter spiner_phongBan_adapter = new Spiner_PhongBan_adapter(Sua_NV_Activity.this,arr);
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


        //Nhan du lieu
         Intent intent = getIntent();
         Bundle bundle = intent.getExtras();

         model_NhanVien nhanVien =(model_NhanVien)bundle.getSerializable("nhanVienSua");
         int viTriSua = bundle.getInt("viTriSua");

         edtMa.setText(nhanVien.getIdNV());
         edtName.setText(nhanVien.getNameNV());
         int viTri = -1;
         for (int i = 0; i < arr.size(); i++){
                if (arr.get(i).getName().equals(nhanVien.getPhongBan())){
                    viTri = i ;
                    break;
                }
         }
            spPB.setSelection(viTri);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMa.getText().toString();
                String name = edtName.getText().toString();

                model_NhanVien nhanVienSua = new model_NhanVien(maNV,name,tenPhongBan);

                Intent intentSua = new Intent();
                Bundle bundleSua = new Bundle();

                bundleSua.putSerializable("nhanVienSua", nhanVienSua);
                bundle.putInt("viTriSua", viTriSua);
                intentSua.putExtras(bundleSua);
                setResult( 2,intentSua);
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