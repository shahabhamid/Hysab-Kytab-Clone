package com.e.management.ui.viewexpence;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.e.management.ui.ExpenseData;

import java.util.ArrayList;

public class ViewExpenses extends Fragment {

    ArrayList<ExpenseData> expenseList = new ArrayList<ExpenseData>();
    RecyclerView recyclerView;
    ViewExpenseAdapter adapter;
    TextView total;
    EditText type;
    int TOTALEXPENSE = 0;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_view_expense, container, false);
        recyclerView = view.findViewById(R.id.ve_recylarview);
        total = view.findViewById(R.id.ve_total);
        type = view.findViewById(R.id.ve_type);

        try {


            GetDataFromDB();
            setAdapterNLayout();
            total.setText(Integer.toString(TOTALEXPENSE));
            search();

        } catch (Exception e) {

        }

        return view;
    }

    public void search() {
        type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void filter(String s) {
        ArrayList<ExpenseData> filterlist = new ArrayList<>();
        int totalp = 0;
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getType().toLowerCase().contains(s.toLowerCase())) {
                filterlist.add(expenseList.get(i));
                totalp = totalp + Integer.parseInt(expenseList.get(i).getExpense());
            }
        }
        total.setText(Integer.toString(totalp));
        adapter.filterlist(filterlist);
    }

    public void setAdapterNLayout() {
        adapter = new ViewExpenseAdapter(expenseList, getContext(), getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case 124:

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Are You Sure You want to Delete ?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SQLiteDatabase db = getActivity().openOrCreateDatabase("Expense", Context.MODE_PRIVATE, null);
                        Cursor c = db.rawQuery("Delete from Expense where " + ExpenseData.DATE + " = ? AND " + ExpenseData.TIME + " = ?", null);
                        System.out.println(expenseList.get(item.getGroupId()).getTime());
                        int num = db.delete("Expense", ExpenseData.DATE + " = ? AND " + ExpenseData.TIME + " = ?", new String[]{expenseList.get(item.getGroupId()).getDate(), expenseList.get(item.getGroupId()).getTime()});
                        GetDataFromDB();
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null);
                AlertDialog alert = builder.create();
                alert.show();

            default:
                return super.onContextItemSelected(item);
        }
    }


    public void GetDataFromDB() {
        TOTALEXPENSE = 0;
        try {
            expenseList.clear();

            SQLiteDatabase db = getActivity().openOrCreateDatabase("Expense", Context.MODE_PRIVATE, null);
            Cursor c = db.rawQuery("select * from Expense", null);

            if (c.moveToFirst()) {

                do {
                    ExpenseData expenseData = new ExpenseData();

                    expenseData.setType(c.getString(c.getColumnIndex(ExpenseData.TYPE)));
                    expenseData.setQuantity(c.getString(c.getColumnIndex(ExpenseData.QUANTITY)));
                    expenseData.setExpense(c.getString(c.getColumnIndex(ExpenseData.EXPENSE)));
                    expenseData.setTime(c.getString(c.getColumnIndex(ExpenseData.TIME)));
                    expenseData.setDate(c.getString(c.getColumnIndex(ExpenseData.DATE)));
                    TOTALEXPENSE = TOTALEXPENSE + Integer.parseInt(c.getString(c.getColumnIndex(ExpenseData.EXPENSE)));
                    expenseList.add(expenseData);


                } while (c.moveToNext());
            }
            total.setText(Integer.toString(TOTALEXPENSE));
        } catch (Exception ex) {
            Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}