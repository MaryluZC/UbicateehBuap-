package com.example.ubicateehbuap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {
 private GoogleMap mMap;
 Spinner comboEdificiosOrigen, comboEdificiosDestino;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate (savedInstanceState);
  setContentView (R.layout.activity_mapa);
  SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ().findFragmentById (R.id.map);
  mapFragment.getMapAsync (this);

  comboEdificiosOrigen = (Spinner) findViewById (R.id.SpinnerOrigenPeaton);// Spinner de Peaton Origen
  comboEdificiosDestino = (Spinner) findViewById (R.id.SpinnerDestinoPeaton);// Spinner de Peaton Origen

  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource (this, R.array.comboEdificios,
          android.R.layout.simple_spinner_item); //Llama al contenido de opciones peaton de la carpeta values

  comboEdificiosOrigen.setAdapter (adapter);//Rellena los combos con el adaptador
  comboEdificiosDestino.setAdapter (adapter);
  //RECONOCIMIENTO DE SELECCION EN EL COMBOBOX
/*  comboEdificiosOrigen.setOnItemClickListener (new AdapterView.OnItemClickListener () {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText (getApplicationContext (),"Seleccionado: "+ parent.getItemAtPosition (position).toString (),Toast.LENGTH_LONG).show();
    //int posicionItem = (int) parent.getItemIdAtPosition ();


   }
   public  void onNothingSelected(AdapterView<?> parent){

   }
  });*/

  /*reconoceItemDestino ();
*/
 }

 @Override
 public void onMapReady(GoogleMap googleMap) {
  mMap = googleMap;
  if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
   return;
  }
  mMap.setMyLocationEnabled (true);
  //Create a LatLngBounds that includes the city of Buap.
  LatLng buapCenter = new LatLng (18.999835, -98.200222);
  LatLngBounds buap = new LatLngBounds (new LatLng (18.993126, -98.205660), new LatLng (19.006718, -98.194199));

  // Move the camera instantly to Sydney with a zoom of 15.
  mMap.moveCamera (CameraUpdateFactory.newLatLngZoom (buapCenter, 15));
  // Zoom in, animating the camera.
  mMap.animateCamera (CameraUpdateFactory.zoomIn ());
  // Zoom out to zoom level 10, animating with a duration of 2 seconds.
  mMap.animateCamera (CameraUpdateFactory.zoomTo (10), 2000, null);
  // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
  CameraPosition cameraPosition = new CameraPosition.Builder ()
          .target (buapCenter)      // Sets the center of the map to Mountain View
          .zoom (15)                   // Sets the zoom
          .bearing (90)                // Sets the orientation of the camera to east
          .tilt (30)                   // Sets the tilt of the camera to 30 degrees
          .build ();                   // Creates a CameraPosition from the builder
  mMap.animateCamera (CameraUpdateFactory.newCameraPosition (cameraPosition));

  LatLng compu = new LatLng (19.005106, -98.204657);
  mMap.addMarker (new MarkerOptions ().position (compu).title ("Computación").snippet ("Edificios: CCO1, CCO2,CCO3, CCO4"));

  LatLng arquitectura = new LatLng (19.001801, -98.204422);
  mMap.addMarker (new MarkerOptions ().position (arquitectura).title ("Arquitectura").snippet ("Edificios: "));

  LatLng culturafisica = new LatLng (19.000945, -98.195038);
  mMap.addMarker (new MarkerOptions ().position (culturafisica).title ("Cultura Fisica").snippet ("Edificios:"));

  LatLng estadio = new LatLng (18.997159, -98.197404);
  mMap.addMarker (new MarkerOptions ().position (estadio).title ("Estadio Olimpico BUAP"));

  LatLng contabilidad = new LatLng (18.999550, -98.204686);
  mMap.addMarker (new MarkerOptions ().position (contabilidad).title ("Contabilidad BUAP"));

  LatLng polideportivo = new LatLng (19.000139, -98.203899);
  mMap.addMarker (new MarkerOptions ().position (polideportivo).title ("Polideportivo BUAP"));

  LatLng estadiobeisbol = new LatLng (18.998761, -98.202894);
  mMap.addMarker (new MarkerOptions ().position (estadiobeisbol).title ("Estadio de Beisbol BUAP"));

  LatLng hospitalveterinario = new LatLng (18.997304, -98.203089);
  mMap.addMarker (new MarkerOptions ().position (hospitalveterinario).title ("Hospital Veterinario BUAP"));

  LatLng emma4 = new LatLng (18.997246, -98.202248);
  mMap.addMarker (new MarkerOptions ().position (emma4).title ("Edifio Multiaulas 4 BUAP"));

  LatLng emma5 = new LatLng (18.996822, -98.202297);
  mMap.addMarker (new MarkerOptions ().position (emma5).title ("Edifio Multiaulas 5 BUAP"));

  LatLng bibliotecacentral = new LatLng (18.996179, -98.201708);
  mMap.addMarker (new MarkerOptions ().position (bibliotecacentral).title ("Biblioteca Central BUAP"));

  LatLng circuloinfantil = new LatLng (18.995071, -98.201809);
  mMap.addMarker (new MarkerOptions ().position (circuloinfantil).title ("Circulo Infantil BUAP"));

  LatLng DirecciónGeneralCmputo = new LatLng (18.994961, -98.200840);
  mMap.addMarker (new MarkerOptions ().position (DirecciónGeneralCmputo).title ("Dirección General de Cómputo BUAP"));

  LatLng DirecciónApoyoySeguridad = new LatLng (18.995665, -98.200138);
  mMap.addMarker (new MarkerOptions ().position (DirecciónApoyoySeguridad).title ("Dirección de Apoyo y Seguridad BUAP"));

  LatLng UnidadSeminarios = new LatLng (18.995708, -98.199269);
  mMap.addMarker (new MarkerOptions ().position (UnidadSeminarios).title ("Unidad de Seminarios BUAP"));

  LatLng Comde = new LatLng (19.000182, -98.202316);
  mMap.addMarker (new MarkerOptions ().position (Comde).title ("COMDE BUAP"));

  LatLng TiendaBuap = new LatLng (18.998357, -98.197034);
  mMap.addMarker (new MarkerOptions ().position (TiendaBuap).title ("Tienda BUAP"));

  LatLng Stu = new LatLng (18.996979, -98.195660);
  mMap.addMarker (new MarkerOptions ().position (Stu).title ("Sistema de Transporte Universitario BUAP"));

  LatLng Antropologia = new LatLng (18.997741, -98.195374);
  mMap.addMarker (new MarkerOptions ().position (Antropologia).title ("Colegio de antropologia BUAP"));

  LatLng Dae = new LatLng (18.998428, -98.194856);
  mMap.addMarker (new MarkerOptions ().position (Dae).title ("Direccion de Administracion Escolar BUAP"));

  LatLng DITco = new LatLng (18.998851, -98.194770);
  mMap.addMarker (new MarkerOptions ().position (DITco).title ("Centro Universitario de Vinculación y Transferencia de Tecnología BUAP"));

  LatLng JardinBotanico = new LatLng (19.000566, -98.198602);
  mMap.addMarker (new MarkerOptions ().position (JardinBotanico).title ("Jardin Botanico BUAP"));

  LatLng CesFi = new LatLng (19.000510, -98.195216);
  mMap.addMarker (new MarkerOptions ().position (CesFi).title ("CeSFI Edificio de Laboratorios de La Facultad de Cultura Física BUAP"));

  LatLng Icuap = new LatLng (19.001320, -98.195891);
  mMap.addMarker (new MarkerOptions ().position (Icuap).title ("Centro De Investigaciones Microbiologicas BUAP"));

  LatLng Calee = new LatLng (19.001676, -98.196473);
  mMap.addMarker (new MarkerOptions ().position (Calee).title ("Centro de Autoacceso para el Aprendizaje de Lenguas Extranjeras BUAP"));

  LatLng Dau = new LatLng (19.001398, -98.196705);
  mMap.addMarker (new MarkerOptions ().position (Dau).title ("Dirección de Acompañamiento Universitario Buap"));

  LatLng Cedes = new LatLng (19.001267, -98.197614);
  mMap.addMarker (new MarkerOptions ().position (Cedes).title ("Centro de Estudios del Desarrollo Económico y Social CEDES BUAP"));

  LatLng Economia = new LatLng (19.001934, -98.197501);
  mMap.addMarker (new MarkerOptions ().position (Economia).title ("Facultad de Economia Buap"));

  LatLng PosGradoDerecho = new LatLng (19.001440, -98.198563);
  mMap.addMarker (new MarkerOptions ().position (PosGradoDerecho).title ("Auditorio de PosGrado Facultad de Derecho Buap"));

  LatLng Derecho = new LatLng (19.002669, -98.199015);
  mMap.addMarker (new MarkerOptions ().position (Derecho).title ("Facultad de Derecho y Ciencias Sociales Buap"));

  LatLng Administracion = new LatLng (19.002316, -98.200053);
  mMap.addMarker (new MarkerOptions ().position (Administracion).title ("Facultad de Administración Buap"));

  LatLng Maxcom = new LatLng (19.002012, -98.204369);
  mMap.addMarker (new MarkerOptions ().position (Maxcom).title ("MAXCOM Telecomunicaciones Buap"));

  LatLng Monja = new LatLng (19.002449, -98.204461);
  mMap.addMarker (new MarkerOptions ().position (Monja).title ("Centro Cultural la Monja Buap"));

  LatLng Ingenieria = new LatLng (19.001835, -98.203018);
  mMap.addMarker (new MarkerOptions ().position (Ingenieria).title ("Facultad de Ingenieria Buap"));

  LatLng PosgradoIngenieria = new LatLng (19.002110, -98.203491);
  mMap.addMarker (new MarkerOptions ().position (PosgradoIngenieria).title ("Auditorio de Posgrado Facultad de Ingenieria Buap"));

  LatLng Icuap1 = new LatLng (19.001351, -98.200877);
  mMap.addMarker (new MarkerOptions ().position (Icuap1).title ("Centro de Quimica ICUAP Buap"));

  LatLng Adsorcion = new LatLng (19.001376, -98.200675);
  mMap.addMarker (new MarkerOptions ().position (Adsorcion).title ("Laboratorio de Adsorcion y cromatografia Buap"));

  LatLng CienciasQuimicas = new LatLng (19.001924, -98.201126);
  mMap.addMarker (new MarkerOptions ().position (CienciasQuimicas).title ("Facultad de Ciencias Quimicas BUAP"));

  LatLng BibliotecaAdmin = new LatLng (19.002622, -98.200311);
  mMap.addMarker (new MarkerOptions ().position (BibliotecaAdmin).title ("Biblioteca Especializada Facultad De Administración BUAP"));

  LatLng CienciasFisiMate = new LatLng (19.003492, -98.201037);
  mMap.addMarker (new MarkerOptions ().position (CienciasFisiMate).title ("  Facultad de Ciencias Fisico Matemáticas BUAP"));
 }


}


