package com.e.management.bottom.ui.savings;

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

public class SavingsAdapter extends RecyclerView.Adapter<SavingsAdapter.viewHolder> {


    ArrayList<SavingsData> list;
    Context context;
    Activity activity;
    View view;

    public SavingsAdapter(ArrayList<SavingsData> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        view = LayoutInflater.from(context).inflate(R.layout.recyclarview_saving_goals, parent, false);
        return new viewHolder(view);
    }

    public void filterlist(ArrayList<SavingsData> expenseData) {
        this.list = expenseData;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        SavingsData data = list.get(position);

        holder.saved.setText("PKR " + data.getSavings());
        holder.progressBar.setProgress(50);
        holder.category.setText(data.getCategory());
        holder.targetSave.setText(data.getTargetSaving());
        //holder.image.setBackgroundResource(data.get);
        holder.targetDate.setText("/" + data.getTargetDate());
        holder.percentageSaved.setText("50%");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        CardView cardView;

        ImageView image;
        TextView category;
        TextView targetDate;
        TextView targetSave;
        TextView saved;
        TextView percentageSaved;
        ProgressBar progressBar;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rvsg_image);
            category = itemView.findViewById(R.id.rvsg_category);
            saved = itemView.findViewById(R.id.rvsg_saved);
            targetDate = itemView.findViewById(R.id.rvsg_targetDate);
            targetSave = itemView.findViewById(R.id.rvsg_targetSave);
            progressBar = itemView.findViewById(R.id.rvsg_progress);
            percentageSaved = itemView.findViewById(R.id.rvsg_percentageSave);
            cardView = itemView.findViewById(R.id.rvsg_card);
            //cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.add(this.getAdapterPosition(),124,0,"Delete");
        }
    }
}
