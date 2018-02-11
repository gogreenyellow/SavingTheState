package com.gogreenyellow.savingthestate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.gogreenyellow.savingthestate.autosaving.AutosavingScrollPositionActivity;
import com.gogreenyellow.savingthestate.dynamicallyreplacedfragments.DynamicallyReplacedFragmentsActivity;
import com.gogreenyellow.savingthestate.fragmentsinviewpager.FragmentsInViewPagerActivity;
import com.gogreenyellow.savingthestate.recycler.FetchListItemsTask;
import com.gogreenyellow.savingthestate.recycler.RecyclerViewActivity;
import com.gogreenyellow.savingthestate.transientstate.TransientStateActivity;

/**
 * Created by wkjan on 04.02.2018.
 */

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.am_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.am_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.am_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class type;
                switch (item.getItemId()) {
                    case R.id.mn_autosaving: {
                        type = AutosavingScrollPositionActivity.class;
                        break;
                    }
                    case R.id.mn_transient_state: {
                        type = TransientStateActivity.class;
                        break;
                    }
                    case R.id.mn_dynamically_added_fragments: {
                        type = DynamicallyReplacedFragmentsActivity.class;
                        break;
                    }
                    case R.id.mn_fragments_in_viewpager: {
                        type = FragmentsInViewPagerActivity.class;
                        break;
                    }
                    case R.id.mn_recycler_view: {
                        type = RecyclerViewActivity.class;
                        break;
                    }
                    default:
                        throw new UnsupportedOperationException("Navigation operation not supported");
                }
                Intent intent = new Intent(MainActivity.this, type);
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    public void openArticle(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://gogreenyellow.com/articles/saving-restoring-state"));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }
}
