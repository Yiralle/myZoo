package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        call = findViewById(R.id.callButton);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myPhoneNumUri= "tel: +8888888";
                Intent call = new Intent (Intent.ACTION_DIAL, Uri.parse(myPhoneNumUri));
                startActivity(call);
            }
        });


    }


}