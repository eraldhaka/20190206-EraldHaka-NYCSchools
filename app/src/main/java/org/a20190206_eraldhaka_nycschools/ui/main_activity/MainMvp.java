package org.a20190206_eraldhaka_nycschools.ui.main_activity;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import java.util.List;

public interface MainMvp {
    interface MainView {
        void showProgressDialog();

        void disableProgressDialog();

        void displayData(List<NYCHighSchoolsModel> nycHighSchoolsModels);
    }

    interface MainPresenter {
        void getNYCHighSchools();

        void showProgressDialog();

        void disableProgressDialog();

        void displayData(List<NYCHighSchoolsModel> nycHighSchoolsModels);
    }

    interface MainModel {
        void getNYCHighSchools();
    }
}
