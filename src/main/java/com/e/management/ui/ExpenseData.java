package com.e.management.ui;

public class ExpenseData {

    public static String TYPE = "Type";
    public static String QUANTITY = "Quantity";
    public static String EXPENSE = "Expense";
    public static String DATE = "Date";
    public static String TIME = "Time";
    private String type;
    private String quantity;
    private String expense;
    private String date;
    private String time;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
