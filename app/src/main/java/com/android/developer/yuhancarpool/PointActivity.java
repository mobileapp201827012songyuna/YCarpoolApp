package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class PointActivity extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap mMap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onsu_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng onsustation = new LatLng(37.492343, 126.823631);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(onsustation,20));









        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng point) {
                throw new UnsupportedOperationException();
            }
        });

        mMap.addMarker(new MarkerOptions().position(onsustation).title("Marker in Onsu Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(onsustation));
    }

    public  void onClick() {
        Intent intent = new Intent(getApplicationContext(), FindActivity.class);
        startActivity(intent);
    }

    public void onTaxiButtonClicked() {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}