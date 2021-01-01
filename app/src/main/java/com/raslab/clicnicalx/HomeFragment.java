package com.raslab.clicnicalx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.pojos.DistrictDataSet;
import com.raslab.clicnicalx.pojos.DoctorListHorizontalAdapter;
import com.raslab.clicnicalx.pojos.DoctorSpecialityDataSet;
import com.raslab.clicnicalx.pojos.HospitalDataSet;
import com.raslab.clicnicalx.pojos.HospitalListAdapter;
import com.raslab.clicnicalx.services.ApiClient;
import com.raslab.clicnicalx.services.HospitalServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    Button btnHome;
    AutoCompleteTextView autoCompleteTextView;
    DoctorListHorizontalAdapter doctorListAdapter;
    List<HospitalDataSet> hospitalDataSets;
    List<DoctorSpecialityDataSet>doctorSpecialityDataSets;
    HospitalListAdapter hospitalListAdapter;
    private RecyclerView recyclerView,hospitalRecyclerView;
    List<DistrictDataSet>districtDataSetList;
    ProgressDialog progressDialog;
    int itemid;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("ContentLoadingProgressBar");
        progressDialog.show();

        districtDataSetList = new ArrayList<>();
        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);

        // SetAdapter Hospital List
        hospitalDataSets = new ArrayList<>();
        hospitalRecyclerView = view.findViewById(R.id.hospitalRecylerView);
        hospitalListAdapter = new HospitalListAdapter(getContext(), hospitalDataSets);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        hospitalRecyclerView.setLayoutManager(gridLayoutManager);
        hospitalRecyclerView.setAdapter(hospitalListAdapter);

        doctorSpecialityDataSets = new ArrayList<>();
        recyclerView = view.findViewById(R.id.doctorlistRecylerViewHorzontal);
        doctorListAdapter = new DoctorListHorizontalAdapter(getContext(), doctorSpecialityDataSets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(doctorListAdapter);


        // Retrofit Call Hospital List.................
        HospitalServicesApi hospitalServicesApi = ApiClient.getClient().create(HospitalServicesApi.class);




            Call<List<HospitalDataSet>> call = hospitalServicesApi.getHospital();
            call.enqueue(new Callback<List<HospitalDataSet>>() {
                @Override
                public void onResponse(Call<List<HospitalDataSet>> call, Response<List<HospitalDataSet>> response) {
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        hospitalDataSets = response.body();
                        hospitalListAdapter.setHospitalListDataSetList(hospitalDataSets);
                    } else {
                        Toast.makeText(getContext(), "Eror", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<HospitalDataSet>> call, Throwable t) {
                    Toast.makeText(getContext(), "network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    Log.d("EROR", "posts isnt loaded from API");
                }
            });




        Call<List<DoctorSpecialityDataSet>> docspcCall = hospitalServicesApi.getDoctorSpecialityList();
        docspcCall.enqueue(new Callback<List<DoctorSpecialityDataSet>>() {
            @Override
            public void onResponse(Call<List<DoctorSpecialityDataSet>> call, Response<List<DoctorSpecialityDataSet>> response) {
                doctorSpecialityDataSets = response.body();
                doctorListAdapter.setDocSpecilityList(doctorSpecialityDataSets);
            }

            @Override
            public void onFailure(Call<List<DoctorSpecialityDataSet>> call, Throwable t) {

                Toast.makeText(getContext(), "network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                Log.d("EROR", "posts isnt loaded from API");
            }
        });


        Call<List<DistrictDataSet>>disCallback= hospitalServicesApi.getDistrict();
        disCallback.enqueue(new Callback<List<DistrictDataSet>>() {
            @Override
            public void onResponse(Call<List<DistrictDataSet>> call, Response<List<DistrictDataSet>> response) {
                districtDataSetList=response.body();
                showDataSpiner();
            }

            @Override
            public void onFailure(Call<List<DistrictDataSet>> call, Throwable t) {

            }
        });


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               itemid = districtDataSetList.get(position).getId();
                Call<List<HospitalDataSet>> callDE = hospitalServicesApi.getbyAdressId(itemid);
                callDE.enqueue(new Callback<List<HospitalDataSet>>() {
                    @Override
                    public void onResponse(Call<List<HospitalDataSet>> call, Response<List<HospitalDataSet>> response) {
                        if (response.isSuccessful()) {
                            hospitalDataSets = response.body();
                            hospitalListAdapter.setHospitalListDataSetList(hospitalDataSets);
                        } else {
                            Toast.makeText(getContext(), "Eror", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<HospitalDataSet>> call, Throwable t) {
                        Toast.makeText(getContext(), "network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                        Log.d("EROR", "posts isnt loaded from API");
                    }
                });
            }
        });

    return  view;
    }

    private void showDataSpiner() {

        String[] LOCATIONS = new String[districtDataSetList.size()];

        for(int i=0; i<districtDataSetList.size(); i++){
            //Storing names to string array
            LOCATIONS[i] = districtDataSetList.get(i).getDistrictName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, LOCATIONS);

        autoCompleteTextView.setAdapter(adapter);
    }


//    private static final String[] LOCATIONS = new String[]{
//            "Cox's Bazar", "Rangamati", "Sylhet", "Sundarban", "Dhaka"
//    }


}