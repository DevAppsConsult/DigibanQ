package dev.mobile.digibanq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import dev.mobile.digibanq.adapter.FeedListAdapter;
import dev.mobile.digibanq.data.FeedItem;
import info.androidhive.digibanq.R;


public class PublictimelineFragment extends Fragment {
    private static final String TAG = PublictimelineFragment.class.getSimpleName();
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;
    private String URL_FEED = "http://api.androidhive.info/feed/feed.json";

    TextView textView;
    public PublictimelineFragment() {
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
        View v = inflater.inflate(R.layout.public_timeline_fragment, container, false);

        return v;
    }



}
