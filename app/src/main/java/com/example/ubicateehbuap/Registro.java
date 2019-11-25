package com.example.ubicateehbuap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    EditText Nombre,mail,user,password;
    Button reg;
    private ProgressDialog progressDialog;
    ///VARIABLES DE LOS DATOS DEL USUARIO A REGISTRA
    private  String name = "";
    private  String email = "";
    private  String passw  = "";
    //Declarar objeto FIREBASE
    FirebaseAuth mAuth ;
    DatabaseReference mDataBase; // Instancia del obejeto de la base de datos para almacenar mas informacion  del usuario


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance (); //Obtiene instancia del objeto
        mDataBase = FirebaseDatabase.getInstance ().getReference ();
        progressDialog = new ProgressDialog (this);
        Nombre=(EditText) findViewById (R.id.edt_nombre);
        mail = (EditText) findViewById (R.id.edt_correo);
        password =( EditText) findViewById (R.id.edt_Password);
        reg = (Button) findViewById (R.id.btnRegistro);

        reg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                name= Nombre.getText ().toString ();
                email=mail.getText ().toString ();
                passw=password.getText ().toString ();

                if(!name.isEmpty () && !email.isEmpty () && !passw.isEmpty ()){
                    if( passw.length()>=6){
                        RegUsuario();
                    }else{
                        Toast.makeText (Registro.this,"La contraseña debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show ();
                    }
                }
                else{
                    Toast.makeText (Registro.this,"Campos incompletos",Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }

    private void RegUsuario(){
        mAuth.createUserWithEmailAndPassword (email,passw).addOnCompleteListener (new OnCompleteListener<AuthResult> () {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful ()){
                    Map<String, Object> map = new HashMap<> ();
                    map.put("usuario",name);
                    map.put("email",mail);
                    map.put("password",passw);
                    String id = mAuth.getCurrentUser ().getUid ();

                    progressDialog.setMessage("Realizando registro, espere porfavor...");
                    progressDialog.show ();

                    startActivity(new Intent (Registro.this,MainActivity.class));
                    Toast notificacion=Toast.makeText(Registro.this,"Datos almacenados correctamente",Toast.LENGTH_LONG);

                }else{
                    Toast.makeText (Registro.this,"No se pudo registrar el usuario",Toast.LENGTH_LONG).show ();
                    Toast.makeText (Registro.this,"Es probable que el usuario ya se encuentra registrado.",Toast.LENGTH_LONG).show ();
                    Toast.makeText (Registro.this,"Intente Nuevamente.",Toast.LENGTH_LONG).show ();
                    startActivity(new Intent (Registro.this,Registro.class));
                }
            }
        });

    }
}
