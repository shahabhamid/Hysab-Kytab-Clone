
package com.e.management.bottom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.e.management.bottom.ui.accounts.AccountsClass;
import com.e.management.bottom.ui.budget.BudgetClass;
import com.e.management.bottom.ui.piechart.PieChartClass;
import com.e.management.bottom.ui.transactions.TransactionsClass;
import com.github.mikephil.charting.charts.PieChart;

public class HomeFragment extends Fragment {

    RecyclerView budgetRecyclarview;
    RecyclerView transactionRecyclarview;
    PieChart pieChart;
    View view;

    void init() {
        budgetRecyclarview = view.findViewById(R.id.home_recyclarviewbudgets);
        transactionRecyclarview = view.findViewById(R.id.home_recyclarviewtransactions);
        pieChart = view.findViewById(R.id.chart);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();

        PieChartClass pieChartClass = new PieChartClass(pieChart);
        pieChartClass.setupPieChart();

        TransactionsClass transactions = new TransactionsClass(getActivity(), getContext(), transactionRecyclarview);
        transactions.getTransactionsData();
        transactions.setTransactions();

        AccountsClass accounts = new AccountsClass(getActivity(), getContext(), view);
        accounts.getAccountsData();
        accounts.setAccounts();

        BudgetClass budget = new BudgetClass(getActivity(), getContext(), budgetRecyclarview);
        budget.getBudgetData();
        budget.setBudgets();

        return view;
    }
}