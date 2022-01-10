package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 7/28/2016.
 */
public class DigiPlanner extends AppCompatActivity{
    private Toolbar toolbar;

    Button btn_car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.digi_planner_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_car = (Button)findViewById(R.id.save_for_car);

        btn_car.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(DigiPlanner.this, GoalCreation.class);
                DigiPlanner.this.startActivity(reg);
            }


        });


    }



}
