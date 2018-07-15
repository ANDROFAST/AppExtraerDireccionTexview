package com.androidmorefast.moden.appcapturardireccion;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SeleccionarDireccion extends AppCompatActivity {
    private LatLng latlong = new LatLng (-6.760644,-79.863413);
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_direccion);
        MapFragment fMap = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
       // fMap.getMapAsync((OnMapReadyCallback) this);
        map = fMap.getMap();

        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            public void onMapLongClick(LatLng LL)  {
                MainActivity.lat = LL.latitude;
                MainActivity.lon = LL.longitude;
                regresar();

            }

        });
        MainActivity.checked = true;
        if (map!=null){
            iniciarGPS();

        }

    }
    private void iniciarGPS(){
        map.addMarker(new MarkerOptions().position(latlong)
                .title("Ubicación actual"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlong,15));
    }
    public void regresar() {
        Intent intent = new Intent(this, MainActivity.class);
        intent .setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        this.finish();

    }

}
