package hr.goodapp.zetapp.timetable.prezenter;

import android.os.AsyncTask;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import hr.goodapp.zetapp.timetable.model.Train;
import hr.goodapp.zetapp.timetable.view.TimeTableView;

/**
 * Created by User on 17.1.2016..
 */
public class TimetablePrezenter extends MvpBasePresenter<TimeTableView> {

    List<Train> mTrains = Train.createTramList(20);

    public void loadTrains(final boolean pullToRefresh) {
        new AsyncTask<Void,Void,Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (isViewAttached()){

                    getView().setData(mTrains);
                    getView().showContent();
                }
            }
        }.execute();


    }


}
