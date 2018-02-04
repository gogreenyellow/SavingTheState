package com.gogreenyellow.savingthestate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by wkjan on 04.02.2018.
 */

public class AutosavingScrollPositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autosaving_scroll_position);

        setSupportActionBar((Toolbar) findViewById(R.id.aasp_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.autosaving_scroll_title);
    }
}
