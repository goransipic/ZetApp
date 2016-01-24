package hr.goodapp.zetapp.zetlines.view;

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
import hr.goodapp.zetapp.comon.adapter.DividerItemDecoration;


import hr.goodapp.zetapp.zetlines.Injection;
import hr.goodapp.zetapp.zetlines.adapter.ZetlinesAdapter;
import hr.goodapp.zetapp.zetlines.model.ZetLines;
import hr.goodapp.zetapp.zetlines.prezenter.ZetLinesPrezenter;

/**
 * Created by User on 24.1.2016..
 */
public class ZetLinesFragment
        extends MvpLceFragment<SwipeRefreshLayout,List<ZetLines>,ZetLinesView,ZetLinesPrezenter>
        implements ZetLinesView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView_zetlines)
    RecyclerView recyclerView;

    ZetlinesAdapter mZetlinesAdapter = Injection.provideZetLinesAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.zetlines_list, container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        ButterKnife.bind(this, view);
        // contentView is SwipeRefreshLayout
        contentView.setOnRefreshListener(this);

        // Setup recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mZetlinesAdapter);
        loadData(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public ZetLinesPrezenter createPresenter() {
        return new ZetLinesPrezenter();
    }

    @Override
    public void setData(List<ZetLines> data) {
        mZetlinesAdapter.setZetLines(data);
        mZetlinesAdapter.notifyDataSetChanged();
    }

    @Override public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        contentView.setRefreshing(pullToRefresh);
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
}
