package hr.goodapp.zetapp.zetlines.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

import hr.goodapp.zetapp.zetlines.model.ZetLines;

/**
 * Created by User on 27.2.2016..
 */
public class ZetLinesLoader extends AsyncTaskLoader<List<ZetLines>> {

    List<ZetLines> zetLines = ZetLines.createTramList(20);

    public ZetLinesLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<ZetLines> loadInBackground() {
        return zetLines;
    }
}
