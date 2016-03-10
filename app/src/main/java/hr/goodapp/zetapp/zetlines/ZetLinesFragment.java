package hr.goodapp.zetapp.zetlines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.comon.adapter.DividerItemDecoration;
import hr.goodapp.zetapp.zetlines.Injection;
import hr.goodapp.zetapp.zetlines.adapter.ZetlinesAdapter;
import hr.goodapp.zetapp.zetlines.loader.ZetLinesLoader;
import hr.goodapp.zetapp.zetlines.model.ZetLines;

/**
 * Created by User on 24.1.2016..
 */
public class ZetLinesFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {

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


        // Setup recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mZetlinesAdapter);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getLoaderManager().initLoader(0,null,this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {

        return new ZetLinesLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        //mZetlinesAdapter.setZetLines(data);
        Toast.makeText(getContext(),data,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
