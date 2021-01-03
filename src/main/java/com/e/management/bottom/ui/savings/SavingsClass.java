package com.e.management.bottom.ui.savings;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavingsClass {

    RecyclerView savingsRecyclerView;
    SavingsAdapter savingsAdapter;
    ArrayList<SavingsData> savingsList = new ArrayList<>();
    Context context;
    Activity activity;

    public SavingsClass(Activity activity, Context context, RecyclerView savingsRecyclerView) {
        this.context = context;
        this.activity = activity;
        this.savingsRecyclerView = savingsRecyclerView;
    }

    public void getSavingsData() {
        SavingsData data = new SavingsData();
        data.setSavings("800");
        data.setTargetSaving("1600");
        data.setCategory("Foods & Drink");
        data.setTargetDate("2 Nov, 2020");

        savingsList.add(data);
        savingsList.add(data);

    }

    public void setSavings() {
        savingsAdapter = new SavingsAdapter(savingsList, context, activity);
        savingsRecyclerView.setAdapter(savingsAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 1);
        savingsRecyclerView.setLayoutManager(layoutManager);
    }


}
