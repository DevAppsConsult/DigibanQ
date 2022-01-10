package dev.mobile.digibanq.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by banktech on 1/20/2017.
 */

public class ExpandableListBudgetFragmentData {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> gifts = new ArrayList<String>();
        gifts.add("Total");
        gifts.add("Eye");
        gifts.add("Ailments & allergies");
        gifts.add("Gym");
        gifts.add("Sports");
        gifts.add("Health Insurance");
        gifts.add("Doctor");

        List<String> auto = new ArrayList<String>();
        auto.add("Total");
        auto.add("Eye");
        auto.add("Ailments & allergies");
        auto.add("Gym");
        auto.add("Sports");
        auto.add("Health Insurance");
        auto.add("Doctor");

        List<String> food = new ArrayList<String>();
        food.add("Total");
        food.add("Eye");
        food.add("Ailments & allergies");
        food.add("Gym");
        food.add("Sports");
        food.add("Health Insurance");
        food.add("Doctor");
        List<String> health = new ArrayList<String>();
        health.add("Total");
        health.add("Eye");
        health.add("Ailments & allergies");
        health.add("Gym");
        health.add("Sports");
        health.add("Health Insurance");
        health.add("Doctor");

        List<String> household = new ArrayList<String>();
        household.add("Total");
        household.add("Rent / Mortgage payment");
        household.add("Electronics & Assessories");
        household.add("Phone bill");
        household.add("Gas");
        household.add("Water");
        household.add("Electricity");
        household.add("Internet");
        household.add("Sanitation");
        household.add("Renovations & Repairs");
        household.add("Lawn care");
        household.add("Cable & Wireless connection fees");
        household.add("Home insurance");
        household.add("Household foodstuff");
        household.add("Household beverages");

        List<String> PersonalGrooming = new ArrayList<String>();
        PersonalGrooming.add("Total");
        PersonalGrooming.add("Clothing");
        PersonalGrooming.add("Body beautification kits");
        PersonalGrooming.add("Personal hygiene kits");
        PersonalGrooming.add("Jewelry");
        PersonalGrooming.add("Spa & Massage");
        PersonalGrooming.add("Laundry");
        PersonalGrooming.add("internet & mobile communication");

        expandableListDetail.put("Total", gifts);
        expandableListDetail.put("AUTO & TRANSPORT", auto);
        expandableListDetail.put("FOOD & DINNING", food);
        expandableListDetail.put("HEALTH AND FITNESS", health);
        expandableListDetail.put("HOUSEHOLD", household);
        expandableListDetail.put("PERSONAL GROOMING", PersonalGrooming);
        return expandableListDetail;
    }
}
