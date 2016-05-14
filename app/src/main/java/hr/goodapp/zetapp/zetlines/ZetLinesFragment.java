package hr.goodapp.zetapp.zetlines;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.timetable.adapter.MyPagerAdapter;

/**
 * Created by User on 24.1.2016..
 */
public class ZetLinesFragment extends Fragment {



    private MyPagerAdapter adapterViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.zetlines_list, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);


        ViewPager vpPager = (ViewPager) view.findViewById(R.id.viewpager);
        adapterViewPager = new MyPagerAdapter(this.getChildFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpPager);




    }




}
