package com.example.ubicateehbuap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaBici extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner comboEdificiosOrigen,comboEdificiosDestino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mapa_bici);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                .findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);

        comboEdificiosOrigen = ( Spinner) findViewById (R.id.SpinnerOrigenBici);// Spinner de Peaton Origen
        comboEdificiosDestino = ( Spinner) findViewById (R.id.SpinnerDestinoBici);// Spinner de Peaton Origen

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource (this,R.array.comboEdificios,
                android.R.layout.simple_spinner_item); //Llama al contenido de opciones peaton de la carpeta values

        comboEdificiosOrigen.setAdapter(adapter);//Rellena los combos con el adaptador
        comboEdificiosDestino.setAdapter (adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);

        //Create a LatLngBounds that includes the city of Buap.
        LatLng buapCenter = new LatLng(18.999835, -98.200222);
        LatLngBounds buap= new LatLngBounds(new LatLng(18.993126, -98.205660), new LatLng(19.006718, -98.194199));
        // Move the camera instantly to Sydney with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buapCenter, 15));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(buapCenter)      // Sets the center of the map to Mountain View
                .zoom(15)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        LatLng parada1 = new LatLng (18.998163, -98.195138);
        mMap.addMarker (new MarkerOptions ().position (parada1).title ("Parada 1").snippet ("DAE ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada2 = new LatLng ( 19.000278, -98.195222);
        mMap.addMarker (new MarkerOptions ().position (parada2).title ("Parada 2").snippet ("Cultura Fisica ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada3 = new LatLng (19.001164, -98.197227);
        mMap.addMarker (new MarkerOptions ().position (parada3).title ("Parada 3").snippet ("CALEE  ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada4 = new LatLng ( 19.001639, -98.199917);
        mMap.addMarker (new MarkerOptions ().position (parada4).title ("Parada 4").snippet ("Administración").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada5 = new LatLng (19.002833, -98.202500);
        mMap.addMarker (new MarkerOptions ().position (parada5).title ("Parada 5").snippet ("Electronica ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada6 = new LatLng (  19.002722, -98.203028);
        mMap.addMarker (new MarkerOptions ().position (parada6).title ("Parada 6").snippet ("Ingerieria ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada7 = new LatLng (19.003528, -98.204000);
        mMap.addMarker (new MarkerOptions ().position (parada7).title ("Parada 7").snippet ("Teatro al Aire Libre ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada8 = new LatLng ( 19.004778, -98.205139);
        mMap.addMarker (new MarkerOptions ().position (parada8).title ("Parada 2").snippet ("Computación/ PLU ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada9 = new LatLng (19.004972, -98.203556);
        mMap.addMarker (new MarkerOptions ().position (parada9).title ("Parada 9").snippet ("Laboratorios Ciencias Quimicas ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada10 = new LatLng ( 19.003917, -98.201750);
        mMap.addMarker (new MarkerOptions ().position (parada10).title ("Parada 10").snippet ("Instituto de Fisica ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada11 = new LatLng (19.003528, -98.200444);
        mMap.addMarker (new MarkerOptions ().position (parada11).title ("Parada 11").snippet ("Fisico Matemáticas").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada12 = new LatLng (19.002722, -98.198722);
        mMap.addMarker (new MarkerOptions ().position (parada12).title ("Parada 12").snippet ("Derecho ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada13 = new LatLng (19.000333, -98.194361);
        mMap.addMarker (new MarkerOptions ().position (parada13).title ("Parada 13").snippet ("Puerta1 / 24 Sur").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada14 = new LatLng ( 18.996294,-98.196146);
        mMap.addMarker (new MarkerOptions ().position (parada14).title ("Parada 14").snippet ("STU ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada15 = new LatLng (18.995917, -98.199667);
        mMap.addMarker (new MarkerOptions ().position (parada15).title ("Parada 15").snippet ("Unidad de Seminarios").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada16 = new LatLng (18.996528, -98.201889);
        mMap.addMarker (new MarkerOptions ().position (parada16).title ("Parada 16").snippet ("Biblioteca Central").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada17 = new LatLng (18.997611, -98.201917);
        mMap.addMarker (new MarkerOptions ().position (parada17).title ("Parada 17").snippet ("Multiaulas").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada18 = new LatLng (18.999122, -98.203940);
        mMap.addMarker (new MarkerOptions ().position (parada18).title ("Parada 18").snippet ("Contaduria").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

        LatLng parada19 = new LatLng (19.000748, -98.202552);
        mMap.addMarker (new MarkerOptions ().position (parada19).title ("Parada 19").snippet ("COMDE").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_GREEN)));

    }


}
