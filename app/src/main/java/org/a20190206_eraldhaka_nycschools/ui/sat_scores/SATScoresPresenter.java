package org.a20190206_eraldhaka_nycschools.ui.sat_scores;

import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;

public class SATScoresPresenter implements SATScoresMVP.SATScoresPresenter {

    private SATScoresMVP.SATScoresView satScoresView;
    private SATScoresMVP.SATScoresModel satScoresModel;

    SATScoresPresenter(SATScoresMVP.SATScoresView satScoresView) {
        this.satScoresView = satScoresView;
        this.satScoresModel = new SATScoresModel(this);
    }

    @Override
    public void getNYCHighSchoolsSATScores(String dbnValue) {
        satScoresModel.getNYCHighSchoolsSATScores(dbnValue);
    }

    @Override
    public void showProgressDialog() {
        satScoresView.showProgressDialog();
    }

    @Override
    public void disableProgressDialog() {
        satScoresView.disableProgressDialog();
    }

    @Override
    public void displayData(NYCHighSchoolsSATScoresModel nycHighSchoolsModels) {
       // if(nycHighSchoolsModels)
        satScoresView.displayData(nycHighSchoolsModels);
    }


}
