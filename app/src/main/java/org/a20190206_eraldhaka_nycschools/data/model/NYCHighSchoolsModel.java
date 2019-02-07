package org.a20190206_eraldhaka_nycschools.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NYCHighSchoolsModel {
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("school_name")
    @Expose
    private String schoolName;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
