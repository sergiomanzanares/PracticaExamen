package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Permisos extends AppCompatActivity {

    private static final int REQUEST_CODE = 0x00001;
    private static final int REQUEST_CODE2 = 0x00002;

    private Button BtnWeb;
    private Button BtnSms;
    private Button BtnDial;
    private Button BtnLlamar;
    private Button BtnOtro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);

        BtnWeb = findViewById(R.id.Web);
        BtnSms = findViewById(R.id.SMS);
        BtnDial = findViewById(R.id.Dial);
        BtnLlamar = findViewById(R.id.Llamar);
        BtnOtro = findViewById(R.id.Otro);

        BtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickWeb(v);
            }
        });

        BtnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSMS(v);
            }
        });

        BtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDial(v);
            }
        });

        BtnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCall(v);
            }
        });

        BtnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCamara(v);
            }
        });


    }

    public void clickWeb(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://developer.android.com"));
        startActivity(i);
    }

    public void clickSMS(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("sms:666666666"));
        i.putExtra("sms_body", "Ejemplo de cuerpo de mensaje");
        startActivity(i);
    }

    public void clickDial(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:666666666"));
        startActivity(i);
    }

    public void clickCall(View v){
        /*
        Intent i = new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:666666666"));
        startActivity(i);
        */

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:666666666"));
                startActivity(i);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, REQUEST_CODE);
                }
            }

    }

    public void clickCamara(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(i);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] { Manifest.permission.CAMERA }, REQUEST_CODE2);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                }  else {
                    //Toast.makeText(getApplicationContext(),"Permiso de llamada denegado", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
                }
                return;
            case REQUEST_CODE2:
                if (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                }  else {
                    //Toast.makeText(getApplicationContext(),"Permiso de camara denegado", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.CAMERA}, REQUEST_CODE2);
                }
                return;

        }

        // Other 'case' lines to check for other
        // permissions this app might request.
    }

}