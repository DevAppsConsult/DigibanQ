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
public class RegDetailsPersonal extends AppCompatActivity {

    Button skip,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.reg_details_personal);

        skip = (Button)findViewById(R.id.btn_back);
        next = (Button)findViewById(R.id.btn_cont);


        skip.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                Intent signIn = new Intent(RegDetailsPersonal.this, MainActivity.class);
                RegDetailsPersonal.this.startActivity(signIn);

            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(RegDetailsPersonal.this, RegDetailsEmployment.class);
                RegDetailsPersonal.this.startActivity(reg);
            }


        });

    }

}
