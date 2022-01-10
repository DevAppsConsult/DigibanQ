package dev.mobile.digibanq.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.rimoto.intlphoneinput.IntlPhoneInput;

import java.util.List;
import java.util.Random;

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

/**
 * Created by banktech on 7/12/2016.
 */
public class Register extends AppCompatActivity{

    Button back,cont;
    static String code;
    EditText fullname,password,email;
    String fullName,Password,Email,Phone;
    IntlPhoneInput phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.register);
        Random r = new Random();
        int i1 = r.nextInt(999 - 100 + 1) + 100;
        code = ""+i1;

        fullname = (EditText)findViewById(R.id.etFullName);
        password = (EditText)findViewById(R.id.etPassword);
        email = (EditText)findViewById(R.id.etEmail);
        phone = (IntlPhoneInput)findViewById(R.id.etPhoneNumber);

        back = (Button)findViewById(R.id.btn_back);
        cont = (Button)findViewById(R.id.btn_cont);


        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                Intent signIn = new Intent(Register.this, MainActivity.class);
                signIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                signIn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                signIn.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                Register.this.startActivity(signIn);

            }
        });

        cont.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
//                Intent reg = new Intent(Register.this, ConfirmCode.class);
//                Register.this.startActivity(reg);

                register_user();
            }


        });

    }


    void register_user()
    {
        fullName = fullname.getText().toString();
        Password = password.getText().toString();
        Phone = phone.getNumber();
        Email = email.getText().toString();
        if(phone.isValid())
        {
            if(!fullName.equalsIgnoreCase("") &&!Password.equalsIgnoreCase("") &&!Phone.equalsIgnoreCase("") &&!Email.equalsIgnoreCase(""))
            {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiLocation.getApi())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiEndpoints endpoints = retrofit.create(ApiEndpoints.class);

                Call<UserDetails> insert = endpoints.regitser(fullName,"",Phone,Email,Password,code);
                insert.enqueue(new Callback<UserDetails>() {
                    final ProgressDialog pd  = ProgressDialog.show(Register.this,"Please wait ..."," Please Wait Sending Your Code  ...", true);

                    @Override
                    public void onResponse(Response<UserDetails> response, Retrofit retrofit) {
                        pd.hide();
                        UserDetails userDetails = response.body();
                        if(userDetails.getError().equalsIgnoreCase("N/A"))
                        {
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            User user = new User();
                            user.setId(1);
                            user.setServerid(Integer.parseInt(userDetails.getId()));
                            user.setUuid(userDetails.getUnique_id());
                            user.setEmail(user.getEmail());
                            user.setDob(user.getDob());
                            user.setSmscode("0");
                            user.setFullname(fullName);
                            user.setPhone(Phone);
                            user.setEmail(Email);
                            ActivationCode activationCode = new ActivationCode(code);
                            realm.copyToRealmOrUpdate(user);
                            realm.copyToRealmOrUpdate(activationCode);
                            realm.commitTransaction();
                            Intent reg = new Intent(Register.this, ConfirmCode.class);
                            reg.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            reg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            reg.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            Register.this.startActivity(reg);
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
