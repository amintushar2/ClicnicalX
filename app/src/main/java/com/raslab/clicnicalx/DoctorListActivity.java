package com.raslab.clicnicalx;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.pojos.DoctorListAdapter;
import com.raslab.clicnicalx.pojos.DoctorListDataSet;
import com.raslab.clicnicalx.services.ApiClient;
import com.raslab.clicnicalx.services.HospitalServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListActivity extends AppCompatActivity {
    List<DoctorListDataSet>doctorListDataSets;
    DoctorListAdapter doctorListAdapter;
    private RecyclerView doctorlistRecylerView;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        doctorListDataSets=new ArrayList<>();
        doctorlistRecylerView=findViewById(R.id.doctorlistRecylerView);
        doctorListAdapter = new DoctorListAdapter(this, doctorListDataSets);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        doctorlistRecylerView.setLayoutManager(layoutManager);
        doctorlistRecylerView.setAdapter(doctorListAdapter);

        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        Toast.makeText(this, "ID = "+id, Toast.LENGTH_SHORT).show();




        HospitalServicesApi hospitalServicesApi = ApiClient.getClient().create(HospitalServicesApi.class);
        hospitalServicesApi.getDoctorList(id).enqueue(new Callback<List<DoctorListDataSet>>() {
            @Override
            public void onResponse(Call<List<DoctorListDataSet>> call, Response<List<DoctorListDataSet>> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(DoctorListActivity.this, "Code:" + response.code(), Toast.LENGTH_SHORT).show();
                    doctorListDataSets = response.body();
                    doctorListAdapter.setDoclist(doctorListDataSets);

                } else {
                    Toast.makeText(DoctorListActivity.this, "Eror", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<DoctorListDataSet>> call, Throwable t) {
                Toast.makeText(DoctorListActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                Log.d("EROR", "posts isnt loaded from API");
            }
        });


    }
}