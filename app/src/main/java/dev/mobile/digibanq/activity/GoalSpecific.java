package dev.mobile.digibanq.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import dev.mobile.digibanq.adapter.GoalSpecificAdapter;
import dev.mobile.digibanq.adapter.WishListAdapter;
import info.androidhive.digibanq.R;

/**
 * Created by banktech on 10/9/2016.
 */
public class GoalSpecific extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerView;
    GoalSpecificAdapter adapter;


    private static final int DATASET_COUNT = 10;
    protected String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.goal_specific_coupons);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initDataset();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new GoalSpecificAdapter(mDataset);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "SAVE";
        }
    }

}

