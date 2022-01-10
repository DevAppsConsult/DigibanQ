package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args)
    {
        Schema schema = new Schema(1, "dev.mobile.digibanq.db");
        schema.enableKeepSectionsByDefault();
        addTables(schema);

        try
        {
            new DaoGenerator().generateAll(schema,PROJECT_DIR+"/app/src/main/java");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void addTables(final Schema schema)
    {
        addUser(schema);
        employmentDetails(schema);
        customGoals(schema);
        defaultGoals(schema);
        userGoals(schema);
        budgetCategories(schema);
        budgetContent(schema);
        userGoals(schema);
    }

    private static Entity addUser(final Schema schema)
    {
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey().autoincrement();
        user.addIntProperty("serverid");
        user.addStringProperty("fullname").notNull();
        user.addStringProperty("phone").notNull();
        user.addStringProperty("email").notNull();
        user.addStringProperty("dob").notNull();
        user.addStringProperty("smscode").notNull();
        user.addStringProperty("address");
        user.addBooleanProperty("pendingsync");
        user.addStringProperty("lastsync");
        user.addDoubleProperty("wallet");

        return user;
    }


    private static Entity employmentDetails(final Schema schema)
    {
        Entity employmentDetails = schema.addEntity("EmploymentDetails");
        employmentDetails.addIdProperty().autoincrement().primaryKey();
        employmentDetails.addStringProperty("companyname").notNull();
        employmentDetails.addStringProperty("jobtype").notNull();
        employmentDetails.addStringProperty("doe").notNull();
        employmentDetails.addStringProperty("location").notNull();
        employmentDetails.addBooleanProperty("pendingsync");
        employmentDetails.addStringProperty("lastsync");

        employmentDetails.addStringProperty("employercontact").notNull();
        return employmentDetails;
    }

    private static Entity customGoals(final Schema schema)
    {

        Entity customGoals = schema.addEntity("CustomGoals");



        return customGoals;

    }

    private static Entity defaultGoals(final Schema schema)
    {
        Entity defaultGoals = schema.addEntity("DefaultGoals");

        return defaultGoals;
    }

    private static Entity userGoals (final Schema schema)
    {
        Entity userGoals = schema.addEntity("UserGoals");

        return  userGoals;
    }

    private static Entity budgetCategories(final Schema schema)
    {
        Entity budgetCategory = schema.addEntity("BudgetCategory");
        budgetCategory.addIdProperty().autoincrement().primaryKey();
        budgetCategory.addStringProperty("name");
        budgetCategory.addBooleanProperty("iscustom");
        budgetCategory.addBooleanProperty("pendingsync");
        budgetCategory.addStringProperty("lastsync");
        return  budgetCategory;
    }

    private static Entity budgetContent (final Schema schema)
    {
        Entity budgetContent = schema.addEntity("BudgetContent");
        budgetContent.addBooleanProperty("pendingsync");
        budgetContent.addStringProperty("lastsync");
        budgetContent.addIdProperty().autoincrement().primaryKey();
        budgetContent.addIntProperty("idbudgetcategory").notNull();
        budgetContent.addStringProperty("name");
        return  budgetContent;
    }

    private static Entity userBudgetDetails(final Schema schema)
    {
        Entity userbudgetdetails = schema.addEntity("UserBudgetDetails");
        userbudgetdetails.addBooleanProperty("pendingsync");
        userbudgetdetails.addStringProperty("lastsync");
        userbudgetdetails.addIdProperty().autoincrement().primaryKey();
        userbudgetdetails.addIntProperty("idbudgetcontent");
        userbudgetdetails.addDoubleProperty("amount");
        return userbudgetdetails;
    }





}
