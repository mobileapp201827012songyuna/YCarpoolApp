package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class FindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        Handler hand = new Handler();

        hand.postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(FindActivity.this, ChatActivity.class);
                startActivity(i);
                finish();

            }
        }, 4000);


    }

}
