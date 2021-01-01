package com.raslab.clicnicalx.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloodDonorListDataSet {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Address")
    @Expose
    private Integer address;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Age")
    @Expose
    private Integer age;
    @SerializedName("Gender")
    @Expose
    private Integer gender;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("BloodGroup")
    @Expose
    private Integer bloodGroup;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;
    @SerializedName("BloodGroupName")
    @Expose
    private String bloodGroupName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Integer bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBloodGroupName() {
        return bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

}
