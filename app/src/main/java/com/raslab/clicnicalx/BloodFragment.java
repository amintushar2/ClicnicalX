package com.raslab.clicnicalx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.pojos.BloodDonorListAdapter;
import com.raslab.clicnicalx.pojos.BloodDonorListDataSet;
import com.raslab.clicnicalx.services.ApiClient;
import com.raslab.clicnicalx.services.HospitalServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BloodFragment extends Fragment {

    RecyclerView bloodDonorReciclerView;
    BloodDonorListAdapter bloodDonorListAdapter;
    List<BloodDonorListDataSet>bloodDonorListDataSetList;
    ProgressDialog progressDialog;


    public BloodFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blood, container, false);

        bloodDonorReciclerView = view.findViewById(R.id.bloodDonorReciclerView);
        bloodDonorListDataSetList = new ArrayList<>();
        bloodDonorListAdapter = new BloodDonorListAdapter(getContext() , bloodDonorListDataSetList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        bloodDonorReciclerView.setLayoutManager(gridLayoutManager);
        bloodDonorReciclerView.setAdapter(bloodDonorListAdapter);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();


        HospitalServicesApi hospitalServicesApi = ApiClient.getClient().create(HospitalServicesApi.class);
        Call<List<BloodDonorListDataSet>>call=hospitalServicesApi.getdonorList();
        call.enqueue(new Callback<List<BloodDonorListDataSet>>() {
            @Override
            public void onResponse(Call<List<BloodDonorListDataSet>> call, Response<List<BloodDonorListDataSet>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Code:" + response.code(), Toast.LENGTH_SHORT).show();
                    bloodDonorListDataSetList = response.body();
                    bloodDonorListAdapter.setHospitalListDataSetList(bloodDonorListDataSetList);
                } else {
                    Toast.makeText(getContext(), "Eror", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BloodDonorListDataSet>> call, Throwable t) {

            }
        });












        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback( getActivity(), callback);

        // The callback can be enabled or disabled here or in handleOnBackPressed()}
        return view;
    }
}