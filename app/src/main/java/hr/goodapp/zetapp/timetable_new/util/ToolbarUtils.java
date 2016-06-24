package hr.goodapp.zetapp.timetable_new.util;

import android.content.Context;
import android.content.res.TypedArray;

import hr.goodapp.zetapp.R;

/**
 * Created by goransi on 24.6.2016..
 */
public class ToolbarUtils {

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

}
