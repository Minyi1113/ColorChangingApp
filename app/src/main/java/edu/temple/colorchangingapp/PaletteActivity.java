package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    GridView gridview;
    String[] color = {"RED","YELLOW","GREEN","LIGHTGREY","BLUE","GRAY","WHITE","BLACK", "CYAN","YELLOW","MAGENTA","RED"};
    public static final String colorSelected = "Color";
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.PaletteActivity);

        Resources res = getResources();
        final String[] gridLabels = res.getStringArray(R.array.MyArray);

        gridview = findViewById(R.id.gridview);
        BaseAdapter adapter = new ColorAdapter(this,gridLabels);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this,CanvasActivity.class);
                intent.putExtra("colors",color[position]);
                intent.putExtra("Mylabel", gridLabels[position]);
                startActivityForResult(intent,000);
            }
        });
    }
}
