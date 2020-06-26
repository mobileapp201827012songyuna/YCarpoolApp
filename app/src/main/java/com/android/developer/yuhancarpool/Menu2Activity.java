package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Menu2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void onNearPlaceButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(intent);
    }

    public void onOnsuButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), OnsuMapActivity.class);
        startActivity(intent);
    }

    public void onGaebongButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), GaebongMapActivity.class);
        startActivity(intent);
    }

    public void onOryuButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ORyuMapActivity.class);
        startActivity(intent);
    }
}
