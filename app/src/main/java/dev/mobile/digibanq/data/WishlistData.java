package dev.mobile.digibanq.data;

import java.util.ArrayList;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 10/9/2016.
 */

public class WishlistData {

    private static final int DATASET_COUNT = 6;

    public static ArrayList<WishlistInfo> getData(){

        ArrayList<WishlistInfo> data = new ArrayList<>();
        String[] mDataset = {"John Kwakye"};

        mDataset = new String[DATASET_COUNT];

        for (int i = 0; i < DATASET_COUNT; i++) {
            WishlistInfo current = new WishlistInfo();
            current.title = mDataset[i];

        }

        return data;
    }
}
