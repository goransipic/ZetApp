package hr.goodapp.zetapp.timetable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.comon.adapter.DividerItemDecoration;
import hr.goodapp.zetapp.timetable.adapter.TrainAdapter;
import hr.goodapp.zetapp.timetable.loader.TimeTableLoader;
import hr.goodapp.zetapp.timetable.model.Train;


/**
 * Created by User on 17.1.2016..
 */
public class TimeTableFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Train>>{

    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    TrainAdapter mTrainAdapter = Injection.provideTimeTableAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.timetable_list, container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        ButterKnife.bind(this, view);
        // contentView is SwipeRefreshLayout

        // Setup recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mTrainAdapter);

    }

    @Override
    public Loader<List<Train>> onCreateLoader(int id, Bundle args) {
        return new TimeTableLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Train>> loader, List<Train> data) {
        mTrainAdapter.setTrains(data);
        mTrainAdapter.notifyDataSetChanged();


    }

    @Override
    public void onLoaderReset(Loader<List<Train>> loader) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getLoaderManager().initLoader(0,null,this);
    }
}
