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



public class GyeyangMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap mMap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyeyang_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng gyeyangstation = new LatLng(37.571602, 126.736313);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gyeyangstation ,18));


        mMap.addMarker(new MarkerOptions().position(gyeyangstation ).title("GyeYang Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gyeyangstation ));
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