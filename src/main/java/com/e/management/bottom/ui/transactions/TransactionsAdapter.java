package com.e.management.bottom.ui.transactions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;

import java.util.ArrayList;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.viewHolder> {


    ArrayList<TransactionsData> list;
    Context context;
    Activity activity;
    View view;

    public TransactionsAdapter(ArrayList<TransactionsData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_transactions, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<TransactionsData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        TransactionsData data = list.get(position);

        holder.expense.setText("PKR " + data.getExpense());
        holder.expensetype.setText(data.getExpensetype());
        holder.category.setText(data.getCategory());
        holder.date.setText(data.getDate());
        holder.image.setImageResource(data.getImage());
        holder.description.setText(data.getDescription());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        CardView cardView;

        ImageView image;
        TextView category;
        TextView description;
        TextView date;
        TextView expense;
        TextView expensetype;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rvt_image);
            category = itemView.findViewById(R.id.rvt_category);
            expense = itemView.findViewById(R.id.rvt_expense);
            description = itemView.findViewById(R.id.rvt_description);
            date = itemView.findViewById(R.id.rvt_date);
            expensetype = itemView.findViewById(R.id.rvt_expenseType);
            // cardView = itemView.findViewById(R.id.rve_cardview);
            //cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.add(this.getAdapterPosition(),124,0,"Delete");
        }
    }
}
