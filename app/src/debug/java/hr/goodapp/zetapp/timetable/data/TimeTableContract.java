package hr.goodapp.zetapp.timetable.data;

import android.net.Uri;

/**
 * Created by User on 6.1.2016..
 */
public class TimeTableContract {

    public static final String CONTENT_AUTHORITY = "hr.goodapp.zetapp";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_LOCATION = "location";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATION).build();

}
