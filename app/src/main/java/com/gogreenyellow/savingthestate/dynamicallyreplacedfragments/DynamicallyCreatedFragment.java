package com.gogreenyellow.savingthestate.dynamicallyreplacedfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gogreenyellow.savingthestate.R;

/**
 * Created by wkjan_000 on 05.02.2018.
 */

public class DynamicallyCreatedFragment extends Fragment {

    private static final String TEXT_KEY = "text";
    private static final String COLOR_KEY = "color";

    public static DynamicallyCreatedFragment newInstance(int color, String text) {
        DynamicallyCreatedFragment dcf = new DynamicallyCreatedFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_KEY, color);
        args.putString(TEXT_KEY, text);
        dcf.setArguments(args);
        return dcf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dynamically_added, container, false);

        TextView fragmentText = root.findViewById(R.id.fda_text_view);
        fragmentText.setText(getArguments().getString(TEXT_KEY));
        fragmentText.setBackgroundColor(getArguments().getInt(COLOR_KEY));

        return root;
    }
}
