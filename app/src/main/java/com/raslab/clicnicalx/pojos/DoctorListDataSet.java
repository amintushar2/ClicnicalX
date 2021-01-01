package com.raslab.clicnicalx.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorListDataSet {
        @SerializedName("Id")
        @Expose
        private Integer id;
        @SerializedName("HospitalId")
        @Expose
        private Integer hospitalId;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Designation")
        @Expose
        private String designation;
        @SerializedName("Speciality")
        @Expose
        private Integer speciality;
        @SerializedName("Mobile")
        @Expose
        private String mobile;
        @SerializedName("HospitalName")
        @Expose
        private String hospitalName;
        @SerializedName("SecialityName")
        @Expose
        private String secialityName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getHospitalId() {
            return hospitalId;
        }

        public void setHospitalId(Integer hospitalId) {
            this.hospitalId = hospitalId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public Integer getSpeciality() {
            return speciality;
        }

        public void setSpeciality(Integer speciality) {
            this.speciality = speciality;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getSecialityName() {
            return secialityName;
        }

        public void setSecialityName(String secialityName) {
            this.secialityName = secialityName;
        }
}
