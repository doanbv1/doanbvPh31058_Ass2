package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Dang_Nhap extends AppCompatActivity {

    String userName, passWord;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        Button btn_DangNhap = findViewById(R.id.btn_login);
        Button btn_DangKy = findViewById(R.id.btn_Register);

        EditText edt_userName = findViewById(R.id.edt_username);
        EditText edt_passWord = findViewById(R.id.edt_password);
        CheckBox chkNhoMK = findViewById(R.id.cb_nhomk);

        SharedPreferences sharedPreferences = getSharedPreferences( "name", MODE_PRIVATE);
        chkNhoMK.setChecked(sharedPreferences.getBoolean("remember",false));

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            userName = bundle.getString("name");
            passWord = bundle.getString("pass");
        }
        edt_userName.setText(userName);
        edt_passWord.setText(passWord);



        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sName = edt_userName.getText().toString();
                String sPass = edt_passWord.getText().toString();

                if (sName.trim().isEmpty()){
                    Toast.makeText(Dang_Nhap.this, "Ban chua nhap userName", Toast.LENGTH_SHORT).show();
                }else if (sPass.trim().isEmpty()) {
                    Toast.makeText(Dang_Nhap.this, "Ban chua nhap passWord", Toast.LENGTH_SHORT).show();
                }else if (!sName.equals(userName) && !sPass.equals(passWord)){
                    Toast.makeText(Dang_Nhap.this, "Ban phai dang ky tai khoan", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Dang_Nhap.this, Trang_chu.class);

                    startActivity(intent);

                }

            }
        });

        btn_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dang_Nhap.this, Dang_Ky.class);
                startActivity(intent);
            }
        });

        chkNhoMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("remember", chkNhoMK.isChecked());
                edit.apply();
            }
        });

    }


}