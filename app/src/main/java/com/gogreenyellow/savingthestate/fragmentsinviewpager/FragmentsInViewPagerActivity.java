package com.gogreenyellow.savingthestate.fragmentsinviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gogreenyellow.savingthestate.R;

/**
 * The Activity demonstrates how to save the selected page and Fragment on lifecycle events.
 *
 * The most of work is done in SamplePagerAdapter.java
 *
 * @author wjanuszek
 */

public class FragmentsInViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_in_viewpager);

        setSupportActionBar((Toolbar) findViewById(R.id.afiv_toolbar));
        getSupportActionBar().setTitle(R.string.fragments_in_viewpager_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = findViewById(R.id.afiv_view_pager);
        TabLayout tabLayout = findViewById(R.id.afiv_tab_layout);

        viewPager.setAdapter(new SamplePagerAdapter(this, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
