package com.gogreenyellow.savingthestate.fragmentsinviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogreenyellow.savingthestate.R;

/**
 * Sample Fragment showing a croissant image.
 *
 * @author paulina_glab
 */
public class CroissantFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_croissant, container, false);
    }
}
