package hr.goodapp.zetapp.timetable.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hr.goodapp.zetapp.zetlines.nestedfragments.DayLinesFragment;

/**
 * Created by User on 20.1.2016..
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;
    String[] stringArray = {"DNEVNI AUTOBUS", "NOĆNI AUTOBUS"};
    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // ZetLinesFragment # 0 - This will show FirstFragment
                return new DayLinesFragment();
            case 1: // ZetLinesFragment # 0 - This will show FirstFragment different title
                return new DayLinesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return stringArray[position];
    }
}
