package hr.goodapp.zetapp.timetable_new.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.os.OperationCanceledException;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hr.goodapp.zetapp.timetable_new.model.TimeTableModel;
import hr.goodapp.zetapp.timetable_new.model.TimeTableResultLoader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by User on 21.5.2016..
 */
public class TimeTableLoader extends AsyncTaskLoader<TimeTableResultLoader> {

    public static final int TIME = 0;
    public static final int START = 1;
    public static final int END = 3;
    public static final int ROW_SIZE = 4;
    public static final int FIRST_TABLE = 1;
    public static final int SECOND_TABLE = 2;
    private static final String TAG = TimeTableLoader.class.getSimpleName();
    private OkHttpClient mOkHttpClient = new OkHttpClient();

    private Request mRequest;

    public TimeTableLoader(Context context, int id) {
        super(context);

        mRequest = new Request.Builder()
                .url(String.format("http://www.zet.hr/default.aspx?id=330&route_id=%d", id))
                .build();


    }

    @Override
    protected void onStartLoading() {

        forceLoad();

    }

    @Override
    public TimeTableResultLoader loadInBackground() {

        final TimeTableResultLoader timeTableResultLoader;
        String imageUrl = null;
        String result = null;
        Elements elements = null;

        Elements table1 = null;
        Elements table2 = null;

        List<TimeTableModel> timeTableModels = new ArrayList<>();

        try {
            Response response = mOkHttpClient.newCall(mRequest).execute();
            result = response.body().string();

            Document document = Jsoup.parse(result);
            elements = document.select("div.pageContent");

            // parse image
            Elements imageElement = document.select("div.leftMenu");

            imageUrl = imageElement.select("img").attr("src");

            //
            elements = elements.select("table");
            //elements = elements.select("td");

            for (int i = 0; i < elements.size(); i++) {
                if (i == FIRST_TABLE) {
                    Element element = elements.get(i);
                    table1 = element.select("tr");
                }

                if (i == SECOND_TABLE) {
                    Element element = elements.get(i);
                    table2 = element.select("tr");
                }

            }

            for (Element element : table1) {
                Elements elementsTr = element.select("tr");
                Elements elementsTd = elementsTr.get(0).select("td");

                if (elementsTd.size() == ROW_SIZE) {

                    TimeTableModel timeTableModel = new TimeTableModel(elementsTd.get(TIME).text(),
                            elementsTd.get(START).text(),
                            elementsTd.get(END).text());

                    timeTableModels.add(timeTableModel);
                }


            }


        } catch (IOException e) {

            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }

        }

        timeTableResultLoader = new TimeTableResultLoader();
        timeTableResultLoader.setTimeTableModel(timeTableModels);
        timeTableResultLoader.setImageUrl(imageUrl);
        return timeTableResultLoader;
    }

    @Override
    public void cancelLoadInBackground() {


    }
}
