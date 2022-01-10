package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 7/27/2016.
 */
public class RegDetailsEmployment extends AppCompatActivity {

    Button back,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.reg_details_employment);

        back = (Button)findViewById(R.id.btn_back);
        next = (Button)findViewById(R.id.btn_cont);


        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                Intent signIn = new Intent(RegDetailsEmployment.this, RegDetailsPersonal.class);
                RegDetailsEmployment.this.startActivity(signIn);

            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(RegDetailsEmployment.this, RegDocuments.class);
                RegDetailsEmployment.this.startActivity(reg);
            }


        });

    }

}

