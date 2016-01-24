package hr.goodapp.zetapp.zetlines;

import hr.goodapp.zetapp.zetlines.adapter.ZetlinesAdapter;

/**
 * Created by User on 24.1.2016..
 */
public class Injection {

    public static ZetlinesAdapter provideZetLinesAdapter() {
        return new ZetlinesAdapter();
    }

}
