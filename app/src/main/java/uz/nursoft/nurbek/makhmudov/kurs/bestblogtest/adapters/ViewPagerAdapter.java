package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Fragment FRAGMENTS[];
    private String TITLES[];

    public ViewPagerAdapter(FragmentManager manager, Fragment fragments[], String titles[]) {
        super(manager);
        this.FRAGMENTS = fragments;
        this.TITLES = titles;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = FRAGMENTS[i];
        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENTS.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String TITLE = TITLES[position];
        return TITLE;
    }

}
