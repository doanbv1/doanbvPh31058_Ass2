package com.doanbvph31058.doanbvph31058_ass2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class QL_Nhan_Vien extends AppCompatActivity {

    ArrayList<model_NhanVien> arrNV = new ArrayList<>();
    Adapter_Nhan_Vien adapter_nhan_vien;

    ListView lv_nhanVien;

    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_nhan_vien);

       btn_add = findViewById(R.id.btn_them_phong_nv_moi);
        lv_nhanVien = findViewById(R.id.lv_nhan_vien);

        SearchView sv_nhanVien = findViewById(R.id.sv_nhanVien);



        arrNV.add(new model_NhanVien("NV001","Nguyễn Văn A","Hành chính"));
        arrNV.add(new model_NhanVien("NV002","Nguyễn Văn C","Hành chính"));
        arrNV.add(new model_NhanVien("NV003","Nguyễn Văn B","Hành chính"));
        arrNV.add(new model_NhanVien("NV004","Nguyễn Văn D","Hành chính"));


        LoadData(arrNV);

        sv_nhanVien.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                
                ArrayList<model_NhanVien>  arrFilter = new ArrayList<>();  

                for (model_NhanVien model_nhanVien : arrNV) {
                    if (model_nhanVien.getNameNV().toLowerCase().contains(newText.toLowerCase())
                          ||   model_nhanVien.getIdNV().toLowerCase().contains(newText.toLowerCase())
                          || model_nhanVien.getPhongBan().toLowerCase().contains(newText.toLowerCase()))

                    {
                        arrFilter.add(model_nhanVien);
                    }

                }
                LoadData(arrFilter);
                return false;
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(QL_Nhan_Vien.this, Them_NV_Activity.class);


                myLaucher.launch(intent);
            }
        });
    }
    public void LoadData(ArrayList<model_NhanVien> list){
        adapter_nhan_vien = new Adapter_Nhan_Vien(this,list,myLaucher);
        lv_nhanVien.setAdapter(adapter_nhan_vien);
    }

//    private void loadData(){
//
//    }

    private ActivityResultLauncher<Intent> myLaucher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //Xu ly du lieu tra ve

                    if(result.getResultCode() == 1){
                        Intent intent =  result.getData();

                        Bundle bundle = intent.getExtras();

                        model_NhanVien nhanVienMoi = (model_NhanVien) bundle.getSerializable("NhanVienMoi");

                        arrNV.add(nhanVienMoi);
                        LoadData(arrNV);

                    }

                    if (result.getResultCode()==2){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();

                        model_NhanVien nhanVienSua = (model_NhanVien) bundle.getSerializable("nhanVienSua");
                        int viTriSua = bundle.getInt("viTriSua");
                        arrNV.set(viTriSua, nhanVienSua);
                        LoadData(arrNV);
                    }
                }
            });
}