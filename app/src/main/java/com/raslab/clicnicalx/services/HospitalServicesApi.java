package com.raslab.clicnicalx.services;

import com.raslab.clicnicalx.pojos.AmbulanceListDataSet;
import com.raslab.clicnicalx.pojos.BloodDonorListDataSet;
import com.raslab.clicnicalx.pojos.DistrictDataSet;
import com.raslab.clicnicalx.pojos.DoctorListDataSet;
import com.raslab.clicnicalx.pojos.DoctorSpecialityDataSet;
import com.raslab.clicnicalx.pojos.HospitalDataSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HospitalServicesApi {
    @GET("api/Address/Get")
    Call<List<DistrictDataSet>> getDistrict();

    @GET( "api/Hospital/Get")
    Call<List<HospitalDataSet>>getHospital();

    @GET( "api/Hospital/GetByArea/{id}")
    Call<List<HospitalDataSet>>getbyAdressId(@Path("id")int itemid);

    @GET( "api/Hospital/Get/{id}")
    Call<List<HospitalDataSet>>getHospitalDetails(@Query("id")int id);

    @GET( "api/Doctor/GetSpecialities")
    Call<List<DoctorSpecialityDataSet>>getDoctorSpecialityList();


    @GET( "api/Doctor/GetBySpecialist/{id}")
    Call<List<DoctorListDataSet>>getDoctorList(@Path("id") int id );

    @GET( "api/Donner/Get")
    Call<List<BloodDonorListDataSet>>getdonorList();

    @GET( "api/Ambulance/Get/")
    Call<List<AmbulanceListDataSet>>getAmbulanceList();
}
