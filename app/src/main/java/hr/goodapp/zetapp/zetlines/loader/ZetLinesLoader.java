package hr.goodapp.zetapp.zetlines.loader;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hr.goodapp.zetapp.zetlines.model.ZetTrainsChild;
import hr.goodapp.zetapp.zetlines.model.ZetTrainsParent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by User on 27.2.2016..
 */
public class ZetLinesLoader extends AsyncTaskLoader<List<ZetTrainsParent>> {


    private static final String TAG = ZetLinesLoader.class.getSimpleName();
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("http://www.zet.hr/default.aspx?id=294")
            .build();


    public ZetLinesLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<ZetTrainsParent> loadInBackground() {

        ArrayList<ZetTrainsParent> arrayList = getZetTrains();


        return arrayList;
    }

    @Override
    protected void onReset() {

    }

    @Nullable
    private ArrayList<ZetTrainsParent> getZetTrains() {

        String result;
        ArrayList<ZetTrainsParent> arrayList = null;

        try {

            Response response = client.newCall(request).execute();
            result = response.body().string();
            Document document = Jsoup.parse(result);
            Elements elements = document.select("div.pageContent");


            Elements zetLinesParent = elements.select("strong"); // Elements for parent list
            Elements zetLinesChild = elements.select("ul");

            arrayList = new ArrayList<>();

            for (int i = 0; i < zetLinesParent.size(); i++) {

                ZetTrainsParent zetTrainsParent = new ZetTrainsParent();


                Element zetLineParent = zetLinesParent.get(i);
                Elements zetLinesChilds = zetLinesChild.get(i).select("a");

                zetTrainsParent.setName(zetLineParent.text());

                List<ZetTrainsChild> trainsChildren = new ArrayList<>();

                for (Element linesChild : zetLinesChilds) {


                    trainsChildren.add(new ZetTrainsChild(linesChild.text()));
                }

                zetTrainsParent.setZetTrainsChildren(trainsChildren);

                arrayList.add(zetTrainsParent);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
