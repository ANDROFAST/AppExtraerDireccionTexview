package com.androidmorefast.moden.appcapturardireccion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AndroidMorefast on 19/06/2016.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    Button btnDireccion;
    TextView lblDireccion;
    public static double lat = 0;
    public static double lon = 0;
    public static boolean checked = false; //Se ha chequeado el mapa.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btnDireccion = (Button) findViewById(R.id.btnDireccion);
        lblDireccion = (TextView) findViewById(R.id.lblDireccion);

    }

    public void onWindowFocusChanged(boolean hasFocus){
        if (hasFocus){
            if (checked){
                checked = false;
                this.lblDireccion.setText(F.getDireccionLL(lat, lon));
            }
        }
    }

    public void onClick(View v) {
        Intent pantalla = new Intent(this, SeleccionarDireccion.class);
        this.startActivity(pantalla);
    }

}

