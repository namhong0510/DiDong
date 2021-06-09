package com.example.nguyensyhongnam_51702139_lab10.ex2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.nguyensyhongnam_51702139_lab10.R;


public class Ex2Activity extends AppCompatActivity implements LocationListener {

    Button btnCheckGpsStatus;
    TextView txtGpsStatus;
    Context context;
    LocationManager locationManager;
    boolean isGpsEnable;
    private TextView txtLatitude;
    private TextView txtLongitude;
    public static final int requestPermissionCode = 1;
    private Button btnEnable;
    private Button btnUpdate;
    Location location;
    private String lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex2_activity);

        btnCheckGpsStatus = findViewById(R.id.btnCheckGpsStatus);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnEnable = findViewById(R.id.btnEnable);
        txtGpsStatus = findViewById(R.id.txtGpsStatus);
        txtLatitude = findViewById(R.id.txtLatitude);
        txtLongitude = findViewById(R.id.txtLongitude);

        context = getApplicationContext();

        enableRuntimePermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        lastKnownLocation = locationManager.getBestProvider(criteria, false);

        checkGpsStatus();

        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gpsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(gpsIntent);
            }
        });

        btnCheckGpsStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGpsStatus();
                if (isGpsEnable) {
                    txtGpsStatus.setText("Location Services Is Enabled");
                } else {
                    txtGpsStatus.setText("Location Services Is Disabled");
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGpsStatus();
                if (isGpsEnable) {
                    if (ActivityCompat.checkSelfPermission(
                            Ex2Activity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            &&
                            ActivityCompat.checkSelfPermission(Ex2Activity.this,
                                    Manifest.permission.ACCESS_COARSE_LOCATION)
                                    != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    location = locationManager.getLastKnownLocation(lastKnownLocation);
                    locationManager
                            .requestLocationUpdates(lastKnownLocation, 12000, 7, Ex2Activity.this);

                } else {
                    Toast.makeText(Ex2Activity.this, "Please Enable GPS First", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    public void enableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Ex2Activity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(Ex2Activity.this,
                    "ACCESS_FINE_LOCATION permission allows us to Access GPS in app", Toast.LENGTH_LONG)
                    .show();
        } else {
            ActivityCompat.requestPermissions(Ex2Activity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION}, requestPermissionCode);

        }
    }

    public void checkGpsStatus() {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLongitude.setText("Longitude:" + location.getLongitude());
        txtLatitude.setText("Latitude:" + location.getLatitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
        switch (RC) {
            case requestPermissionCode:
                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Ex2Activity.this,
                            "Permission Granted, Now your application can access GPS.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Ex2Activity.this,
                            "Permission Canceled, Now your application cannot access GPS.", Toast.LENGTH_LONG)
                            .show();
                }
                break;
        }
    }
}