package com.e.management.bottom.ui.fab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.management.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FABAdapter extends RecyclerView.Adapter<FABAdapter.viewHolder> {


    ArrayList<FABData> list;
    Context context;
    Activity activity;
    View view;

    public FABAdapter(ArrayList<FABData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_fab_buttons, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<FABData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        FABData data = list.get(position);

        //holder.fab.setBackgroundDrawable(data.getImage());
        holder.name.setText(data.getName());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        FloatingActionButton fab;
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fab = itemView.findViewById(R.id.fab_button);
            name = itemView.findViewById(R.id.fab_name);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.add(this.getAdapterPosition(),124,0,"Delete");
        }
    }
}
