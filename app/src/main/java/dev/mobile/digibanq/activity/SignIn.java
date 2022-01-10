package dev.mobile.digibanq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 7/7/2016.
 */
public class SignIn extends Activity{

    TextView help, register;
    Button signIn;
    Intent auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.sign_in);
        signIn = (Button)findViewById(R.id.btn_signin);



        findViewById(R.id.btn_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                PrefManager prefManager = new PrefManager(getApplicationContext());

                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);

                startActivity(new Intent(SignIn.this, BusinessActivity.class));
                finish();
            }
        });



    }
}
