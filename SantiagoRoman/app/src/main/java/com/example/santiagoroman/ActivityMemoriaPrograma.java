package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityMemoriaPrograma extends AppCompatActivity {

    Button btnLeer;
    TextView lblDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_programa);
        lblDatos = findViewById(R.id.lblDatosAMP);
        btnLeer = findViewById(R.id.btnLeerAMP);
        btnLeer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    InputStream input = getResources().openRawResource(R.raw.archivo_raw);
                    BufferedReader lector = new BufferedReader((new InputStreamReader(input)));
                    lblDatos.setText(lector.readLine());
                    lector.close();
                }catch (Exception ex){
                    Log.e("error lectura AMP", ex.getMessage());
                }
            }
        });
    }
}