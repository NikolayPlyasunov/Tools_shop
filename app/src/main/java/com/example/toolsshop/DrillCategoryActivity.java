package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;

    private ArrayList<Drills> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        drills = new ArrayList<>();
        drills.add(new Drills(getString(R.string.drill_interscoll_title),
                getString(R.string.drill_interscoll_info), R.drawable.interskol));
        drills.add(new Drills(getString(R.string.drill_makita_title),
                getString(R.string.drill_makita_info), R.drawable.makita));
        drills.add(new Drills(getString(R.string.drill_dewalt_title),
                getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        listViewDrills = findViewById(R.id.listViewDrills);
        ArrayAdapter<Drills> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drills drill = drills.get(position);
                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId",drill.getImageResourceId());
                startActivity(intent);
            }
        });

    }
}