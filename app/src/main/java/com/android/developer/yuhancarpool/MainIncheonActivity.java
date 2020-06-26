package com.android.developer.yuhancarpool;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainIncheonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_incheon);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void onNearPlaceButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(intent);
    }

    public void onBupyeongButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), BupyeongMap.class);
        startActivity(intent);
    }

    public void onGyeyangButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), GyeyangMapActivity.class);
        startActivity(intent);
    }

    public void onImhakButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ImhakActivity.class);
        startActivity(intent);
    }
}
