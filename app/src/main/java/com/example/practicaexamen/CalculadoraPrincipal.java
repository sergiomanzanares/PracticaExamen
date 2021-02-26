package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraPrincipal extends AppCompatActivity {

    TextView n1;
    TextView op;
    TextView n2;
    Button b1;
    Button btnOp;
    Button b2;
    TextView r;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        String textoRespuesta;
        if(resultCode == RESULT_CANCELED)
            textoRespuesta = "No hay respuesta";
        else
            textoRespuesta = data.getStringExtra("cadena respuesta");

        if (requestCode == 1) {
            n1.setText(textoRespuesta);
        } else if (requestCode == 2) {
            n2.setText(textoRespuesta);
        } else if (requestCode == 0) {
            r.setText(textoRespuesta);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_principal);

        n1 = findViewById(R.id.n1);
        op = findViewById(R.id.operacion);
        n2 = findViewById(R.id.n2);
        r = findViewById(R.id.resultado);

        b1 = findViewById(R.id.btnNumero1);
        b2 = findViewById(R.id.btnNumero2);
        btnOp = findViewById(R.id.btnOperacion);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = "Pulsado boton numero 1";
                n1.setText(cadena);
                Intent i = new Intent(getApplicationContext(), CalculadoraNumeros.class);
                i.putExtra("cadena", cadena);
                startActivityForResult(i, 1);
            }
        });

        

    }
}