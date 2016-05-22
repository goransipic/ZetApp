package hr.goodapp.zetapp.timetable_new;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.comon.adapter.DividerItemDecoration;
import hr.goodapp.zetapp.timetable_new.adapter.ListAdapter;
import hr.goodapp.zetapp.timetable_new.loader.TimeTableLoader;
import hr.goodapp.zetapp.timetable_new.model.TimeTableModel;


public class TimeTableActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<TimeTableModel>> {

    public static final String ID = "Id";
    public static final int DEFAULT_NUMBER = 109;
    private TextInputEditText mTextInputEditText;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_timetable);

        Bundle bundle = new Bundle();
        bundle.putInt(ID, DEFAULT_NUMBER);

        getSupportLoaderManager().initLoader(0,bundle, this);

        initToolbar();

        initViews();

        mTextInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    v.clearFocus();

                    Bundle bundle = new Bundle();
                    String s = mTextInputEditText.getText().toString();

                    Integer integer = Integer.parseInt(s);

                    bundle.putInt(ID,integer);

                    getSupportLoaderManager().restartLoader(0, bundle, TimeTableActivity.this);

                    handled = false;
                }
                return handled;
            }
        });

        mTextInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });


    }

    @Override
    public Loader<List<TimeTableModel>> onCreateLoader(int id, Bundle args) {
        return new TimeTableLoader(this, args.getInt(ID));
    }

    @Override
    public void onLoadFinished(Loader<List<TimeTableModel>> loader, List<TimeTableModel> data) {

        mRecyclerView.setAdapter(new ListAdapter(data));
    }

    @Override
    public void onLoaderReset(Loader<List<TimeTableModel>> loader) {

    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_timetable);
        mTextInputEditText = (TextInputEditText) findViewById(R.id.timetable_edit_text);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
