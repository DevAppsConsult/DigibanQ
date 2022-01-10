package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 12/21/2016.
 */

public class Wallet_payment extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet_payment);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_money:
                Intent money = new Intent(Wallet_payment.this, FinancialActivity.class);
                this.startActivity(money);
                return true;
            case R.id.action_store:
                Intent store = new Intent(Wallet_payment.this, StoreActivity.class);
                this.startActivity(store);
                return true;
            case R.id.action_inbox:
                Intent msgs = new Intent(Wallet_payment.this, MessagesActivity.class);
                this.startActivity(msgs);
                return true;
            case R.id.action_search:
                Intent srch = new Intent(Wallet_payment.this, SearchActivity.class);
                this.startActivity(srch);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
