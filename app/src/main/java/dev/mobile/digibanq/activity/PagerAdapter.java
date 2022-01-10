package dev.mobile.digibanq.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import dev.mobile.digibanq.fragments.InboxFragment;
import dev.mobile.digibanq.fragments.StoreFragment;
import dev.mobile.digibanq.fragments.PublictimelineFragment;
import dev.mobile.digibanq.fragments.MoneyFragment;
import dev.mobile.digibanq.fragments.AlertsFragment;

/**
 * Created by banktech on 7/20/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PublictimelineFragment tab1 = new PublictimelineFragment();
                return tab1;
            case 1:
                AlertsFragment tab2 = new AlertsFragment();
                return tab2;
            case 2:
                MoneyFragment tab3 = new MoneyFragment();
                return tab3;
            case 3:
                StoreFragment tab4 = new StoreFragment();
                return tab4;
            case 4:
                InboxFragment tab5 = new InboxFragment();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
