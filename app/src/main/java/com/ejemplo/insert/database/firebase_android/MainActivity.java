package com.ejemplo.insert.database.firebase_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText usuario,correo,edad;
Button guardar;
//FirebaseAuth auth;//ES INPORTANTE DECLARAR LA VAIABLE FIREBASE AUTH
    DatabaseReference databaseReference;//Hacer referecnia a la base de datos de firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    auth=FirebaseAuth.getInstance();//ES INPORTANTE DECLARAR LA INSTANCIA

        databaseReference= FirebaseDatabase.getInstance().getReference();//IMPORTANTE DECLARAR LAS INSTANCIAS PARA INICALIZAR!
        setView();

    }

    private void setView() {
        usuario=(EditText)findViewById(R.id.usuario);
        correo=(EditText)findViewById(R.id.correo);
        edad=(EditText)findViewById(R.id.edad);
        guardar=(Button) findViewById(R.id.guardar);

        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String user=usuario.getText().toString();
                String mail=correo.getText().toString();
                String age=edad.getText().toString();

                //Se crea el objeto para guardar las referencias de los valres USUARIO
                User user1=new User(user, Integer.valueOf(age),mail);

                //en realidad estas guardand oun objeto
                //En la referencia "usuarios" has del nodo principal a "user"..con los valores de user1
                databaseReference.child("usuarios").child(user).setValue(user1);

            }
        });

    }


}
