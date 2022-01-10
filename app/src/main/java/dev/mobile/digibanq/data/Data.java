package dev.mobile.digibanq.data;

import java.util.ArrayList;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 9/25/2016.
 */
public class Data {

    public static ArrayList<Information> getData(){

        ArrayList<Information> data = new ArrayList<>();

        int[] images = {
                R.drawable.aka,
                R.drawable.goals,
                R.drawable.smsconfirm,
                R.drawable.samsung_cam,
                R.drawable.sony_cam,
                R.drawable.icon_video,
                R.drawable.icon_photo,
                R.drawable.icon_camera,
                R.drawable.nasco_logo,
                R.drawable.ad,
                R.drawable.borrow,
                R.drawable.pay,

        };

        String[] Categories = {"You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop","You bought Samsung Galaxy S8 Edge plus  from Samsung Ghana shop",};

    for (int i = 0; i < images.length; i++){

        Information current = new Information();
        current.title = Categories[i];
        current.imageid = images[i];

        data.add(current);
    }

    return data;
    }

}
