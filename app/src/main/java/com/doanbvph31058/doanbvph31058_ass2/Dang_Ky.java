package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dang_Ky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        EditText edt_userName = findViewById(R.id.edt_username_dk);
        EditText edt_userPass = findViewById(R.id.edt_password_dk);
        EditText edt_Comfirm = findViewById(R.id.edt_retype_password);

        Button btnDangNhap = findViewById(R.id.btn_login_dk);
        Button btnBack = findViewById(R.id.btn_back);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sName = edt_userName.getText().toString();
                String sPass = edt_userPass.getText().toString();
                String sComfirm = edt_Comfirm.getText().toString();


                
                if (sName.trim().isEmpty()){
                    Toast.makeText(Dang_Ky.this, "Ban chua nhap userName", Toast.LENGTH_SHORT).show();
                } else if (sPass.trim().isEmpty()) {
                    Toast.makeText(Dang_Ky.this, "Ban chua nhap passWord", Toast.LENGTH_SHORT).show();
                } else if (sComfirm.trim().isEmpty()) {
                    Toast.makeText(Dang_Ky.this, "Ban chua nhap lai pass", Toast.LENGTH_SHORT).show();
                } else if (!sPass.equals(sComfirm)) {
                    Toast.makeText(Dang_Ky.this, "Ban comfrim pass k dung", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(Dang_Ky.this, Dang_Nhap.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("name",sName);
                    bundle.putString("pass",sPass);

                    intent.putExtras(bundle);
                    startActivity(intent);

                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}