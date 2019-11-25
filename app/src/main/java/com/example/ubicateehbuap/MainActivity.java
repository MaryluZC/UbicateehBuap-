package com.example.ubicateehbuap;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    TextView registro;
    Button entrar,ver;
    EditText correo, pass;
    //Variables FireBase
    FirebaseAuth mAuth ;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        registro=(TextView) findViewById (R.id.tv_registro);
        entrar=(Button) findViewById (R.id.btnEntrar);
        ver=(Button) findViewById (R.id.btnVer);
        correo = (EditText) findViewById (R.id.edt_Correo);
        pass = (EditText) findViewById (R.id.edt_password);
        mAuth = FirebaseAuth.getInstance ();//Instancia de Fire Base4
        progressDialog = new ProgressDialog (this);

        ver.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent interntReg = new Intent(MainActivity.this,Inicio.class);//llama de un activiti a otro
                MainActivity.this.startActivity(interntReg);
                Toast.makeText (MainActivity.this,"En la opcion Mapas encontraras opciones que te " +
                        "mostraran \n puntos diferentes de llegar a tu destino. ",Toast.LENGTH_SHORT).show ();
                Toast.makeText (MainActivity.this,"En la opcion Galeria encontraras " +
                        "fotografias de los distintos edificios de C.U con informacion que te puede ser" +
                        "útil",Toast.LENGTH_LONG).show ();
            }
        });
        entrar.setOnClickListener(new View.OnClickListener() { //acciona el clic
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                //--------------------------
                String mail = correo.getText ().toString ();
                String contr= pass.getText ().toString ();

                if(mail.isEmpty ()){
                    correo.setError("Por favor ingrese su correo");
                    correo.requestFocus ();
                }
                else if(contr.isEmpty ()){
                    pass.setError ("Ingrese su contraseña");
                    pass.requestFocus ();
                }
                else if(mail.isEmpty () && contr.isEmpty ()){
                    Toast.makeText (MainActivity.this,"Campos vacios!",Toast.LENGTH_SHORT).show ();
                }

                else if(!(mail.isEmpty () && contr.isEmpty ())){
                    mAuth.signInWithEmailAndPassword (mail,contr).addOnCompleteListener (MainActivity.this, new OnCompleteListener<AuthResult> () {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful ()){
                                progressDialog.setMessage("Registrando...");
                                progressDialog.show ();
                                Toast.makeText (MainActivity.this,"\"Bienvenido a Ubicateeh! BUAP\\n\" +\n" +
                                        "                \"En la opcion Mapas encontrará opciones que le mostraran\\n\" +\n" +
                                        "                \"puntos diferentes de llegar a su destino.\\n\\n\" +\n" +
                                        "                \"En la opcion Galeria encontrará fotografias de los\\n\" +\n" +
                                        "                \"distintos edificios de C.U con informacion que le puede ser\\n\" ",Toast.LENGTH_LONG).show ();

                                Intent interntReg = new Intent(MainActivity.this,Inicio.class);//llama de un activiti a otro
                                MainActivity.this.startActivity(interntReg);
                                finish ();

                            }else if(!task.isSuccessful ()){
                                Toast notificacion=Toast.makeText(MainActivity.this,"Error! Intente nuevamente",Toast.LENGTH_SHORT);
                                Toast.makeText (MainActivity.this,"Verifique que su correo y contraseña no tenga espacios.",Toast.LENGTH_LONG).show ();
                                notificacion.show();
                                task.getException() ;
                            }
                            progressDialog.setMessage("Espere un momento...");
                            progressDialog.show ();
                        }
                    });
                }
                else{
                    Toast.makeText (MainActivity.this,"Ha ocurrido un ERROR!!!",Toast.LENGTH_SHORT).show ();
                    Toast.makeText (MainActivity.this,"Verifique que su correo y contraseña no tenga espacios.",Toast.LENGTH_LONG).show ();
                }
            }
        });



        registro.setOnClickListener(new View.OnClickListener() { //acciona el clic
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Cargando...");
                progressDialog.show ();
                Intent interntReg = new Intent(MainActivity.this,Registro.class);//llama de un activiti a otro
                MainActivity.this.startActivity(interntReg);
                Toast.makeText (MainActivity.this,"Por favor ingrese sus datos en cada uno de los campos",Toast.LENGTH_LONG).show ();
            }
        });
    }
   /* private void info(){

        AlertDialog.Builder notificacion = new AlertDialog.Builder(this);
        notificacion.setTitle("Informacion");
        notificacion.setMessage("Bienvenido a Ubicateeh! BUAP\n" +
                "En la opcion Mapas encontrará opciones que le mostraran\n" +
                "puntos diferentes de llegar a su destino.\n\n" +
                "En la opcion Galeria encontrará fotografias de los\n" +
                "distintos edificios de C.U con informacion que le puede ser\n"
        );
        notificacion.setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        notificacion.show();

    }*/

}
