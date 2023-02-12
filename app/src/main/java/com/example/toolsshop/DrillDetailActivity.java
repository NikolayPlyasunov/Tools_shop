package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView tvInterscolName;
    private TextView tvInterscolDescription;
    private ImageView imageViewInterscol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        tvInterscolName = findViewById(R.id.tvDrillName);
        tvInterscolDescription = findViewById(R.id.tvIDrillDescription);
        imageViewInterscol = findViewById(R.id.imageViewDrill);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            tvInterscolName.setText(title);
            tvInterscolDescription.setText(info);
            imageViewInterscol.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}