package org.a20190206_eraldhaka_nycschools.ui.sat_scores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.a20190206_eraldhaka_nycschools.R;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsSATScoresModel;
import java.util.Objects;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.a20190206_eraldhaka_nycschools.util.Constants.DBN_PARAMETER;
import static org.a20190206_eraldhaka_nycschools.util.Constants.SCHOOL_NAME_PARAMETER;
import static org.a20190206_eraldhaka_nycschools.util.Utils.getValue;

public class SATScoresActivity extends AppCompatActivity implements SATScoresMVP.SATScoresView{

    @BindView(R.id.text_view_title)
    TextView txtTitle;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    SATScoresPresenter satScoresPresenter;
    String dbnValue;
    String schoolName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satscores);
        ButterKnife.bind(this);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dbnValue = getValue(this, savedInstanceState,DBN_PARAMETER);
        schoolName = getValue(this, savedInstanceState, SCHOOL_NAME_PARAMETER);
        txtTitle.setText(String.format(getString(R.string.school_no_sat_data_found),schoolName));
        satScoresPresenter = new SATScoresPresenter(this);
        satScoresPresenter.getNYCHighSchoolsSATScores(dbnValue);
    }

    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
        txtTitle.setVisibility(View.INVISIBLE);
    }

    @Override
    public void disableProgressDialog() {
        progressBar.setVisibility(View.GONE);
        txtTitle.setVisibility(View.VISIBLE);
    }
    @Override
    public void displayData(NYCHighSchoolsSATScoresModel nycHighSchoolsSATScoresModels) {
        txtTitle.setText(
                String.format(getString(R.string.school_data),
                        nycHighSchoolsSATScoresModels.getSchoolName(),
                        nycHighSchoolsSATScoresModels.getSatCriticalReadingAvgScore(),
                        nycHighSchoolsSATScoresModels.getSatWritingAvgScore(),
                        nycHighSchoolsSATScoresModels.getSatMathAvgScore()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity
        }

        return super.onOptionsItemSelected(item);
    }
}
