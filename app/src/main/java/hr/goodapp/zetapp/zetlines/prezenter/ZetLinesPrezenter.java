package hr.goodapp.zetapp.zetlines.prezenter;

import android.os.AsyncTask;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import hr.goodapp.zetapp.timetable.model.Train;
import hr.goodapp.zetapp.zetlines.model.ZetLines;
import hr.goodapp.zetapp.zetlines.view.ZetLinesView;

/**
 * Created by User on 24.1.2016..
 */
public class ZetLinesPrezenter extends MvpBasePresenter<ZetLinesView> {

    List<ZetLines> zetLines = ZetLines.createTramList(20);

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

                    getView().setData(zetLines);
                    getView().showContent();
                }
            }
        }.execute();


    }
}
