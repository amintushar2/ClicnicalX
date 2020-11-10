package com.raslab.clicnicalx.pojos;




    public class DoctorListDataSet {
        String docName;
        String docTitle;
        String hospitalName;
        int docPicId;

        String docHours;
        public DoctorListDataSet( int docPicId,String docName, String docTitle, String hospitalName, String docHours) {
            this.docPicId = docPicId;
            this.docName = docName;
            this.docTitle = docTitle;
            this.hospitalName = hospitalName;
            this.docHours = docHours;
        }

        public DoctorListDataSet() {
        }

        public String getDocName() {
            return docName;
        }

        public void setDocName(String docName) {
            this.docName = docName;
        }

        public String getDocTitle() {
            return docTitle;
        }


        public void setDocTitle(String docTitle) {
            this.docTitle = docTitle;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public int getDocPicId() {
            return docPicId;
        }

        public void setDocPicId(int docPicId) {
            this.docPicId = docPicId;
        }


        public String getDocHours() {
            return docHours;
        }

        public void setDocHours(String docHours) {
            this.docHours = docHours;
        }
}
