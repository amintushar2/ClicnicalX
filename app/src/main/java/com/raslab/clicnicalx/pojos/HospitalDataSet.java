
package com.raslab.clicnicalx.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalDataSet {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Address")
    @Expose
    private Integer address;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;
    @SerializedName("ACCabin")
    @Expose
    private Integer aCCabin;
    @SerializedName("NonACCabin")
    @Expose
    private Integer nonACCabin;
    @SerializedName("MaleWard")
    @Expose
    private Integer maleWard;
    @SerializedName("FemaleWard")
    @Expose
    private Integer femaleWard;
    @SerializedName("ICU")
    @Expose
    private Integer iCU;
    @SerializedName("BACCabin")
    @Expose
    private Integer bACCabin;
    @SerializedName("BNonACCabin")
    @Expose
    private Integer bNonACCabin;
    @SerializedName("BMaleWard")
    @Expose
    private Integer bMaleWard;
    @SerializedName("BFemaleWard")
    @Expose
    private Integer bFemaleWard;
    @SerializedName("BICU")
    @Expose
    private Integer bICU;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Integer getACCabin() {
        return aCCabin;
    }

    public void setACCabin(Integer aCCabin) {
        this.aCCabin = aCCabin;
    }

    public Integer getNonACCabin() {
        return nonACCabin;
    }

    public void setNonACCabin(Integer nonACCabin) {
        this.nonACCabin = nonACCabin;
    }

    public Integer getMaleWard() {
        return maleWard;
    }

    public void setMaleWard(Integer maleWard) {
        this.maleWard = maleWard;
    }

    public Integer getFemaleWard() {
        return femaleWard;
    }

    public void setFemaleWard(Integer femaleWard) {
        this.femaleWard = femaleWard;
    }

    public Integer getICU() {
        return iCU;
    }

    public void setICU(Integer iCU) {
        this.iCU = iCU;
    }

    public Integer getBACCabin() {
        return bACCabin;
    }

    public void setBACCabin(Integer bACCabin) {
        this.bACCabin = bACCabin;
    }

    public Integer getBNonACCabin() {
        return bNonACCabin;
    }

    public void setBNonACCabin(Integer bNonACCabin) {
        this.bNonACCabin = bNonACCabin;
    }

    public Integer getBMaleWard() {
        return bMaleWard;
    }

    public void setBMaleWard(Integer bMaleWard) {
        this.bMaleWard = bMaleWard;
    }

    public Integer getBFemaleWard() {
        return bFemaleWard;
    }

    public void setBFemaleWard(Integer bFemaleWard) {
        this.bFemaleWard = bFemaleWard;
    }

    public Integer getBICU() {
        return bICU;
    }

    public void setBICU(Integer bICU) {
        this.bICU = bICU;
    }

}
