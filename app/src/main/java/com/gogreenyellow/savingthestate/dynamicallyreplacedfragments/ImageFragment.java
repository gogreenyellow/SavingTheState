package com.gogreenyellow.savingthestate.dynamicallyreplacedfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogreenyellow.savingthestate.R;

/**
 * Created by Paulina on 07.02.2018.
 */

public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dynamically_added_image, container, false);

        return root;
    }
}
