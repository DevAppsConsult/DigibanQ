package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.mobile.digibanq.db.ConfirmationCode;
import info.androidhive.digibanq.R;
import io.realm.Realm;

/**
 * Created by banktech on 11/24/2016.
 */

public class Enter_reset_code extends AppCompatActivity {

    Button reset;
    TextView back;
    EditText code;
    String Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.enter_reset_code);

        reset = (Button)findViewById(R.id.reset_code);
        back = (TextView)findViewById(R.id.back);
        code = (EditText)findViewById(R.id.recover_email);



        reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                Realm realm = Realm.getDefaultInstance();
                ConfirmationCode confirmationCode = realm.where(ConfirmationCode.class).findFirst();
                if(code.getText().toString().equals(confirmationCode.getCode()))
                {
                    Intent reg = new Intent(Enter_reset_code.this, Reset_password.class);
                    Enter_reset_code.this.startActivity(reg);
                    finish();
                }
                else
                {
                    Toast.makeText(Enter_reset_code.this,"Sorry Wrong Activation Code",Toast.LENGTH_LONG).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(Enter_reset_code.this, Recover_pass.class);
                Enter_reset_code.this.startActivity(reg);
            }


        });

    }
}
