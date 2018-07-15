package com.androidmorefast.moden.appcapturardireccion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by AndroidMorefast on 19/06/2016.
 */
public class F {
    public static String getDireccionLL(double latitud, double longitud){
        String googleapi = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+
                String.valueOf(latitud)+"%2C"+
                String.valueOf(longitud);

        String resultado = null;
        try {
            resultado = new Http().enviarGet(googleapi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONObject json = new JSONObject(resultado);
            JSONArray jsonArray = json.getJSONArray("results");

            JSONObject jsonData = jsonArray.getJSONObject(0);

            return jsonData.getString("formatted_address");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Lat / Long inválidas";
    }

}
