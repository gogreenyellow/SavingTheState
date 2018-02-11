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
        int color;
        String text;
        switch (position) {
            case 0:
                color = Color.CYAN;
                text = context.getString(R.string.fragment_croissoint_title);
                break;
            case 1:
                color = Color.GRAY;
                text = context.getString(R.string.fragment_pear_title);
                break;
            case 2:
                color = Color.GREEN;
                text = context.getString(R.string.fragment_lime_title);
                break;
            default:
                throw new UnsupportedOperationException("Navigation option not supported");
        }
        return new SvgFragment();
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
