package dev.mobile.digibanq.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.mobile.digibanq.activity.GoalMisceliany;
import dev.mobile.digibanq.adapter.ExpandableListBudgetFragmentAdapter;
import dev.mobile.digibanq.data.ExpandableListBudgetData;
import info.androidhive.digibanq.R;


public class BudgetFragment extends Fragment {


    ExpandableListView expandableListView;
    android.widget.ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    Button btn_continue;

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;

    public BudgetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.budget_fragment, container, false);

        btn_continue = (Button)rootView.findViewById(R.id.btn_continue);
        expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListBudgetData.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListBudgetFragmentAdapter(getActivity(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent reg = new Intent(getActivity(), GoalMisceliany.class);
                startActivity(reg);
            }


        });
        return rootView;
    }
}


