package org.a20190206_eraldhaka_nycschools.ui.main_activity;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import java.util.List;

public class MainPresenter implements MainMvp.MainPresenter {

    private MainMvp.MainView mainView;
    private MainMvp.MainModel mainModel;

    MainPresenter(MainMvp.MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel(this);
    }

    @Override
    public void getNYCHighSchools() {
        mainModel.getNYCHighSchools();
    }

    @Override
    public void showProgressDialog() {
        mainView.showProgressDialog();
    }

    @Override
    public void disableProgressDialog() {
        mainView.disableProgressDialog();
    }

    @Override
    public void displayData(List<NYCHighSchoolsModel> nycHighSchoolsModels) {
        mainView.displayData(nycHighSchoolsModels);
    }
}
