package org.a20190206_eraldhaka_nycschools.ui.sat_scores;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;

public interface SATScoresMVP {

    interface SATScoresView {
        void showProgressDialog();

        void disableProgressDialog();

        void displayData(NYCHighSchoolsSATScoresModel nycHighSchoolsModels);


    }


    interface SATScoresPresenter {
        void getNYCHighSchoolsSATScores(String dbnValue);

        void showProgressDialog();

        void disableProgressDialog();

        void displayData(NYCHighSchoolsSATScoresModel nycHighSchoolsModels);

    }

    interface SATScoresModel {
        void getNYCHighSchoolsSATScores(String dbnValue);
    }
}
