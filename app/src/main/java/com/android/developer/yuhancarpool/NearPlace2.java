package com.android.developer.yuhancarpool;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class NearPlace2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_place2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(this);


        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String str=editText.getText().toString();
                List<Address> addressList = null;
                try {

                    addressList = geocoder.getFromLocationName(
                            str,
                            10);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(addressList.get(0).toString());
                String []splitStr = addressList.get(0).toString().split(",");
                String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2);
                System.out.println(address);
                String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1);
                String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1);
                System.out.println(latitude);
                System.out.println(longitude);


                LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                MarkerOptions mOptions2 = new MarkerOptions();
                mOptions2.title("Place");
                mOptions2.snippet(address);
                mOptions2.position(point);
                mMap.addMarker(mOptions2);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,17));
            }
        });


        LatLng departure = new LatLng(81.934222, -76.055694);
        mMap.addMarker(new MarkerOptions().position(departure).title("a point of departure"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(departure));
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