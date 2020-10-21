package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity implements PaletteFragment.OnItemSelectedListener {

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    GridView gridview;
    String[] color = {"RED","YELLOW","GREEN","LIGHTGREY","BLUE","GRAY","WHITE","BLACK", "CYAN","YELLOW","MAGENTA","RED"};
    public static final String colorSelected = "Color";
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.PaletteActivity);

        paletteFragment = new PaletteFragment();
        canvasFragment= new CanvasFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .add(R.id.container_2, canvasFragment)
                .commit();

        paletteFragment.addColorSelectListener(this);

    }


    @Override
    public void onItemSelected(String colorHex) {
        canvasFragment.setBackgroundColor(colorHex);
    }

    public void canvascolor(String colorname){
        canvasFragment.colorname(colorname);
    }


}
