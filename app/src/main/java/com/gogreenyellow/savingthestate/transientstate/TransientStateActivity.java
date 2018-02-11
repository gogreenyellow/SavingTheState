package com.gogreenyellow.savingthestate.transientstate;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gogreenyellow.savingthestate.R;

/**
 * The Activity demonstrates how to save and restore the user input.
 *
 * @author wjanuszek
 */
public class TransientStateActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTES = "minutes";

    private int hour;
    private int minute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transient_state);

        setSupportActionBar((Toolbar) findViewById(R.id.ats_toolbar));
        getSupportActionBar().setTitle(R.string.transient_state_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
            The savedInstanceState is different than null only when Activity is being recreated
            by the framework.

            The values saved in the onSaveInstanceState() are read and stored in class members and
            used to fill the UI.
         */
        if (savedInstanceState != null) {
            hour = savedInstanceState.getInt(KEY_HOUR);
            minute = savedInstanceState.getInt(KEY_MINUTES);
            fillTimeTextView(hour, minute);
        }

        findViewById(R.id.ats_pick_time_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = TimePickerDialogFragment.newInstance(hour, minute, true);
                dialog.show(getSupportFragmentManager(), DialogFragment.class.getSimpleName());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    /*
        The method is called when the Activity is brought to background.

        We use it to save the user input which may be needed when the Activity will be brought
        to foreground once again.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_HOUR, hour);
        outState.putInt(KEY_MINUTES, minute);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        fillTimeTextView(hourOfDay, minute);
        this.hour = hourOfDay;
        this.minute = minute;
    }

    private void fillTimeTextView(int hour, int minute) {
        TextView timeTextView = findViewById(R.id.ats_time_text_view);
        String minuteStr = Integer.toString(minute);
        if (minute < 10) {
            minuteStr = "0" + minuteStr;
        }
        timeTextView.setText(getString(R.string.picked_time, hour, minuteStr));
    }
}
