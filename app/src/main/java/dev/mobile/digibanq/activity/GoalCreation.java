package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 7/25/2016.
 */
public class GoalCreation extends AppCompatActivity{
    private Toolbar toolbar;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.goal_creation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_continue = (Button)findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent cont = new Intent(GoalCreation.this, Budget.class);
                GoalCreation.this.startActivity(cont);
            }


        });


    }
}

