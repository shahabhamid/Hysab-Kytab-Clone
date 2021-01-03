package com.e.management.bottom.ui.money;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.e.management.bottom.ui.accounts.AccountsClass;
import com.e.management.bottom.ui.fab.FABClass;
import com.e.management.bottom.ui.transactions.TransactionsClass;


public class MoneyFragment extends Fragment {

    RecyclerView transactionRecyclarview;
    RecyclerView fabRecyclarview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_money, container, false);

        transactionRecyclarview = view.findViewById(R.id.money_recyclarviewtransactions);
        fabRecyclarview = view.findViewById(R.id.money_recyclarview_fab);

        TransactionsClass transactions = new TransactionsClass(getActivity(), getContext(), transactionRecyclarview);
        transactions.getTransactionsData();
        transactions.setTransactions();

        AccountsClass accounts = new AccountsClass(getActivity(), getContext(), view);
        accounts.getAccountsData();
        accounts.setAccounts();

        FABClass fabClass = new FABClass(getActivity(), getContext(), fabRecyclarview);
        fabClass.getFABData();
        fabClass.setFAB();

        return view;
    }
}