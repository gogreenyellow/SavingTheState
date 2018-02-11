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
 * Sample Fragment displaying the vector drawable in the XML format.
 *
 * @author paulina_glab
 */
public class XmlFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamically_added_xml, container, false);
    }
}
