package com.doanbvph31058.doanbvph31058_ass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class QL_PhongBan extends AppCompatActivity {

    private ArrayList<model_PhongBan> arrPB;

    Adapter_PhongBan adapter_phongBan;

    ListView lvPhongBan;
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_phong_ban);

         lvPhongBan = findViewById(R.id.lv_PhongBan);
         SearchView svPhongBan = findViewById(R.id.sv_phongBan);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);



        loadData(getDSPB());


        svPhongBan.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<model_PhongBan> arrFilter = new ArrayList<>();

                for (model_PhongBan model_phongBan : getDSPB()) {
                    if(model_phongBan.getName().toLowerCase().contains(newText.toLowerCase())){
                        arrFilter.add(model_phongBan);
                    }
                }
                loadData(arrFilter);
                return false;
            }
        });
    }
    public void loadData(ArrayList<model_PhongBan> list){
        adapter_phongBan = new Adapter_PhongBan(this,list);
        lvPhongBan.setAdapter(adapter_phongBan);
    }
    public ArrayList<model_PhongBan> getDSPB(){

        arrPB = new ArrayList<>();
        arrPB.add(new model_PhongBan("Nhân sự",R.mipmap.house));
        arrPB.add(new model_PhongBan("Hành chính",R.mipmap.house));
        arrPB.add(new model_PhongBan("Đào tạo",R.mipmap.house));

        return arrPB;
    }
}