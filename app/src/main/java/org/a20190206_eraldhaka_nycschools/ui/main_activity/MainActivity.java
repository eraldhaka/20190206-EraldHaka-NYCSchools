package org.a20190206_eraldhaka_nycschools.ui.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.a20190206_eraldhaka_nycschools.R;
import org.a20190206_eraldhaka_nycschools.adapters.MainAdapter;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import android.widget.ProgressBar;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainMvp.MainView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainPresenter = new MainPresenter(this);
        mainPresenter.getNYCHighSchools();
    }


    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void disableProgressDialog() {
        progressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayData(List<NYCHighSchoolsModel> itemsModels) {
        MainAdapter mainAdapter = new MainAdapter(this, itemsModels);
        mRecyclerView.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
    }
}
