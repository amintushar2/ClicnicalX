package com.raslab.clicnicalx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.pojos.AmbulanceListAdapter;
import com.raslab.clicnicalx.pojos.AmbulanceListDataSet;
import com.raslab.clicnicalx.services.ApiClient;
import com.raslab.clicnicalx.services.HospitalServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmbulanceFragment extends Fragment {
    RecyclerView ambulanceRecyclerView;
    AmbulanceListAdapter ambulanceListAdapter;
    List<AmbulanceListDataSet>ambulanceListDataSetList;
    ProgressDialog progressDialog;

    public AmbulanceFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ambulance, container, false);
        ambulanceListDataSetList = new ArrayList<>();
        ambulanceRecyclerView = view.findViewById(R.id.ambulanceListRecyclerView);
        progressDialog =new ProgressDialog(getContext());
        progressDialog.show();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        ambulanceListAdapter =new AmbulanceListAdapter(getContext(),ambulanceListDataSetList);
        ambulanceRecyclerView.setLayoutManager(gridLayoutManager);
        ambulanceRecyclerView.setAdapter(ambulanceListAdapter);

//
//

        HospitalServicesApi hospitalServicesApi = ApiClient.getClient().create(HospitalServicesApi.class);
        Call<List<AmbulanceListDataSet>>call=hospitalServicesApi.getAmbulanceList();
        call.enqueue(new Callback<List<AmbulanceListDataSet>>() {
            @Override
            public void onResponse(Call<List<AmbulanceListDataSet>> call, Response<List<AmbulanceListDataSet>> response) {
                if (response.isSuccessful()) {
                  progressDialog.dismiss();
                    ambulanceListDataSetList = response.body();
                    ambulanceListAdapter.setHospitalListDataSetList(ambulanceListDataSetList);
                } else {
                    Toast.makeText(getContext(), "Eror", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<AmbulanceListDataSet>> call, Throwable t) {

            }
        });

        return view;
    }
}