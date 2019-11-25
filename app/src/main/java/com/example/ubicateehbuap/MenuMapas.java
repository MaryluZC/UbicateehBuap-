package com.example.ubicateehbuap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MenuMapas extends AppCompatActivity {
    ImageButton caminando,bici,bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu_mapas);

        caminando= (ImageButton) findViewById (R.id.btnCaminando);
        bici= (ImageButton) findViewById (R.id.btnBici);
        bus= (ImageButton) findViewById (R.id.btnBus);

        caminando.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MenuMapas.this,"Mapa peatonal Ubicateeh! BUAP",Toast.LENGTH_SHORT).show ();
                Intent interntReg = new Intent(MenuMapas.this, Mapa.class);//llama de un activiti a otro
                MenuMapas.this.startActivity(interntReg);
            }
        });
    }
}
