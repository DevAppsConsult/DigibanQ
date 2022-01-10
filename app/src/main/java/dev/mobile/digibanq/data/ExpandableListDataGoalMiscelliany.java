package dev.mobile.digibanq.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by banktech on 7/29/2016.
 */
public class ExpandableListDataGoalMiscelliany {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> gifts = new ArrayList<String>();
        gifts.add("Cash & Kinds");
        gifts.add("Charitable Giveaways");
        gifts.add("Sponsorship Funds");
        gifts.add("Tithing");
        gifts.add("Alms Giving");
        gifts.add("Hearty Cash Offerings");

        List<String> auto = new ArrayList<String>();
        auto.add("Vehicle loan repayment");
        auto.add("Fuel & Lubricants");
        auto.add("Vehicle insurance");
        auto.add("Vehicle Income Tax");
        auto.add("Public Transport Fares");
        auto.add("Health Insurance");
        auto.add("Vehicle maintenance");

        List<String> food = new ArrayList<String>();
        food.add("Restaurant");
        food.add("Fast food");
        food.add("Drinks & Bars");
        food.add("Personal foodstuff");
        food.add("Beverages");

        List<String> health = new ArrayList<String>();
        health.add("Dental");
        health.add("Eye");
        health.add("Ailments & allergies");
        health.add("Gym");
        health.add("Sports");
        health.add("Health Insurance");
        health.add("Doctor");

        List<String> household = new ArrayList<String>();
        household.add("Furniture & Furnishing");
        household.add("Rent / Mortgage payment");
        household.add("Property Taxes");
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
        PersonalGrooming.add("Hair & Nails");
        PersonalGrooming.add("Clothing");
        PersonalGrooming.add("Body beautification kits");
        PersonalGrooming.add("Personal hygiene kits");
        PersonalGrooming.add("Jewelry");
        PersonalGrooming.add("Spa & Massage");
        PersonalGrooming.add("Laundry");
        PersonalGrooming.add("internet & mobile communication");

        List<String> ent_lei = new ArrayList<String>();
        ent_lei.add("Movies");
        ent_lei.add("Live shows");
        ent_lei.add("Music");
        ent_lei.add("Arts");
        ent_lei.add("Newspapers & Magazines");
        ent_lei.add("food & drinks");
        ent_lei.add("Vacation");
        ent_lei.add("Occassions & Ceremonies");
        ent_lei.add("Other ");

        List<String> income = new ArrayList<String>();
        income.add("Monthly pay");
        income.add("Cash allowances");
        income.add("Reimbursements");
        income.add("Rent income");
        income.add("Cash gifts");
        income.add("Loans received");
        income.add("Interest income");
        income.add("Investments");

        List<String> loans_debts = new ArrayList<String>();
        loans_debts.add("Personal loans");
        loans_debts.add("Mutual debts");
        loans_debts.add("Commercial debts");

        List<String> travel = new ArrayList<String>();
        travel.add("Air expenses");
        travel.add("Road expenses");
        travel.add("Train expenses");
        travel.add("Hotel & lodgements");
        travel.add("Trip errands & chauffeur");

        List<String> bank_chrges = new ArrayList<String>();
        bank_chrges.add("Maintenance fees");
        bank_chrges.add("COTs");
        bank_chrges.add("ATMs");
        bank_chrges.add("Transfers");
        bank_chrges.add("Remittances");

        List<String> investments = new ArrayList<String>();
        investments.add("Deposits");
        investments.add("Withdrawal fees");
        investments.add("Investment trade fees");

        List<String> education = new ArrayList<String>();
        education.add("Tuition fees");
        education.add("Books & supplies");
        education.add("Educational loans");
        education.add("Other");

        expandableListDetail.put("INVESTMENTS", investments);
        expandableListDetail.put("BANK CHARGES", bank_chrges);
        expandableListDetail.put("TRAVEL", travel);
        expandableListDetail.put("LOANS & DEBTS", loans_debts);
        expandableListDetail.put("INCOME", income);
        expandableListDetail.put("ENTERTAINMENT & LEISURE", ent_lei);
        expandableListDetail.put("EDUCATION", education);
        expandableListDetail.put("GIFTS & DONATIONS", gifts);
        expandableListDetail.put("AUTO & TRANSPORT", auto);
        expandableListDetail.put("FOOD & DINNING", food);
        expandableListDetail.put("HEALTH AND FITNESS", health);
        expandableListDetail.put("HOUSEHOLD", household);
        expandableListDetail.put("PERSONAL GROOMING", PersonalGrooming);
        return expandableListDetail;
    }
}