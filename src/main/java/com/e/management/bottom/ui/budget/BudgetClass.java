package com.e.management.bottom.ui.budget;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BudgetClass {
//
    RecyclerView budgetRecyclerView;
    BudgetAdapter budgetAdapter;
    ArrayList<BudgetData> budgetList = new ArrayList<>();
    Context context;
    Activity activity;

    public BudgetClass(Activity activity, Context context, RecyclerView budgetRecyclerView) {
        this.context = context;
        this.activity = activity;
        this.budgetRecyclerView = budgetRecyclerView;
    }

    public void getBudgetData() {
        BudgetData data = new BudgetData();
        data.setBudget("800");
        data.setExpense("500");
        data.setCategory("Foods & Drink");
        data.setBudgetLeft("300");

        budgetList.add(data);
        budgetList.add(data);

    }

    public void setBudgets() {
        budgetAdapter = new BudgetAdapter(budgetList, context, activity);
        budgetRecyclerView.setAdapter(budgetAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 1);
        budgetRecyclerView.setLayoutManager(layoutManager);
    }


}
