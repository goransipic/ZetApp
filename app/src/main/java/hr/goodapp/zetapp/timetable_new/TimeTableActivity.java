package hr.goodapp.zetapp.timetable_new;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.comon.adapter.DividerItemDecoration;
import hr.goodapp.zetapp.timetable_new.adapter.ListAdapter;
import hr.goodapp.zetapp.timetable_new.loader.TimeTableLoader;
import hr.goodapp.zetapp.timetable_new.model.TimeTableModel;
import hr.goodapp.zetapp.timetable_new.provider.SuggestionProvider;


public class TimeTableActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<TimeTableModel>>, NavigationView.OnNavigationItemSelectedListener {

    public static final String ID = "Id";
    public static final int DEFAULT_NUMBER = 109;
    private TextInputEditText mTextInputEditText;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content_fragment_timetable);

        Bundle bundle = new Bundle();
        bundle.putInt(ID, DEFAULT_NUMBER);

        getSupportLoaderManager().initLoader(0, bundle, this);

        initToolbar();

        initViews();

        /*mTextInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    v.clearFocus();

                    Bundle bundle = new Bundle();
                    String s = mTextInputEditText.getText().toString();

                    Integer integer = Integer.parseInt(s);

                    bundle.putInt(ID, integer);

                    getSupportLoaderManager().restartLoader(0, bundle, TimeTableActivity.this);

                    handled = false;
                }
                return handled;
            }
        });

        mTextInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] COUNTRIES = new String[]{"105", "103", "107", "109", "104"};

                AlertDialog.Builder builder = new AlertDialog.Builder(TimeTableActivity.this);

                LayoutInflater layoutInflater = (LayoutInflater) (TimeTableActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                View view1 = layoutInflater.inflate(R.layout.time_table_dialog, null);
                AutoCompleteTextView editText = (AutoCompleteTextView) view1.findViewById(R.id.time_table_dialog_editText);

                builder.setView(view1);
                builder.setTitle("Unesi broj linije");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                alertDialog.show();

                editText.setAdapter(new ArrayAdapter<String>(TimeTableActivity.this,
                        android.R.layout.simple_dropdown_item_1line, COUNTRIES));





            }
        });*/


        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
            suggestions.saveRecentQuery(query, null);

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
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
        //mTextInputEditText = (TextInputEditText) findViewById(R.id.timetable_edit_text);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) findViewById(R.id.time_table_search_view);

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
        searchView.setInputType(InputType.TYPE_CLASS_NUMBER);
        searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
