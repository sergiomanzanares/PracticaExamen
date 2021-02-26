package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragmento.CuandoPulseBotonListener {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.TVResultado);

        /*
        // Forma con el fragmentManager
        U6022_Fragmento headlinesFragment = (U6022_Fragmento) getSupportFragmentManager().findFragmentById(R.id.fragment_comm_id);
        headlinesFragment.estableceManejadorEvento(this);
        */
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        // Forma con el evento Attach de los fragmentos
        if (fragment instanceof Fragmento) {
            Fragmento headlinesFragment = (Fragmento) fragment;
            headlinesFragment.estableceManejadorEvento(this);
        }

    }

    @Override
    public void hanPulsadoElBoton(String mensaje) {
        // Hacer acción
        // estableceremos un mensaje en textView
        tv.setText(mensaje);
    }
}