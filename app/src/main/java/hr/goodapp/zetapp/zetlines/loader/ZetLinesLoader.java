package hr.goodapp.zetapp.zetlines.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import hr.goodapp.zetapp.zetlines.model.ZetLines;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by User on 27.2.2016..
 */
public class ZetLinesLoader extends AsyncTaskLoader<String> {

    List<ZetLines> zetLines = ZetLines.createTramList(20);
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
    public String loadInBackground() {

        String result = null;

        try {
            Response response = client.newCall(request).execute();
            result =  response.body().string();
            Document document =  Jsoup.parse(result);
            Elements element =  document.select("div.pageContent");
            Elements element1 =  element.select("strong");

            result = element1.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



    @Override
    protected void onReset() {

    }

}
