package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityMemoriaInterna extends AppCompatActivity implements View.OnClickListener{

    EditText txtCedula, txtApellidos, txtNombres;
    Button btnLeer, btnEscribir;
    TextView lblDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_interna);
        txtCedula = findViewById(R.id.txtCedulaMI);
        txtApellidos = findViewById(R.id.txtApellidosMI);
        txtNombres = findViewById(R.id.txtNombresMI);
        btnLeer = findViewById(R.id.btnLeerMI);
        btnEscribir = findViewById(R.id.btnEscribirMI);
        lblDatos = findViewById(R.id.lblDatosMI);
        btnLeer.setOnClickListener(this);
        btnEscribir.setOnClickListener(this);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnEscribirMI:
                try {
                    OutputStreamWriter escritor = new OutputStreamWriter(openFileOutput("archivo.txt", Context.MODE_APPEND));
                    escritor.write(txtCedula.getText().toString() + " " + txtApellidos.getText().toString() + " " + txtNombres.getText().toString());
                    escritor.close();
                }catch (Exception ex){
                    Log.e("error escritura", ex.getMessage());
                }
                txtCedula.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                break;
            case  R.id.btnLeerMI:
                try {
                    BufferedReader lector = new BufferedReader(new InputStreamReader(openFileInput("archivo.txt")));
                    String info = lector.readLine();
                    lblDatos.setText(info);
                    lector.close();
                }catch (Exception ex){
                    Log.e("error lectura", ex.getMessage());
                }
                break;
            case R.id.btnEliminarMI:

                break;
        }
    }

}