package com.e.management.bottom.ui.fab;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FABClass {

    RecyclerView fabRecyclerView;
    FABAdapter fabAdapter;
    ArrayList<FABData> fablist = new ArrayList<>();
    Context context;
    Activity activity;
    View view;

    public FABClass(Activity activity, Context context, RecyclerView fabRecyclerView) {
        this.context = context;
        this.activity = activity;
        this.view = view;
        this.fabRecyclerView = fabRecyclerView;
    }

    public void getFABData() {
        FABData data = new FABData();
        data.setName("History");

        //    data.setImage(R.drawable.ic_home_black_24dp);
        fablist.add(data);
        fablist.add(data);

    }

    public void setFAB() {
        fabAdapter = new FABAdapter(fablist, context, activity);
        fabRecyclerView.setAdapter(fabAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(context, 1);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager()
        fabRecyclerView.setLayoutManager(layoutManager);
    }


}
