package com.gogreenyellow.savingthestate.transientstate;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

/**
 * Created by wkjan on 04.02.2018.
 */

public class TimePickerDialogFragment extends DialogFragment {

    private static final String ARG_HOUR = "hour";
    private static final String ARG_MINUTE = "minute";
    private static final String ARG_FORMAT = "format";

    private TimePickerDialog.OnTimeSetListener listener;
    private int hourOfDay;
    private int minute;
    private boolean is24Format;

    public static TimePickerDialogFragment newInstance(int hourOfDay, int minute, boolean is24Format) {
        Bundle args = new Bundle();
        args.putInt(ARG_HOUR, hourOfDay);
        args.putInt(ARG_MINUTE, minute);
        args.putBoolean(ARG_FORMAT, is24Format);
        TimePickerDialogFragment fragment = new TimePickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (TimePickerDialog.OnTimeSetListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hourOfDay = getArguments().getInt(ARG_HOUR);
        minute = getArguments().getInt(ARG_MINUTE);
        is24Format = getArguments().getBoolean(ARG_FORMAT);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getContext(), listener, hourOfDay, minute, is24Format);
    }
}
