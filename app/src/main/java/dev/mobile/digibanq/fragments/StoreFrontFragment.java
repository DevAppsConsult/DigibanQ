package dev.mobile.digibanq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.mobile.digibanq.adapter.MyCustomAdapter;
import info.androidhive.digibanq.R;


public class StoreFrontFragment extends Fragment {
    RecyclerView recyclerView;
    MyCustomAdapter adapter;

    private static final String TAG = "StoreFrontFragment";

    public StoreFrontFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.store_front_fragment, container, false);
        rootView.setTag(TAG);

        return rootView;
    }

}
