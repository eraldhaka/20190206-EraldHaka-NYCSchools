package org.a20190206_eraldhaka_nycschools.data.network;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;
import java.util.List;
import rx.Observable;

public interface ApiHelper {
    Observable<List<NYCHighSchoolsModel>> getNYCHighSchools();

    Observable<List<NYCHighSchoolsSATScoresModel>> getNYCHighSchoolsSATScores();
}
