package com.example.practicaexamen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.view.ViewGroup.LayoutParams;



public class Formulario extends Activity {

    TextView textoSpiner;
    private AlertDialog dialog;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);


        //Toast
        Button botonToast = findViewById(R.id.BotonFormulario);
        botonToast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Enviado", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        //CheckBox
        CheckBox box = findViewById(R.id.CBFormulario);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    buttonView.setText("Marcado");
                else
                    buttonView.setText("Desmarcado");
            }
        });

        //RadioGroup
        RadioGroup radioGroup = findViewById(R.id.RGFormulario);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton boton = (RadioButton) findViewById(checkedId);
                boton.setText("Marcado");
            }
        });



        //Spiner
        class ItemSeleccionado implements AdapterView.OnItemSelectedListener {
            public void onItemSelected(AdapterView<?> parent, View view, int
                    position, long id) {
                textoSpiner.setText("Seleccionado " +
                        parent.getItemAtPosition(position).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        }

        textoSpiner = findViewById(R.id.TVSpiner);
        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Lunes");
        adapter.add("Martes");
        adapter.add("Miércoles");
        adapter.add("Jueves");
        adapter.add("Viernes");
        adapter.add("Sábado");
        adapter.add("Domingo");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new ItemSeleccionado());


        //Dialog
        Button botonDialog = findViewById(R.id.BtnDialog);
        botonDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Botón pulsado");
                CharSequence texto = "Pulsado";
                builder.setMessage(texto);
                builder.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setNeutralButton("Despues", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog = builder.create();
                dialog.show();
            }
        });

        //Switcher
        final ViewSwitcher viewSwitcher = new ViewSwitcher(this);

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        viewSwitcher.setInAnimation(in);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        viewSwitcher.setOutAnimation(out);

        Button botonSwitcher = findViewById(R.id.BtnSwitcher);
        botonSwitcher.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(viewSwitcher.getDisplayedChild() > 0)
                            viewSwitcher.showPrevious();
                        else
                            viewSwitcher.showNext();
                    }
                }
        );

        /*
        Button boton1 = findViewById(R.id.BtnSwitcher1);
        Button boton2 = findViewById(R.id.BtnSwitcher2);

        viewSwitcher.addView(boton1, -1, new LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        viewSwitcher.addView(boton2, -1, new LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        */

    }
}
