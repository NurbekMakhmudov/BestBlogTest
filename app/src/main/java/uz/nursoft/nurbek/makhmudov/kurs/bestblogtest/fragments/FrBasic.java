package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.R;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.adapters.ViewPagerAdapter;

public class FrBasic extends Fragment {

    private TabLayout frBasicTabLayout;
    private ViewPager frBasicViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_basic, container, false);

        findListener(view);
        setupViewPager(frBasicViewPager);
        frBasicTabLayout.setupWithViewPager(frBasicViewPager);

        return view;
    }

    private void findListener(View view) {
        frBasicTabLayout  = (TabLayout) view.findViewById(R.id.frBasicTabLayout);
        frBasicViewPager = (ViewPager) view.findViewById(R.id.frBasicViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        Fragment FRAGMENTS[] = {new FrRecent(), new FrMostLiked()};
        String TITLES[] = {
                getActivity().getResources().getString(R.string.recent),
                getActivity().getResources().getString(R.string.most_liked)
        };

        ViewPagerAdapter viewPagersAdapters =
                new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FRAGMENTS, TITLES);
        viewPager.setAdapter(viewPagersAdapters);
    }

}
