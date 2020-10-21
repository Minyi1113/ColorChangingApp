package edu.temple.colorchangingapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;


public class CanvasFragment extends Fragment {

    TextView textView;
    FrameLayout framelayout;

    public  static CanvasFragment newInstance (){
        return new CanvasFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

        framelayout = view.findViewById(R.id.framelayout);
        textView = view.findViewById(R.id.textView);

        return view;
    }

    public void setBackgroundColor(String color) {
        framelayout.setBackgroundColor(Color.parseColor(color));
    }

    public void colorname(String name){
        textView.setText(name);
    }
}