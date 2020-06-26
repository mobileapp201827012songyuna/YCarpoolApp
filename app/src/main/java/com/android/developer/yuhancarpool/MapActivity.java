package com.android.developer.yuhancarpool;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MapActivity extends AppCompatActivity
        implements AutoPermissionsListener {

    private  static  final  String TAG = "MAP";

    SupportMapFragment mapFragment;
    GoogleMap map;

    MarkerOptions myLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "맵 준비됨");
                map = googleMap;

                map.setMyLocationEnabled(true);
            }
        });
        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button button = findViewById(R.id.button19);
        View btn20 = findViewById(R.id.button20);
        btn20.setVisibility(View.INVISIBLE);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });

        AutoPermissions.Companion.loadAllPermissions(this,101);
    }

    public  void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FindActivity.class);
        startActivity(intent);
    }

    public void onTaxiButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void onBtn22Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(), NearPlace2.class);
        startActivity(intent);
    }




    @Override
    protected void onPause() {
        super.onPause();
        if(map != null) {
            map.setMyLocationEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(map != null) {
            map.setMyLocationEnabled(true);
        }
    }





    private void showCurrentLocation(Double latitude, Double longitude) {
        LatLng curPoint = new LatLng(latitude, longitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,17));
    }
    public void startLocationService() {
        View btn20 = findViewById(R.id.button20);
        btn20.setVisibility(View.VISIBLE);
        LocationManager manager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = manager
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if(location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.d(TAG,"startLocationService()");

                showCurrentLocation(latitude, longitude);


                GPSListener gpsListener = new GPSListener();
                long minTime = 10000;
                float minDistance = 0;

                manager.requestLocationUpdates
                        (LocationManager.GPS_PROVIDER,minTime,
                                minDistance,gpsListener );
            }
        } catch(SecurityException e) {
            e.printStackTrace();


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.
                Companion.parsePermissions(this, requestCode, permissions,this);
    }

    @Override
    public void onDenied(int i, String[] strings) {
        //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
    }

    @Override
    public void onGranted(int i, String[] strings) {
        //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
    }


    class GPSListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            showCurrentLocation(latitude, longitude);
            Log.d(TAG,"onLocationChanged()");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
        }

        @Override
        public void onProviderEnabled(String provider) {
            //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
        }

        @Override
        public void onProviderDisabled(String provider) {
            //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
        }
    }

}



