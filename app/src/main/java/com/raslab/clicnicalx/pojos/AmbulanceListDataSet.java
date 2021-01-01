package com.raslab.clicnicalx.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AmbulanceListDataSet{


    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Address")
    @Expose
    private Integer address;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;
    @SerializedName("DriverName")
    @Expose
    private String driverName;
    @SerializedName("AmbuNo")
    @Expose
    private String ambuNo;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Mobile")
    @Expose
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAmbuNo() {
        return ambuNo;
    }

    public void setAmbuNo(String ambuNo) {
        this.ambuNo = ambuNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
