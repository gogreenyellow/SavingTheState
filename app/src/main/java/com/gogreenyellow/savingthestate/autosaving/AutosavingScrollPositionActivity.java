package com.gogreenyellow.savingthestate.autosaving;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gogreenyellow.savingthestate.R;

/**
 * The Activity demonstrates how to automatically prevent losing the simple state of the
 * Views on lifecycle changes.
 *
 * The crucial part can be found in the activity_autosaving_scroll_position.xml file.
 *
 * @author wjanuszek
 */
public class AutosavingScrollPositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autosaving_scroll_position);

        setSupportActionBar((Toolbar) findViewById(R.id.aasp_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.auto_saving_scroll_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
