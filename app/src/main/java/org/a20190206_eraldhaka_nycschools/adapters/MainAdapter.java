package org.a20190206_eraldhaka_nycschools.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.a20190206_eraldhaka_nycschools.R;
import org.a20190206_eraldhaka_nycschools.data.model.NYCHighSchoolsModel;
import org.a20190206_eraldhaka_nycschools.ui.sat_scores.SATScoresActivity;
import org.a20190206_eraldhaka_nycschools.util.ItemClickListener;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.a20190206_eraldhaka_nycschools.util.Constants.DBN_PARAMETER;
import static org.a20190206_eraldhaka_nycschools.util.Constants.SCHOOL_NAME_PARAMETER;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<NYCHighSchoolsModel> feedItemList;
    private Context mContext;

    public MainAdapter(Context mContext, List<NYCHighSchoolsModel> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.adapter_main, parent, false);
        return new MainAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, final int position) {
        final NYCHighSchoolsModel nycHighSchoolsModel = feedItemList.get(position);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(mContext,SATScoresActivity.class);
                intent.putExtra(DBN_PARAMETER, nycHighSchoolsModel.getDbn());
                intent.putExtra(SCHOOL_NAME_PARAMETER, nycHighSchoolsModel.getSchoolName());
                mContext.startActivity(intent);
            }
        });

        holder.txtTitle.setText(nycHighSchoolsModel.getSchoolName());
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.text_view_title)
        TextView txtTitle;

        private ItemClickListener clickListener;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}




