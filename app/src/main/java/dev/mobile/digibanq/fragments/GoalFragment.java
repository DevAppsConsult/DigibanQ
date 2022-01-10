package dev.mobile.digibanq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import info.androidhive.digibanq.R;


public class GoalFragment extends Fragment implements Animation.AnimationListener {

    private static final String TAG = "GoalFragment";
    Boolean setPressed = true;

    LinearLayout hiddenGoals;
    ImageButton btnShowHiddenGoals, btnHideGoals;

    // Animation
    Animation animSideDown, animSlideUp;

    public GoalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.goal_fragment, container, false);
        rootView.setTag(TAG);
        // Inflate the layout for this fragment


        hiddenGoals = (LinearLayout) rootView.findViewById(R.id.hiddenGoals);
        btnShowHiddenGoals = (ImageButton) rootView.findViewById(R.id.BtnShowGoals);

        // load the animation
        animSideDown = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_down);

        // set animation listener
        animSideDown.setAnimationListener(this);

        animSlideUp = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_up);

        // set animation listener
        animSlideUp.setAnimationListener(this);

        btnShowHiddenGoals.setTag(1);
        // button click event
        btnShowHiddenGoals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final int status =(Integer) v.getTag();
                if(setPressed) {
                    // start the animation
                    hiddenGoals.setVisibility(View.VISIBLE);
                    hiddenGoals.startAnimation(animSideDown);
                    v.setTag(0); //pause
                } else {
                    // start the animation
                    hiddenGoals.setVisibility(View.GONE);
                    hiddenGoals.startAnimation(animSlideUp);

                    setPressed = !setPressed;
                }
            }
        });



        return rootView;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for zoom in animation
        if (animation == animSideDown) {
        }


    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
