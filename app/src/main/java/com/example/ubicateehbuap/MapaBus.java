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

public class MapaBus extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner comboEdificiosOrigen,comboEdificiosDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mapa_bus);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                .findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);

        comboEdificiosOrigen = ( Spinner) findViewById (R.id.SpinnerOrigenBus);// Spinner de Peaton Origen
        comboEdificiosDestino = ( Spinner) findViewById (R.id.SpinnerDestinoBus);// Spinner de Peaton Origen

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource (this,R.array.comboEdificios,
                android.R.layout.simple_spinner_item); //Llama al contenido de opciones peaton de la carpeta values

        comboEdificiosOrigen.setAdapter(adapter);//Rellena los combos con el adaptador
        comboEdificiosDestino.setAdapter (adapter);
    }


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

        LatLng parada1 = new LatLng (18.998258, -98.195247);
        mMap.addMarker (new MarkerOptions ().position (parada1).title ("Parada 1").snippet ("DAE ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada2 = new LatLng ( 19.000170, -98.194580);
        mMap.addMarker (new MarkerOptions ().position (parada2).title ("Parada 2").snippet ("Cultura Fisica ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada3 = new LatLng (19.001902, -98.196329);
        mMap.addMarker (new MarkerOptions ().position (parada3).title ("Parada 3").snippet ("CALEE / Economia ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada4 = new LatLng ( 19.001410, -98.199313);
        mMap.addMarker (new MarkerOptions ().position (parada4).title ("Parada 4").snippet ("Derecho / Administración").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada5 = new LatLng (19.002381, -98.201440);
        mMap.addMarker (new MarkerOptions ().position (parada5).title ("Parada 5").snippet ("Rectoria / Fisico Matemáticas ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada6 = new LatLng (  19.003311, -98.203512);
        mMap.addMarker (new MarkerOptions ().position (parada6).title ("Parada 6").snippet ("Ingerierias Electronica / Arquitectura ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada7 = new LatLng (19.004452, -98.203604);
        mMap.addMarker (new MarkerOptions ().position (parada7).title ("Parada 7").snippet ("Acceso 14 sur / Computación ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada8 = new LatLng ( 19.004576, -98.202313);
        mMap.addMarker (new MarkerOptions ().position (parada8).title ("Parada 2").snippet ("Acceso 18 sur/ Fisico Matematica ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada9 = new LatLng (19.003465, -98.200106);
        mMap.addMarker (new MarkerOptions ().position (parada9).title ("Parada 9").snippet ("Acceso 22 sur / Fisico Matematicas ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada10 = new LatLng ( 19.003097, -98.198831);
        mMap.addMarker (new MarkerOptions ().position (parada10).title ("Parada 10").snippet ("Derecho / DGIE / Economia ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada11 = new LatLng (19.001957, -98.196368);
        mMap.addMarker (new MarkerOptions ().position (parada11).title ("Parada 11").snippet ("CALE").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada12 = new LatLng (19.001404, -98.195177);
        mMap.addMarker (new MarkerOptions ().position (parada12).title ("Parada 12").snippet ("Cultura Fisica").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada13 = new LatLng (18.998075, -98.195613);
        mMap.addMarker (new MarkerOptions ().position (parada13).title ("Parada 13").snippet ("DAE").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada14 = new LatLng ( 18.997048, -98.195980);
        mMap.addMarker (new MarkerOptions ().position (parada14).title ("Parada 14").snippet ("STU / Estadio / DAPI ").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada15 = new LatLng (18.996005, -98.199237);
        mMap.addMarker (new MarkerOptions ().position (parada15).title ("Parada 15").snippet ("Estadio / Seminarios / DASU").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada16 = new LatLng (18.996005, -98.199237);
        mMap.addMarker (new MarkerOptions ().position (parada16).title ("Parada 16").snippet ("Cultura Fisica").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada17 = new LatLng (18.995039, -98.200825);
        mMap.addMarker (new MarkerOptions ().position (parada17).title ("Parada 17").snippet ("DCyTIC / Secretaría Administrativa").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada18 = new LatLng (19.000016, -98.204290);
        mMap.addMarker (new MarkerOptions ().position (parada18).title ("Parada 18").snippet ("Contaduria/Polideportivo").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada19 = new LatLng (19.001004, -98.202993);
        mMap.addMarker (new MarkerOptions ().position (parada19).title ("Parada 19").snippet ("Ingenierias").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada20 = new LatLng ( 19.000721, -98.201505);
        mMap.addMarker (new MarkerOptions ().position (parada20).title ("Parada 20").snippet ("Biologia").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada21 = new LatLng (19.000226, -98.200367);
        mMap.addMarker (new MarkerOptions ().position (parada21).title ("Parada 21").snippet ("Canchas").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));

        LatLng parada22 = new LatLng ( 18.998705, -98.196847);
        mMap.addMarker (new MarkerOptions ().position (parada22).title ("Parada 22").snippet ("Jardín Botanico").icon(BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_BLUE)));



    }


}
