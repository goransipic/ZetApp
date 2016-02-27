package hr.goodapp.zetapp.timetable.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

import hr.goodapp.zetapp.timetable.model.Train;

/**
 * Created by User on 27.2.2016..
 */
public class TimeTableLoader extends AsyncTaskLoader<List<Train>> {

    List<Train> mTrains = Train.createTramList(20);

    public TimeTableLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Train> loadInBackground() {
        return mTrains;
    }


}
