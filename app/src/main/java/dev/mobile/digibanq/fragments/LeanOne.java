package dev.mobile.digibanq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import info.androidhive.digibanq.R;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by banktech on 10/16/2016.
 */

public class LeanOne extends Fragment {

    Spinner spinner;
    public LeanOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View scrollView = inflater.inflate(R.layout.lean_app_1, container, false);
        scrollView.setTag(TAG);

        spinner = (Spinner)scrollView.findViewById(R.id.spinner_city);
        String[]countries = getResources().getStringArray(R.array.country_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        return scrollView;
    }

}

