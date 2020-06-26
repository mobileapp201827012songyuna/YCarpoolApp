package com.android.developer.yuhancarpool;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ToYuhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_yuhan);

        Handler hand = new Handler();

        hand.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(ToYuhan.this, PayActivity.class);
                startActivity(i);
                finish();

            }
        }, 5000);
    }
}
