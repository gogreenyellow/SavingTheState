package com.gogreenyellow.savingthestate.dynamicallyreplacedfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gogreenyellow.savingthestate.R;

/**
 * Created by wkjan_000 on 05.02.2018.
 */

public class DynamicallyReplacedFragmentsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamically_added_fragments);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.adaf_fragment_container,
                            new ImageFragment())
                    .commit();
        }

        initNavigationListener();
        setSupportActionBar((Toolbar) findViewById(R.id.adaf_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.dynamically_added_fragments_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void initNavigationListener() {
        BottomNavigationView bottomNav = findViewById(R.id.adaf_bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.dafm_fragment_one:
                                fragment = new ImageFragment();
                                break;
                            case R.id.dafm_fragment_two:
                                fragment = new SvgFragment();
                                break;
                            case R.id.dafm_fragment_three:
                                fragment = new XmlFragment();
                                break;
                            default:
                                throw new UnsupportedOperationException("Navigation option not supported");
                        }

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.adaf_fragment_container, fragment)
                                .commit();

                        return true;
                    }
                });
    }
}
