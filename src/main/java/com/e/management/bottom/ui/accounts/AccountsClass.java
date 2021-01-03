package com.e.management.bottom.ui.accounts;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;

import java.util.ArrayList;

public class AccountsClass {

    RecyclerView accountsRecyclerView;
    AccountsAdapter accountsAdapter;
    ArrayList<AccountData> accountList = new ArrayList<>();
    Context context;
    Activity activity;
    View view;

    public AccountsClass(Activity activity, Context context, View view) {
        this.context = context;
        this.activity = activity;
        this.view = view;
        accountsRecyclerView = view.findViewById(R.id.accounts_recyclarview);
    }

    public void setAccounts() {
        accountsAdapter = new AccountsAdapter(accountList, context, activity);
        accountsRecyclerView.setAdapter(accountsAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 3);
        accountsRecyclerView.setLayoutManager(layoutManager);
    }


    public void getAccountsData() {
        AccountData data = new AccountData();
        data.setBalance(30000);
        data.setName("JazzCash");
        data.setPosNeg(true);

        accountList.add(data);
        accountList.add(data);

        AccountData data1 = new AccountData();
        data1.setBalance(30000);
        data1.setName("Alfa");
        data1.setPosNeg(false);
        accountList.add(data1);
        accountList.add(data);
    }
}
