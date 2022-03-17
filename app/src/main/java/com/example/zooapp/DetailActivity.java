package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView apic;
    TextView animalTitle;
    TextView animalDetail;

    String data;
    String data2;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        apic = findViewById(R.id.imageView2);
        animalTitle = findViewById(R.id.animalTitle);
        animalDetail = findViewById(R.id.animalDetail);

        getData();
        setData();

    }

    private void getData() {
        if(getIntent().hasExtra("image") && getIntent().hasExtra("data")
        && getIntent().hasExtra("data2"))
        {
            data = getIntent().getStringExtra("data");
            data2 = getIntent().getStringExtra("data2");
            image = getIntent().getIntExtra("image",1);
        }
    }

    private void setData() {
        animalTitle.setText(data);
        animalDetail.setText(data2);
        apic.setImageResource(image);
    }
}