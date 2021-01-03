package com.e.management.bottom.ui.savings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;


public class SavingsFragment extends Fragment {

    View view;
    RecyclerView savingsRecyclarview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_savings, container, false);
        savingsRecyclarview = view.findViewById(R.id.savings_recyclarview);
        SavingsClass savings = new SavingsClass(getActivity(), getContext(), savingsRecyclarview);
        savings.getSavingsData();
        savings.setSavings();


        return view;
    }
}