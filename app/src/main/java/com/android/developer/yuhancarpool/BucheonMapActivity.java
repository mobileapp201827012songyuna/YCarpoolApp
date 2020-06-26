package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class BucheonMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap mMap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucheon_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng bucheon1 = new LatLng(37.484008, 126.782677);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bucheon1,18));



        mMap.addMarker(new MarkerOptions().position(bucheon1).title("Bucheon Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bucheon1));
    }

    public  void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FindActivity.class);
        startActivity(intent);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}