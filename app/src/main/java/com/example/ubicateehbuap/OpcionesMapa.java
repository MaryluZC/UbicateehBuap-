package com.example.ubicateehbuap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class OpcionesMapa extends AppCompatActivity {
    ImageButton mapacaminar,mapabici,mapabus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_opciones_mapa);
        mapacaminar = (ImageButton)findViewById (R.id.btnCaminarOpcMap);
        mapabici = (ImageButton)findViewById (R.id.btnBiciOpcMap);
        mapabus = (ImageButton)findViewById (R.id.btnBusOpcMap);
        mapacaminar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Toast.makeText (OpcionesMapa.this,"Mapa Peatonal Ubicateeh! BUAP",Toast.LENGTH_SHORT).show ();
                Toast.makeText (OpcionesMapa.this,"Presione el circulo que se encuentra\n" +
                        "en la parte superior derecha para \n" +
                        "que puedas saber donde se encuentra.",Toast.LENGTH_LONG).show ();
                Intent interntReg = new Intent(OpcionesMapa.this,Mapa.class);//llama de un activiti a otro
                OpcionesMapa.this.startActivity(interntReg);
            }
        });
        /*******--------------------------------------------------------------******/
        mapabici.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (OpcionesMapa.this,"Mapa LoboBici Ubicateeh! BUAP",Toast.LENGTH_SHORT).show ();
                Toast.makeText (OpcionesMapa.this,"Presione el circulo que se encuentra\n" +
                        "en la parte superior derecha para \n" +
                        "que puedas saber donde se encuentra.",Toast.LENGTH_LONG).show ();
                Intent interntReg = new Intent(OpcionesMapa.this,MapaBici.class);//llama de un activiti a otro
                OpcionesMapa.this.startActivity(interntReg);

            }
        });
        mapabus.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (OpcionesMapa.this,"Mapa LoboBici Ubicateeh! BUAP",Toast.LENGTH_SHORT).show ();
                Toast.makeText (OpcionesMapa.this,"Presione el circulo que se encuentra\n" +
                        "en la parte superior derecha para \n" +
                        "que puedas saber donde se encuentra.",Toast.LENGTH_LONG).show ();
                Intent interntReg = new Intent(OpcionesMapa.this,MapaBus.class);//llama de un activiti a otro
                OpcionesMapa.this.startActivity(interntReg);

            }
        });
    }
}
