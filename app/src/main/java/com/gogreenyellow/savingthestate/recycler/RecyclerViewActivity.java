package com.gogreenyellow.savingthestate.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.gogreenyellow.savingthestate.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by wkjan_000 on 07.02.2018.
 */

public class RecyclerViewActivity extends AppCompatActivity implements FetchListItemsTask.Callback {

    private static final String RECYCLER_ITEMS_KEY = "recyclerItems";

    private SampleAdapter sampleAdapter;
    private FetchListItemsTask fetchListItemsTask;
    private JSONArray recyclerItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        setSupportActionBar((Toolbar) findViewById(R.id.arv_toolbar));
        getSupportActionBar().setTitle(R.string.recycler_view_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.arv_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sampleAdapter = new SampleAdapter(this);
        recyclerView.setAdapter(sampleAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (recyclerItems == null) {
            fetchListItemsTask = new FetchListItemsTask(this);
            fetchListItemsTask.execute();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (fetchListItemsTask != null) {
            fetchListItemsTask.cancel(true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RECYCLER_ITEMS_KEY, recyclerItems.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String recyclerItemsString = savedInstanceState.getString(RECYCLER_ITEMS_KEY);
        if (recyclerItemsString != null) {
            try {
                recyclerItems = new JSONArray(recyclerItemsString);
                sampleAdapter.swapModel(recyclerItems);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void gotItems(JSONArray items) {
        this.recyclerItems = items;
        sampleAdapter.swapModel(recyclerItems);
    }

    @Override
    public void failedToGetItems() {
        //TODO: an elegant empty state
        Toast.makeText(this, R.string.conntection_problems, Toast.LENGTH_SHORT).show();
    }
}
