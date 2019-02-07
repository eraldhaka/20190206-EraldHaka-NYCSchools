package org.a20190206_eraldhaka_nycschools.data.network;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


public interface API {
    @GET("97mf-9njv.json")
    Observable<List<NYCHighSchoolsModel>> getNYCHighSchools();

    @GET("734v-jeq5.json")
    Observable<List<NYCHighSchoolsSATScoresModel>> getNYCHighSchoolsSATScores();
}
