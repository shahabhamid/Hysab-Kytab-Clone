package com.e.management.bottom.ui.piechart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartClass {

    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;
    ArrayList PieEntryLabels;

    public PieChartClass(PieChart pieChart) {
        this.pieChart = pieChart;
    }

    private void getEntries() {

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, 0));
        pieEntries.add(new PieEntry(4f, 1));
        pieEntries.add(new PieEntry(6f, 2));
        pieEntries.add(new PieEntry(8f, 3));
        pieEntries.add(new PieEntry(7f, 4));
        pieEntries.add(new PieEntry(3f, 5));
    }

    public void setupPieChart() {

        getEntries();
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);

    }
}
