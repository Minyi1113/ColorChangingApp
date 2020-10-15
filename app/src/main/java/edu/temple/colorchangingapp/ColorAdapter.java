package edu.temple.colorchangingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String[] color;
    int colors[];


    public ColorAdapter(Context context, String[] color){
        this.context = context;
        this.color = color;


        colors = new int[13];
        colors[0] = Color.RED;
        colors[1] = Color.YELLOW;
        colors[2] = Color.GREEN;
        colors[3] = Color.LTGRAY;
        colors[4] = Color.BLUE;
        colors[5] = Color.GRAY;
        colors[6] = Color.WHITE;
        colors[7] = Color.BLACK;
        colors[8] = Color.CYAN;
        colors[9] = Color.YELLOW;
        colors[10] = Color.MAGENTA;
        colors[11] = Color.RED;

    }

    @Override
    public int getCount() {
        return color.length;
    }

    @Override
    public Object getItem(int position) {
        return color[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);

        } else{
            textView = (TextView) convertView;
        }

        textView.setTextSize(20);
        textView.setPadding(28,28,28,28);
        textView.setText(getItem(position).toString());
        textView.setBackgroundColor(colors[position % colors.length]);
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = getView(position, convertView, parent);
        return v;
    }

}