package com.gogreenyellow.savingthestate.fragmentsinviewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gogreenyellow.savingthestate.R;

/**
 * A sample adapter
 *
 * @author wjanuszek
 */

public class SamplePagerAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENTS_COUNT = 3;

    private Context context;

    public SamplePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        /*
            The Fragments in the ViewPager shouldn't be created outside of the Adapter and passed
            into it. It causes some issues with lifecycle handling.

            The simplest solution is letting the ViewPager manage creation and restoring the correct
            Fragments, like below.
         */
        switch (position) {
            case 0:
                return new CroissantFragment();
            case 1:
                return new PearFragment();
            case 2:
                return new LimeFragment();
            default:
                throw new UnsupportedOperationException("Navigation option not supported");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.fragment_croissoint_title);
            case 1:
                return context.getString(R.string.fragment_pear_title);
            case 2:
                return context.getString(R.string.fragment_lime_title);
        }
        throw new UnsupportedOperationException("Navigation option not supported");
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }
}
