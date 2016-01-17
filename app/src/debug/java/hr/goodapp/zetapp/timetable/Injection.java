package hr.goodapp.zetapp.timetable;

import android.support.v7.widget.RecyclerView;

import hr.goodapp.zetapp.timetable.adapter.TrainAdapter;

/**
 * Created by User on 6.1.2016..
 */
public class Injection {

    public static RecyclerView.Adapter<? extends RecyclerView.ViewHolder> provideTimeTableAdapter() {
        return new TrainAdapter();
    }

}
