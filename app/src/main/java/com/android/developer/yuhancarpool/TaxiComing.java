package com.android.developer.yuhancarpool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TaxiComing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_coming);

        Handler hand = new Handler();

        hand.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(TaxiComing.this,ToYuhan.class);
                startActivity(i);
                finish();

            }
        }, 5000);
    }
}

