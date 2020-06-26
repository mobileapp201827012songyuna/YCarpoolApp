package com.android.developer.yuhancarpool;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class NearPlaceActivity extends AppCompatActivity
        implements AutoPermissionsListener {

  private static final String TAG = "LOCATION";
  TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_place);

        textView5 = findViewById(R.id.textView5);

        Button button18 = findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startLocationService();
            }
        });

        AutoPermissions.Companion.loadAllPermissions(this, 101);

    }

    public void startLocationService() {
        LocationManager manager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = manager
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if(location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.d(TAG,"startLocationService()");
                String message = "최근 위치 -> 위도 : " +latitude
                        + "\n 경도 : " + longitude;

                textView5.setText(message);

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
    public void onDenied(int i, String[] strings) {
        //Do nothing. i wrote it because SonarLint said me add a nested comment explaining why this mothod is empty...
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions
                .Companion
                .parsePermissions(this, requestCode, permissions, this);
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

            String message = "최근 위치 -> 위도 : " +latitude
                    + "\n 경도 : " + longitude;
            textView5.setText(message);
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










