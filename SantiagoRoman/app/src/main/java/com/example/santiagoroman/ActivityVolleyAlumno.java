package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.santiagoroman.controlador.sswVolley.ServicioWebVolley;
import com.example.santiagoroman.modelo.Alumno;

import org.json.JSONException;

public class ActivityVolleyAlumno extends AppCompatActivity  implements View.OnClickListener{

    EditText txtIdAlumno, txtNombres, txtDireccion;
    Button btnInsertar, btnBuscarTodos;
    TextView lblInfo;
    RecyclerView recyclerViewAlumno;

    ServicioWebVolley servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_alumno);
        cargarComponentes();
        servicio = new ServicioWebVolley(ActivityVolleyAlumno.this);
    }

    private void cargarComponentes(){
        txtIdAlumno = findViewById(R.id.txtIdAlumnosVolleyA);
        txtNombres = findViewById(R.id.txtNombresVolleyA);
        txtDireccion = findViewById(R.id.txtDireccionVolleyA);

        btnInsertar = findViewById(R.id.btnInsertarVolleyA);
        btnBuscarTodos = findViewById(R.id.btnBuscarTodosVolleyA);

        lblInfo = findViewById(R.id.lblDatosVolleyA);

        recyclerViewAlumno = findViewById(R.id.recyclerVolleyA);

        btnInsertar.setOnClickListener(this);
        btnBuscarTodos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsertarVolleyA:
                Alumno alumno = new Alumno();
                alumno.setNombre(txtNombres.getText().toString());
                alumno.setDireccion(txtDireccion.getText().toString());
                try {
                    boolean estado = servicio.insert(alumno);
                    if (estado){
                        Toast.makeText(this, "Alumno Registrado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Alumno No Registrado", Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
                break;
            case R.id.btnBuscarTodosVolleyA:
                break;
        }
    }
}