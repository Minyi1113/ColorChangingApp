package edu.temple.colorchangingapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.Random;

public class PaletteFragment extends Fragment {

    View view;
    GridView gridview;
    ColorAdapter adapter;
    String[] colors = {"RED","YELLOW","GREEN","LIGHTGREY","BLUE","GRAY","WHITE","BLACK", "CYAN","YELLOW","MAGENTA","RED"};
    private OnItemSelectedListener listener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        final String[] gridLabels = res.getStringArray(R.array.MyArray);

        view =  inflater.inflate(R.layout.fragment_palette, container, false);

        gridview = view.findViewById((R.id.gridview));
        BaseAdapter adapter = new ColorAdapter(getActivity(),gridLabels);
        gridview.setAdapter(adapter);
        gridview.setNumColumns(3);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color = colors[position];
                listener.onItemSelected(color);
                String name = gridLabels[position];
                listener.canvascolor(name);
            }
        });

        return view;
    }
    public void addColorSelectListener(OnItemSelectedListener listener){
        this.listener = listener;
    }

    public interface OnItemSelectedListener{
        void onItemSelected(String colorHex);

        void canvascolor(String colorname);
    }

}