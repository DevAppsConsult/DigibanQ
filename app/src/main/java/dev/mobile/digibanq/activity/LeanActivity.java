package dev.mobile.digibanq.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.digibanq.fragments.LeanOne;
import dev.mobile.digibanq.fragments.LeanThree;
import dev.mobile.digibanq.fragments.LeanTwo;
import info.androidhive.digibanq.R;

/**
 * Created by banktech on 10/1/2016.
 */

public class LeanActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
        private MyViewPagerAdapter myViewPagerAdapter;
        private LinearLayout dotsLayout;
        private TextView[] dots;
        private int[] layouts;
        private Button btnSkip, btnNext;
        private PrefManager prefManager;
        private Toolbar toolbar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                // Making notification bar transparent
                if (Build.VERSION.SDK_INT >= 21) {
                        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                }

                setContentView(R.layout.activity_lean);

                toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);


                viewPager = (ViewPager) findViewById(R.id.view_pager);
                setupViewPager(viewPager);
                dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
                btnSkip = (Button) findViewById(R.id.btn_skip);
                btnNext = (Button) findViewById(R.id.btn_next);

                // layouts of all welcome sliders
                // add few more layouts if you want
                layouts = new int[]{
                        R.layout.lean_app_1,
                        R.layout.lean_app_2,
                        R.layout.lean_app_3};

                // adding bottom dots
                addBottomDots(0);

                // making notification bar transparent
                changeStatusBarColor();

                myViewPagerAdapter = new MyViewPagerAdapter();
                viewPager.setAdapter(myViewPagerAdapter);
                viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

                btnSkip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent skip = new Intent(LeanActivity.this, MainActivity.class);
                                LeanActivity.this.startActivity(skip);
                        }
                });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });
        }
        private void addBottomDots(int currentPage) {
                dots = new TextView[layouts.length];

                int[] colorsActive = getResources().getIntArray(R.array.array_lean_dot_active);
                int[] colorsInactive = getResources().getIntArray(R.array.array_lean_dot_inactive);

                dotsLayout.removeAllViews();
                for (int i = 0; i < dots.length; i++) {
                        dots[i] = new TextView(this);
                        dots[i].setText(Html.fromHtml("&#8226;"));
                        dots[i].setTextSize(50);
                        dots[i].setTextColor(colorsInactive[currentPage]);
                        dotsLayout.addView(dots[i]);
                }

                if (dots.length > 0)
                        dots[currentPage].setTextColor(colorsActive[currentPage]);
        }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LeanOne(), "Lean Application");
        adapter.addFragment(new LeanTwo(), "Lean Application");
        adapter.addFragment(new LeanThree(), "Lean Application");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

        private int getItem(int i) {
                return viewPager.getCurrentItem() + i;
        }

        private void launchHomeScreen() {
                prefManager.setFirstTimeLaunch(false);
                startActivity(new Intent(LeanActivity.this, MainActivity.class));
                finish();
        }

        //	viewpager change listener
        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {
                        addBottomDots(position);

                        // changing the next button text 'NEXT' / 'GOT IT'
                        if (position == layouts.length - 1) {
                                // last page. make button text to GOT IT
                                //btnNext.setText(getString(R.string.start));
                                //btnSkip.setVisibility(View.GONE);
                        } else {
                                // still pages are left
                                // btnNext.setText(getString(R.string.next));
                                //btnSkip.setVisibility(View.VISIBLE);
                        }
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {

                }

                @Override
                public void onPageScrollStateChanged(int arg0) {

                }
        };

        /**
         * Making notification bar transparent
         */
        private void changeStatusBarColor() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.TRANSPARENT);
                }
        }

        /**
         * View pager adapter
         */
        public class MyViewPagerAdapter extends android.support.v4.view.PagerAdapter {
                private LayoutInflater layoutInflater;

                public MyViewPagerAdapter() {
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                        View view = layoutInflater.inflate(layouts[position], container, false);
                        container.addView(view);

                        return view;
                }

                @Override
                public int getCount() {
                        return layouts.length;
                }

                @Override
                public boolean isViewFromObject(View view, Object obj) {
                        return view == obj;
                }


                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                        View view = (View) object;
                        container.removeView(view);
                }
        }
}
