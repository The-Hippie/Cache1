package com.example.cache1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtContrasena;
    Button btnIniciar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String dataUser = "dataUser";
    public static final int nodo_private = Context.MODE_PRIVATE;

    String dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Necesito capturar los campos
        edtUsuario = findViewById(R.id.edtUsuario);
        btnIniciar = findViewById(R.id.btnIniciar);

        sharedPreferences = getSharedPreferences(dataUser, nodo_private);
        editor = sharedPreferences.edit();


        dato = getApplicationContext().getSharedPreferences(dataUser, nodo_private).getString("user", "0");

        if (!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(MainActivity.this, inicio.class);
            startActivity(i);
            finish();
        }


        btnIniciar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("user", edtUsuario.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this, inicio.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void btnIniciar(View view) {
    }
}