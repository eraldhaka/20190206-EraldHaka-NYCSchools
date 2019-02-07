package org.a20190206_eraldhaka_nycschools.data.network;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;
import java.util.List;
import rx.Observable;

public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<List<NYCHighSchoolsModel>> getNYCHighSchools() {
        return APIClient.getData().getNYCHighSchools();
    }


    @Override
    public Observable<List<NYCHighSchoolsSATScoresModel>> getNYCHighSchoolsSATScores() {
        return APIClient.getData().getNYCHighSchoolsSATScores();
    }

}
