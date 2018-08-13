package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PaidFragment extends Fragment {
    public PaidFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_fragment_paid, container, false);

        return root;
    }
}
