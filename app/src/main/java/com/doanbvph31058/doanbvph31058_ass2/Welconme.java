package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welconme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welconme);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent  = new Intent(Welconme.this, Dang_Nhap.class);

                startActivity(intent);
            }
        },1000);
    }
}