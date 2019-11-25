package com.example.ubicateehbuap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    ImageButton mapas, galeria ;
    ImageButton getGaleria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_inicio);

        mapas=(ImageButton)findViewById (R.id.btnMenuMapaInicio);
        getGaleria=(ImageButton)findViewById (R.id.btnGalerianicio);

        mapas.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Toast.makeText (Inicio.this,"Elija una opcion...",Toast.LENGTH_LONG).show ();
                Intent interntReg = new Intent(Inicio.this,OpcionesMapa.class);//llama de un activiti a otro
                Inicio.this.startActivity(interntReg);
            }
        });
        getGaleria.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

           Toast.makeText (Inicio.this,"A lado izquierdo encontrara opciones de \n" +
                   " las facultades que puede visitar \n" +
                   " y a su vez optiene informacion acerca \n " +
                   "de dicho edificio",Toast.LENGTH_LONG).show ();

                Intent interntReg = new Intent(Inicio.this,GaleriaBuap.class);//llama de un activiti a otro
                Inicio.this.startActivity(interntReg);
               // info();
            }
        });
    }/*
    private void info(){
        AlertDialog.Builder notificacion = new AlertDialog.Builder(this);
        notificacion.setTitle("Informacion");
        notificacion.setMessage("A lado izquierdo encontrara opciones de \n las facultades que puede visitar \n y a su vez optiene informacion acerca \n de dicho edificio");
        notificacion.setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        notificacion.show();
    }*/
}
