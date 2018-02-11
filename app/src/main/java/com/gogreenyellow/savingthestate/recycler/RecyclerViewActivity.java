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
 * The Activity shows how to save and restore the user input and asynchronously fetched data.
 *
 * @author wjanuszek
 */
public class RecyclerViewActivity extends AppCompatActivity implements FetchListItemsTask.Callback {

    private static final String RECYCLER_ITEMS_KEY = "recyclerItems";
    private static final String SELECTION_KEY = "selection";

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

        /*
            The savedInstanceState is not null only when the Activity is being recreated.

            When the normal workflow of the app is asynchronously loading the data to a collection
            (like in this case), it is crucial to initialize the collection view with data
            before the first layout pass. It will prevent the collection view from losing its
            state (like the scroll position).
         */
        if (savedInstanceState != null) {
            String recyclerItemsString = savedInstanceState.getString(RECYCLER_ITEMS_KEY);
            boolean[] selection = savedInstanceState.getBooleanArray(SELECTION_KEY);

            // The recyclerItemsString may be null when the network request failed before the device
            // rotation
            if (recyclerItemsString != null) {
                try {
                    recyclerItems = new JSONArray(recyclerItemsString);
                    sampleAdapter.swapModel(recyclerItems, selection);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
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
            // Cancelling the AsyncTask guarantees that the callback method won't be
            // called on a destroyed Activity
            fetchListItemsTask.cancel(true);
        }
    }

    /*
        We save the server response to the outState and the user's selection.
        It lets us avoid losing the user's input. Moreover, it helps to prevent performing
        a network request each time the device is rotated.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RECYCLER_ITEMS_KEY, recyclerItems.toString());
        outState.putBooleanArray(SELECTION_KEY, sampleAdapter.getSelection());
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
        sampleAdapter.swapModel(recyclerItems, new boolean[recyclerItems.length()]);
    }

    @Override
    public void failedToGetItems() {
        Toast.makeText(this, R.string.connection_problems, Toast.LENGTH_SHORT).show();
    }
}
