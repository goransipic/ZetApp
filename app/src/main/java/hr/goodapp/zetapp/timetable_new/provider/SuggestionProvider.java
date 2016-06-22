package hr.goodapp.zetapp.timetable_new.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by User on 22.6.2016..
 */
public class SuggestionProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "hr.goodapp.zetapp";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
