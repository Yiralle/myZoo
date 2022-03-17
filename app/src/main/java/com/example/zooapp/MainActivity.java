package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    String aTitle[];
    String aInfo[];
    int img[]={R.drawable.elephant, R.drawable.giraffe, R.drawable.panda, R.drawable.rhino, R.drawable.zebra};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        aTitle = getResources().getStringArray(R.array.animalType);
        aInfo = getResources().getStringArray(R.array.info);

        MyAdapter myAdapter = new MyAdapter(this, aTitle,aInfo, img);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == R.id.infoBar)
            {
                //setContentView(R.layout.activity_info);
                infoAct();
            }
            else if(item.getItemId() == R.id.delete)
            {
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("package:com.example.zooapp"));
                startActivity(intent);
            }
            return true;
        }

        public void infoAct(){
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
        }




}