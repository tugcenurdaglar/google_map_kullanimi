package com.tugcenurdaglar.haritaislemleri;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button buttonGit;
    private EditText editTextEnlem, editTextBoylam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        buttonGit = findViewById(R.id.buttonGit);
        editTextEnlem = findViewById(R.id.editTextEnlem);
        editTextBoylam = findViewById(R.id.editTextBoylam);

        buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enlem = editTextEnlem.getText().toString();
                String boylam = editTextBoylam.getText().toString();

                LatLng konum = new LatLng(Double.parseDouble(enlem), Double.parseDouble(boylam));
                mMap.addMarker(new MarkerOptions().position(konum).title("HEDEF"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,10.16f));
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}