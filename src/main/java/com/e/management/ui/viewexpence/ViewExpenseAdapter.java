package com.e.management.ui.viewexpence;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.e.management.ui.ExpenseData;

import java.util.ArrayList;

public class ViewExpenseAdapter extends RecyclerView.Adapter<ViewExpenseAdapter.viewHolder> {


    ArrayList<ExpenseData> list;
    Context context;
    Activity activity;
    View view;

    public ViewExpenseAdapter(ArrayList<ExpenseData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_view_expense, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<ExpenseData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        ExpenseData feedsList = list.get(position);

        holder.expense.setText(feedsList.getExpense());
        holder.type.setText(feedsList.getType());
        holder.quantity.setText(feedsList.getQuantity());
        holder.time.setText(feedsList.getTime());
        holder.date.setText(feedsList.getDate());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        TextView type;
        TextView quantity;
        TextView expense;
        TextView time;
        TextView date;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.rve_type);
            quantity = itemView.findViewById(R.id.rve_quantity);
            expense = itemView.findViewById(R.id.rve_expense);
            time = itemView.findViewById(R.id.rve_time);
            date = itemView.findViewById(R.id.rve_date);
            cardView = itemView.findViewById(R.id.rve_cardview);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 124, 0, "Delete");
        }
    }
}
