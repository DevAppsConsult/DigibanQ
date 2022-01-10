package dev.mobile.digibanq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import dev.mobile.digibanq.db.User;
import info.androidhive.digibanq.R;
import io.realm.Realm;

/**
 * Created by banktech on 7/13/2016.
 */
public class BusinessActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3,fab4,fab5,fab6;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
    final Context context = this;
    private ImageButton button;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    static User userDetails;

    private static final String PREFERENCES_FILE = "mymaterialapp_settings";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private int mCurrentSelectedPosition;
    TextView feeds,wishlist,delivery, name, companyName,recent_activities,promo_coupons,goal_coupons,notes;
    TextView userActivity, userActivityTxt, userActivityMsg,
            suggested_bugdet_txt, userActivityTwo, userActivityMsgTwo,
            header_text_org, userActivityThree, userActivityMsgFour, suggested_bugdet_txt_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_business);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Realm realm = Realm.getDefaultInstance();
        userDetails = realm.where(User.class).findFirst();

        //userActivity = (TextView)findViewById(R.id.user_profile_name);
       //userActivity.setText(Html.fromHtml("<p><b>Anthony Mens</b></p><p>and</p><p><b>2 contacts</b>"));

        //userActivityTxt = (TextView)findViewById(R.id.userActivityText);
        //userActivityTxt.setText(Html.fromHtml("<p>shared a promo from <b>Nasco Ghana's</b> \nstory board.</p>"));

        //userActivityMsg = (TextView)findViewById(R.id.userActivityMsg);
        //userActivityMsg.setText(Html.fromHtml("<p><b>Thanks to Nasco i taught i should share this \nwonderful moment with you.</b></p>"));

        suggested_bugdet_txt = (TextView)findViewById(R.id.suggested_bugdet_txt);
        suggested_bugdet_txt.setText(Html.fromHtml("<p>Spend to save <b>GHS 100</b> towards your goal</p><b>GHS 1,200 before NOV 30</b>"));

        userActivityTwo = (TextView)findViewById(R.id.user_profile_name2);
        userActivityTwo.setText(Html.fromHtml("<p><b>Andrew Martin</b></p><p>- Review</p><p><b>3 stars</b>"));

        userActivityMsgTwo = (TextView)findViewById(R.id.userActivityMsg1);
        userActivityMsgTwo.setText(Html.fromHtml("<p>Its been an amazing experience using this brand of watch, i never regretted the day i bought it</p>"));

        userActivityThree = (TextView)findViewById(R.id.user_profile_name2);
        userActivityThree.setText(Html.fromHtml("<p><b>Andrew Martin</b></p><p>- Review</p><p><b>3 stars</b>"));

        userActivityMsgFour = (TextView)findViewById(R.id.userActivityMsg2);
        userActivityMsgFour.setText(Html.fromHtml("<p>Its been an amazing experience using this brand of watch, i never regretted the day i bought it</p>"));

        header_text_org = (TextView)findViewById(R.id.header_text_org);
        header_text_org.setText(Html.fromHtml("<p><b>Suggested Profiles</b></p><p>- Organisations</p><p>"));

        suggested_bugdet_txt_two = (TextView)findViewById(R.id.suggested_bugdet_txt2);
        suggested_bugdet_txt_two.setText(Html.fromHtml("<p>Take an action to earn some redeemable coins</p>"));


        /*fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab3 = (FloatingActionButton)findViewById(R.id.fab3);
        fab4 = (FloatingActionButton)findViewById(R.id.fab4);
        fab5 = (FloatingActionButton)findViewById(R.id.fab5);
        fab6 = (FloatingActionButton)findViewById(R.id.fab6);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);
        fab6.setOnClickListener(this);*/



        //viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);



        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); */

        //button = (ImageButton)findViewById(R.id.get_now);

        // add button listener
        /*button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.buy_options_custom);
               /* dialog.setTitle("Select Payment Method");

                // set the custom dialog components - text, image and button
               TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.logo);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        }); */



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = LayoutInflater.from(this).inflate(R.layout.drawer_header, null);
        TextView uid = (TextView)header.findViewById(R.id.userUID);
        TextView userFullName =(TextView)header.findViewById(R.id.name);
        TextView userNumber = (TextView)header.findViewById(R.id.number);
        uid.setText(userDetails.getUuid());
        userFullName.setText(userDetails.getFullname());
        userNumber.setText(userDetails.getPhone());
        navigationView.addHeaderView(header);
        name=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navigation_item_1));
        companyName=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navigation_item_2));
        feeds=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navigation_item_4));
        wishlist=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.notes));
        delivery=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navigation_item_7));
        recent_activities=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.recent_activities));
        promo_coupons=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.promo_coupons));
        goal_coupons=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.goal_specific_coupons));
        notes=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.notes));
        initializeCountDrawer();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);

        mUserLearnedDrawer = Boolean.valueOf(readSharedSetting(this, PREF_USER_LEARNED_DRAWER, "false"));

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        setUpNavDrawer();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                mDrawerLayout.closeDrawers();
                switch (id){
                    case R.id.recent_activities:
                        Intent recent_act = new Intent(BusinessActivity.this, Recent_Activities.class);
                        startActivity(recent_act);
                        break;
                    case R.id.promo_coupons:
                        Intent promo_coups = new Intent(BusinessActivity.this, Recent_Activities.class);
                        startActivity(promo_coups);
                        break;
                    case R.id.goal_specific_coupons:
                        Intent goal_specific_coups = new Intent(BusinessActivity.this, GoalSpecific.class);
                        startActivity(goal_specific_coups);
                        break;
                    case R.id.notes:
                        Intent wishlist = new Intent(BusinessActivity.this, WishList.class);
                        startActivity(wishlist);
                        break;
                }
                return false;
            }
        });
        //NavigationView = (NavigationView) findViewById(R.id.nav_view);
        // mContentFrame = (FrameLayout) findViewById(R.id.nav_contentframe);

    }

    public void ButtonBuyNow(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        final Button pay_from_wallet = (Button) alertLayout.findViewById(R.id.pay_from_wallet);
        final Button other_payment = (Button) alertLayout.findViewById(R.id.other_payment);
        final Button gift_code = (Button) alertLayout.findViewById(R.id.gift_code);

        pay_from_wallet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform action on click
                Intent pay = new Intent(BusinessActivity.this, FinancialActivity.class);
                BusinessActivity.this.startActivity(pay);

            }
        });


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Buying options");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void recent_act(){
        // Perform action on click
        Intent recent_act = new Intent(BusinessActivity.this, BusinessActivity.class);
        BusinessActivity.this.startActivity(recent_act);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION, 0);
        Menu menu = mNavigationView.getMenu();
        menu.getItem(mCurrentSelectedPosition).setChecked(true);
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
                Intent money = new Intent(BusinessActivity.this, FinancialActivity.class);
                BusinessActivity.this.startActivity(money);
                return true;
            case R.id.action_store:
                Intent store = new Intent(BusinessActivity.this, StoreActivity.class);
                BusinessActivity.this.startActivity(store);
                return true;
            case R.id.action_inbox:
                Intent msgs = new Intent(BusinessActivity.this, MessagesActivity.class);
                BusinessActivity.this.startActivity(msgs);
                return true;
            case R.id.action_search:
                Intent srch = new Intent(BusinessActivity.this, SearchActivity.class);
                BusinessActivity.this.startActivity(srch);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }


    private void setUpNavDrawer() {
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        if (!mUserLearnedDrawer) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            mUserLearnedDrawer = true;
            saveSharedSetting(this, PREF_USER_LEARNED_DRAWER, "true");
        }

    }

    public static void saveSharedSetting(Context ctx, String settingName, String settingValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }

    public static String readSharedSetting(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPref.getString(settingName, defaultValue);
    }
    private void initializeCountDrawer(){
        //Gravity property aligns the text
        name.setGravity(Gravity.CENTER_VERTICAL);
        name.setTypeface(null, Typeface.BOLD);
        name.setTextColor(getResources().getColor(R.color.timestamp));
        name.setText("92");
        companyName.setGravity(Gravity.CENTER_VERTICAL);
        companyName.setTypeface(null, Typeface.BOLD);
        companyName.setTextColor(getResources().getColor(R.color.timestamp));
        companyName.setText("102");
        feeds.setGravity(Gravity.CENTER_VERTICAL);
        feeds.setTypeface(null, Typeface.BOLD);
        feeds.setTextColor(getResources().getColor(R.color.colorAccent));
        feeds.setText("23");
        wishlist.setGravity(Gravity.CENTER_VERTICAL);
        wishlist.setTypeface(null, Typeface.BOLD);
        wishlist.setTextColor(getResources().getColor(R.color.colorAccent));
        wishlist.setText("44");
        delivery.setGravity(Gravity.CENTER_VERTICAL);
        delivery.setTypeface(null, Typeface.BOLD);
        delivery.setTextColor(getResources().getColor(R.color.colorAccent));
        delivery.setText("1hr 2mins");
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return false;
    }
}
