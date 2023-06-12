package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Trang_chu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        TextView tv_phongBan =findViewById(R.id.tv_phongBan);
        TextView tv_nhaVien = findViewById(R.id.tv_nhanVien);
        TextView tv_out = findViewById(R.id.tv_out);


        tv_phongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_chu.this,QL_PhongBan.class);
                startActivity(intent);
            }
        });

        tv_nhaVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_chu.this, QL_Nhan_Vien.class);

                startActivity(intent);
            }
        });
        tv_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}