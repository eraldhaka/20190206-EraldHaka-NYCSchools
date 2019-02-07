package org.a20190206_eraldhaka_nycschools.ui.main_activity;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import org.a20190206_eraldhaka_nycschools.data.network.ApiHelper;
import org.a20190206_eraldhaka_nycschools.data.network.AppApiHelper;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainModel implements MainMvp.MainModel {
    private MainMvp.MainPresenter mainPresenter;
    private ApiHelper apiHelper;

    public MainModel(MainMvp.MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public void getNYCHighSchools() {
        mainPresenter.showProgressDialog();
        apiHelper.getNYCHighSchools()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NYCHighSchoolsModel>>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainPresenter.disableProgressDialog();
                    }

                    @Override
                    public void onNext(List<NYCHighSchoolsModel> nycHighSchoolsModel) {
                        mainPresenter.disableProgressDialog();
                        mainPresenter.displayData(nycHighSchoolsModel);
                    }
                });
    }
}
