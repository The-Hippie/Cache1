package com.example.cache1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inicio extends AppCompatActivity {

    public static final String dataUser = "dataUser";
    public static final int nodo_private = Context.MODE_PRIVATE;

    TextView txtUsuario;
    Button btnCerrarSesion;
    String dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        txtUsuario = findViewById(R.id.txtUsuario);

        dato = getApplicationContext().getSharedPreferences(dataUser,nodo_private).getString("user", "0");


        if (!dato.equals("0")){
            txtUsuario.setText(dato);
        }else{
            txtUsuario.setText("no hay informacion");
        }

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion = getApplicationContext().getSharedPreferences(dataUser,nodo_private);
                configuracion.edit().clear().commit();
                Intent i = new Intent(inicio.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void btnCerrar(View view) {
    }
}