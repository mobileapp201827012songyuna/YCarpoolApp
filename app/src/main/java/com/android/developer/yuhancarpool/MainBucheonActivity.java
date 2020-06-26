package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainBucheonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bucheon);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void onNearPlaceButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(intent);
    }

    public void onBucheonStationButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), BucheonMapActivity.class);
        startActivity(intent);
    }

    public void onYeokgokButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), YeokgokMapActivity.class);
        startActivity(intent);
    }

    public void onSosaButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), SosaMapActivity.class);
        startActivity(intent);
    }
}
