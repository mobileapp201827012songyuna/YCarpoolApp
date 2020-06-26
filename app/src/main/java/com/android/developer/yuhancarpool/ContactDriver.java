package com.android.developer.yuhancarpool;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ContactDriver extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_driver);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;



        // Add a marker in Sydney and move the camera
        LatLng onsustation = new LatLng(37.492343, 126.823631);

        LatLng yuhan = new LatLng(37.487287, 126.820518);
        LatLng middle = new LatLng(37.489760, 126.821934);

        mMap.addMarker(new MarkerOptions().position(yuhan).title("yuhan university"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(middle,16));


        mMap.addPolyline(new PolylineOptions().add(onsustation,yuhan).width(10).color(Color.RED));




    }

    public void onCallButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), TaxiComing.class);
        startActivity(intent);
    }
}