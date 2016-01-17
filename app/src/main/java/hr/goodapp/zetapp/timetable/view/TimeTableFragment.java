package hr.goodapp.zetapp.timetable.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.timetable.adapter.TrainAdapter;
import hr.goodapp.zetapp.timetable.model.Train;
import hr.goodapp.zetapp.timetable.prezenter.TimetablePrezenter;

/**
 * Created by User on 17.1.2016..
 */
public class TimeTableFragment
    extends MvpLceFragment<SwipeRefreshLayout,List<Train>,TimeTableView,TimetablePrezenter>
    implements TimeTableView, SwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    TrainAdapter mTrainAdapter = new TrainAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timetable_list, container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        ButterKnife.bind(this, view);
        // contentView is SwipeRefreshLayout
        contentView.setOnRefreshListener(this);

        // Setup recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mTrainAdapter);
        loadData(false);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        showLoading(false);
        presenter.loadTrains(pullToRefresh);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public TimetablePrezenter createPresenter() {
        return new TimetablePrezenter();
    }

    @Override
    public void setData(List<Train> data) {
        mTrainAdapter.setTrains(data);
        mTrainAdapter.notifyDataSetChanged();
    }

    @Override public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
    }

    @Override public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        contentView.setRefreshing(pullToRefresh);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

}
