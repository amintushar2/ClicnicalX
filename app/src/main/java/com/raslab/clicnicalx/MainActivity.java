package com.raslab.clicnicalx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.raslab.clicnicalx.pojos.DoctorListAdapter;
import com.raslab.clicnicalx.pojos.DoctorListDataSet;
import com.raslab.clicnicalx.pojos.DoctorListHorizontalAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    DoctorListHorizontalAdapter doctorListAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, LOCATIONS);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(adapter);



        recyclerView = findViewById(R.id.doctorlistRecylerViewHorzontal);
        doctorListAdapter=new DoctorListHorizontalAdapter( this,new SampleListItem().generatedoctorList());
        LinearLayoutManager layoutManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(doctorListAdapter);
    }


    private static final String[] LOCATIONS = new String[] {
            "Cox's Bazar", "Rangamati", "Sylhet", "Sundarban", "Dhaka"
    };
}