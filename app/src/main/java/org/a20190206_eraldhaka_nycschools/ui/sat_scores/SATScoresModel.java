package org.a20190206_eraldhaka_nycschools.ui.sat_scores;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;
import org.a20190206_eraldhaka_nycschools.data.network.ApiHelper;
import org.a20190206_eraldhaka_nycschools.data.network.AppApiHelper;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import static org.a20190206_eraldhaka_nycschools.util.Utils.compare;

public class SATScoresModel implements SATScoresMVP.SATScoresModel {



    private SATScoresMVP.SATScoresPresenter satScoresPresenter;
    private ApiHelper apiHelper;

    public SATScoresModel(SATScoresMVP.SATScoresPresenter satScoresPresenter) {
        this.satScoresPresenter = satScoresPresenter;
        this.apiHelper = new AppApiHelper();
    }
    @Override
    public void getNYCHighSchoolsSATScores(final String dbnValue) {

        satScoresPresenter.showProgressDialog();
        apiHelper.getNYCHighSchoolsSATScores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NYCHighSchoolsSATScoresModel>>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        satScoresPresenter.disableProgressDialog();
                    }

                    @Override
                    public void onNext(List<NYCHighSchoolsSATScoresModel> nycHighSchoolsSATScoresModels) {
                        satScoresPresenter.disableProgressDialog();
                        for (int i=0; i<nycHighSchoolsSATScoresModels.size(); i++){
                            if(compare(dbnValue,nycHighSchoolsSATScoresModels.get(i).getDbn())){
                                satScoresPresenter.displayData(nycHighSchoolsSATScoresModels.get(i));
                            }
                        }
                    }
                });
    }
}
