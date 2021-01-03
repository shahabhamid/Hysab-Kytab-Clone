package com.e.management.bottom.ui.accounts;

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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.viewHolder> {


    ArrayList<AccountData> list;
    Context context;
    Activity activity;
    View view;

    public AccountsAdapter(ArrayList<AccountData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_home_card_accounts, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<AccountData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        if (position < list.size()) {
            AccountData data = list.get(position);
            holder.balance.setText("PKR " + data.getBalance());
            holder.name.setText(data.getName());
            holder.imageView.setVisibility(View.GONE);
            if (!data.isPosNeg()) {
                holder.balance.setTextColor(ContextCompat.getColor(context, R.color.red_loss));
                holder.balance.setText("PKR -" + data.getBalance());
            }
        } else {
            holder.balance.setVisibility(View.GONE);
            holder.name.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        MaterialCardView cardView;
        ImageView imageView;
        TextView name;
        TextView balance;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rvhca_name);
            balance = itemView.findViewById(R.id.rvhca_balance);
            imageView = itemView.findViewById(R.id.rvhca_image);
            cardView = itemView.findViewById(R.id.rvhca_cardView);

            // cardView = itemView.findViewById(R.id.rve_cardview);
            //cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.add(this.getAdapterPosition(),124,0,"Delete");
        }
    }
}
