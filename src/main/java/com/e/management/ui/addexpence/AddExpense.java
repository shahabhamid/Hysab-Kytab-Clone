package com.e.management.ui.addexpence;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.e.management.R;
import com.e.management.ui.ExpenseData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddExpense extends Fragment {

    View view;
    EditText expense;
    EditText quantity;
    Button add;
    EditText type;
    SqliteHelper sqLiteHelper;

    void init() {
        expense = view.findViewById(R.id.ae_expense);
        quantity = view.findViewById(R.id.ae_quantity);
        add = view.findViewById(R.id.ae_add);
        type = view.findViewById(R.id.ae_spinner);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_add_expense, container, false);
        init();

        sqLiteHelper = new SqliteHelper(getContext(), "Expense", null, 2);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Expense (" + ExpenseData.TYPE + " VARCHAR,"
                + ExpenseData.QUANTITY + " VARCHAR,"
                + ExpenseData.EXPENSE + " VARCHAR,"
                + ExpenseData.TIME + " VARCHAR,"
                + ExpenseData.DATE + " VARCHAR )");

        add();

        return view;
    }

    void add() {

        add.setOnClickListener(new View.OnClickListener() {
            final String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            final String time = new SimpleDateFormat("hh:mm:ss89", Locale.getDefault()).format(new Date());

            @Override
            public void onClick(View v) {
                sqLiteHelper.insertData(type.getText().toString(), quantity.getText().toString(), expense.getText().toString(), time, date);
                Toast.makeText(getContext(), "Added Successfully!", Toast.LENGTH_SHORT).show();

            }
        });

    }

}