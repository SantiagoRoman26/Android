package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityMemoriaExterna extends AppCompatActivity implements View.OnClickListener{

    EditText txtCedula, txtApellidos, txtNombres;
    Button btnLeer, btnEscribir;
    TextView lblDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_externa);

        txtCedula = findViewById(R.id.txtCedulaME);
        txtApellidos = findViewById(R.id.txtApellidosME);
        txtNombres = findViewById(R.id.txtNombresME);
        btnLeer = findViewById(R.id.btnLeerME);
        btnEscribir = findViewById(R.id.btnEscribirME);
        lblDatos = findViewById(R.id.lblDatosME);
        btnLeer.setOnClickListener(this);
        btnEscribir.setOnClickListener(this);
    }

    public void onClick(View v){
        String nombreArchivo = "info";
        switch (v.getId()){
            case R.id.btnEscribirME:
                try {
                    File file = new  File(getExternalFilesDir(null), nombreArchivo);
                    OutputStreamWriter osw = new OutputStreamWriter(
                            new FileOutputStream(file));
                    osw.write("[" + txtCedula.getText().toString() + "] ["+ txtNombres.getText().toString() + "] [" + txtApellidos.getText().toString() +  "]");
                    osw.flush();
                    osw.close();
                    Toast.makeText(this, "Los datos fueron grabados correctamente",
                            Toast.LENGTH_SHORT).show();
                    txtApellidos.setText("");
                    txtNombres.setText("");
                    txtCedula.setText("");
                } catch (IOException ioe) {
                    Toast.makeText(this, "No se pudo grabar",
                            Toast.LENGTH_SHORT).show();
                }

                break;
            case  R.id.btnLeerME:
                File file =new  File(getExternalFilesDir(null), nombreArchivo);
                try {
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader archivo = new InputStreamReader(fIn);
                    BufferedReader br = new BufferedReader(archivo);
                    String linea = br.readLine();
                    String todo = "";
                    while (linea != null) {
                        todo = todo + linea + " ";
                        linea = br.readLine();
                    }
                    br.close();
                    archivo.close();
                    lblDatos.setText(todo);
                } catch (IOException e) {
                    Toast.makeText(this, "No se pudo leer",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEliminarMI:

                break;
        }
    }

}