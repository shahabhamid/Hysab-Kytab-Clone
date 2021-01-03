package com.e.management.bottom.ui.transactions;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.e.management.ui.ExpenseData;

import java.util.ArrayList;

public class TransactionsClass {

    RecyclerView transactionsRecyclerView;
    TransactionsAdapter transactionsAdapter;
    ArrayList<TransactionsData> transactionsList = new ArrayList<>();

    Context context;
    Activity activity;


    public TransactionsClass(Activity activity, Context context, RecyclerView transactionsRecyclerView) {
        this.context = context;
        this.activity = activity;
        this.transactionsRecyclerView = transactionsRecyclerView;
    }

    public void setTransactions() {
        transactionsAdapter = new TransactionsAdapter(transactionsList, context, activity);
        transactionsRecyclerView.setAdapter(transactionsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        transactionsRecyclerView.setLayoutManager(layoutManager);
    }

    public void getTransactionsData() {
        try {
            transactionsList.clear();

            SQLiteDatabase db = activity.openOrCreateDatabase("Expense", Context.MODE_PRIVATE, null);
            Cursor c = db.rawQuery("select * from Expense", null);

            if (c.moveToFirst()) {

                do {
                    TransactionsData transactionsData = new TransactionsData();

                    transactionsData.setCategory(c.getString(c.getColumnIndex(ExpenseData.TYPE)));
                    transactionsData.setExpensetype(c.getString(c.getColumnIndex(ExpenseData.QUANTITY)));
                    transactionsData.setExpense(c.getString(c.getColumnIndex(ExpenseData.EXPENSE)));
                    transactionsData.setDescription(c.getString(c.getColumnIndex(ExpenseData.TYPE)));
                    transactionsData.setImage(R.drawable.ic_notifications_black_24dp);
                    //transactionsData.setTime(c.getString(c.getColumnIndex(ExpenseData.TIME)));
                    transactionsData.setDate(c.getString(c.getColumnIndex(ExpenseData.DATE)));
                    //TOTALEXPENSE = TOTALEXPENSE + Integer.parseInt(c.getString(c.getColumnIndex(ExpenseData.EXPENSE)));
                    transactionsList.add(transactionsData);


                } while (c.moveToNext());
            }
            //  total.setText(Integer.toString(TOTALEXPENSE));
        } catch (Exception ex) {
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
