package dev.mobile.digibanq.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.rimoto.intlphoneinput.IntlPhoneInput;

import dev.mobile.digibanq.api.UserDetails;
import dev.mobile.digibanq.db.ActivationCode;
import dev.mobile.digibanq.db.User;
import dev.mobile.digibanq.endpoints.ApiEndpoints;
import dev.mobile.digibanq.endpoints.ApiLocation;
import info.androidhive.digibanq.R;
import io.realm.Realm;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView recover, signup;
    EditText password;
    String Password,Phone;
    IntlPhoneInput phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        Transparent Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.sign_in);

        login = (Button)findViewById(R.id.btn_signin);
        signup =  (TextView) findViewById(R.id.reg);
        recover = (TextView) findViewById(R.id.rec_password);
        password = (EditText) findViewById(R.id.loginPasswordEt);
        phone = (IntlPhoneInput)findViewById(R.id.loginPhoneEt);



        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                login_user();
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(MainActivity.this, Register.class);
                reg.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                reg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                reg.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                MainActivity.this.startActivity(reg);
            }


        });

        recover.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent rec = new Intent(MainActivity.this, Recover_pass.class);
                rec.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                rec.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                rec.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                MainActivity.this.startActivity(rec);
            }


        });



    }



    void login_user()
    {
        Password = password.getText().toString();
        Phone = phone.getNumber();
        if(phone.isValid())
        {
            if(!Password.equalsIgnoreCase("") &&!Phone.equalsIgnoreCase(""))
            {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiLocation.getApi())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiEndpoints endpoints = retrofit.create(ApiEndpoints.class);

                Call<UserDetails> insert = endpoints.login(Phone,Password);
                insert.enqueue(new Callback<UserDetails>() {
                    final ProgressDialog pd  = ProgressDialog.show(MainActivity.this,"Please wait ..."," Please Wait Verifying Login Details  ...", true);

                    @Override
                    public void onResponse(Response<UserDetails> response, Retrofit retrofit) {
                        pd.hide();
                        UserDetails  userDetails = response.body();
                        if(userDetails.getError().equalsIgnoreCase("N/A"))
                        {
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            User user = new User();
                            user.setId(1);
                            user.setSmscode("0");
                            user.setFullname(userDetails.getFull_name());
                            user.setPhone(Phone);
                            user.setUuid(userDetails.getUnique_id());
                            user.setDob(userDetails.getDob());
                            user.setServerid(Integer.parseInt(userDetails.getId()));
                            user.setEmail(userDetails.getEmail());
                            realm.copyToRealmOrUpdate(user);
                            realm.commitTransaction();
                            Intent reg = new Intent(MainActivity.this, BusinessActivity.class);
                            reg.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            reg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            reg.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            MainActivity.this.startActivity(reg);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),userDetails.getError(),Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                        pd.hide();

                    }
                });


            }
            else
            {
                Toast.makeText(getApplicationContext(),"Sorry All Fields Are Required",Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please Enter A Correct Phone Number",Toast.LENGTH_LONG).show();

        }
    }

}
