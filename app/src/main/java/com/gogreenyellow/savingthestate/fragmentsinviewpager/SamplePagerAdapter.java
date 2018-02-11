package com.gogreenyellow.savingthestate.fragmentsinviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gogreenyellow.savingthestate.R;
import com.gogreenyellow.savingthestate.dynamicallyreplacedfragments.SvgFragment;

/**
 * Created by wkjan_000 on 06.02.2018.
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
        switch (position) {
            case 0:
                return new CroissointFragmnet();
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
