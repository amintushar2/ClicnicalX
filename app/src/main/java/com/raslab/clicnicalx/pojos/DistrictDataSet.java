
package com.raslab.clicnicalx.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictDataSet {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
