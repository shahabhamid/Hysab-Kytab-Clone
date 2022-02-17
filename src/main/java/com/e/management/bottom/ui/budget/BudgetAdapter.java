package com.e.management.bottom.ui.budget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;

import java.util.ArrayList;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.viewHolder> {

//chcecking for git
    ArrayList<BudgetData> list;
    Context context;
    Activity activity;
    View view;

    public BudgetAdapter(ArrayList<BudgetData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_budgets, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<BudgetData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        BudgetData data = list.get(position);

        holder.expense.setText("PKR " + data.getExpense());
        holder.progressBar.setProgress(50);
        holder.category.setText(data.getCategory());
        holder.budgetleft.setText(data.getBudgetLeft());
        //holder.image.setBackgroundResource(data.get);
        holder.budget.setText("/" + data.getBudget());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        CardView cardView;

        ImageView image;
        TextView category;
        TextView budget;
        TextView budgetleft;
        TextView expense;
        ProgressBar progressBar;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rvb_image);
            category = itemView.findViewById(R.id.rvb_category);
            expense = itemView.findViewById(R.id.rvb_expense);
            budget = itemView.findViewById(R.id.rvb_budget);
            budgetleft = itemView.findViewById(R.id.rvb_budgetleft);
            progressBar = itemView.findViewById(R.id.rvb_progress);
            cardView = itemView.findViewById(R.id.rvb_card);
            //cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.add(this.getAdapterPosition(),124,0,"Delete");
        }
    }
}
