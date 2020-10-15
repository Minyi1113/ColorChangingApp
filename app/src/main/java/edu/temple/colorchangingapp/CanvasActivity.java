package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CanvasActivity extends AppCompatActivity {
    ConstraintLayout gridlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        getSupportActionBar().setTitle(R.string.CanvasActivity);

        Intent start = getIntent();
        String mycolor = start.getStringExtra("colors");
        String label = start.getStringExtra("Mylabel");

        ((TextView) findViewById(R.id.textView)).setText(label);
        findViewById(R.id.gridlayout).setBackgroundColor(Color.parseColor(mycolor.toLowerCase()));

    }

}