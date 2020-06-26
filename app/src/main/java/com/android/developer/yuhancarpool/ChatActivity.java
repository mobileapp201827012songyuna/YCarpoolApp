package com.android.developer.yuhancarpool;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ImageView img =(ImageView)findViewById(R.id.imageView7);
        img.setVisibility(View.INVISIBLE);

        ImageView img2 =(ImageView)findViewById(R.id.imageView2);
        img2.setVisibility(View.INVISIBLE);





        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                ImageView img =(ImageView)findViewById(R.id.imageView7);
                img.setVisibility(View.VISIBLE);
            }
        }, 4000);

    }

    public void onTestClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ContactDriver.class);
        startActivity(intent);
    }







}
