package com.example.practicaexamen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento extends Fragment {

    public Fragmento () {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento, container, false);
        v.findViewById(R.id.BotomSumar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                botonPulsado(view);
            }
        });
        return v;
    }

    int i = 0;
    public void botonPulsado(View v){
        if(elManejador != null) elManejador.hanPulsadoElBoton("Pulsado" + i++);
    }

    public interface CuandoPulseBotonListener {
        public void hanPulsadoElBoton(String mensaje); // String o cualquier cosa
    }

    CuandoPulseBotonListener elManejador;

    public void estableceManejadorEvento(CuandoPulseBotonListener manejador){
        elManejador = manejador;
    }

}