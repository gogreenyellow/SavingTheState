package com.gogreenyellow.savingthestate.dynamicallyreplacedfragments;

import android.graphics.Color;
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
            String title = getString(R.string.fragment_one_title);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.adaf_fragment_container,
                            DynamicallyCreatedFragment.newInstance(Color.CYAN, title))
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
                        int color;
                        String text;
                        switch (item.getItemId()) {
                            case R.id.dafm_fragment_one:
                                color = Color.CYAN;
                                text = getString(R.string.fragment_one_title);
                                break;
                            case R.id.dafm_fragment_two:
                                color = Color.GRAY;
                                text = getString(R.string.fragment_two_title);
                                break;
                            case R.id.dafm_fragment_three:
                                color = Color.GREEN;
                                text = getString(R.string.fragment_three_title);
                                break;
                            default:
                                throw new UnsupportedOperationException("Navigation option not supported");
                        }

                        Fragment fragment = DynamicallyCreatedFragment.newInstance(color, text);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.adaf_fragment_container, fragment)
                                .commit();
                        return true;
                    }
                });
    }
}
