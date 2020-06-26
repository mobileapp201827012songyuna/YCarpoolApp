package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onSeoulButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), Menu2Activity.class);
        startActivity(intent);
    }

    public void onBucheonButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MainBucheonActivity.class);
        startActivity(intent);
    }

    public void onIncheonButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MainIncheonActivity.class);
        startActivity(intent);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void onNearPlaceButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(intent);
    }
}
