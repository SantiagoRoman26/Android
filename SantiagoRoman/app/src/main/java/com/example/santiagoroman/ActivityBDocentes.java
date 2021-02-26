package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.santiagoroman.adapter.DocenteAdapter;
import com.example.santiagoroman.helper.HelperBDocente;
import com.example.santiagoroman.modelo.Docente;

import java.util.ArrayList;
import java.util.List;

public class ActivityBDocentes extends AppCompatActivity implements View.OnClickListener{

    EditText txtCedula, txtApellidos, txtNombres;
    Button btnGuardar, btnModificar, btnEliminarUno, btnEliminarTodos, btnBuscarUno, btnBuscarTodos;
    TextView lblInfo;

    HelperBDocente helper;

    RecyclerView recyclerView;
    List<Docente> lista;
    DocenteAdapter docenteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_docentes);
        cargarComponentes();

        helper = new HelperBDocente(this, "Academia", null, 1);
        lista = new ArrayList<Docente>(); //esta lista esta vacia
        lista = helper.mostrarTodosList();// se rellena la lista con todos los docentes
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //setear el layout
        docenteAdapter = new DocenteAdapter(lista);//fijando el numero de items
        //cargar el recyclerView
    }

    private void cargarComponentes(){
        txtCedula = findViewById(R.id.txtCedulaBD);
        txtApellidos = findViewById(R.id.txtApellidosBD);
        txtNombres = findViewById(R.id.txtNombresBD);
        btnGuardar = findViewById(R.id.btnGuardarBD);
        btnModificar = findViewById(R.id.btnModificarBD);
        btnEliminarUno = findViewById(R.id.btnEliminarUnoBD);
        btnEliminarTodos = findViewById(R.id.btnEliminarTodosBD);
        btnBuscarUno = findViewById(R.id.btnBuscarUnoBD);
        btnBuscarTodos = findViewById(R.id.btnBuscarTodosBD);

        lblInfo = findViewById(R.id.lblInfoBD);

        recyclerView = findViewById(R.id.recyclerDocente);

        btnGuardar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        btnEliminarUno.setOnClickListener(this);
        btnEliminarTodos.setOnClickListener(this);
        btnBuscarUno.setOnClickListener(this);
        btnBuscarTodos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Docente docente = new Docente();
        switch (v.getId()){
            case R.id.btnGuardarBD:
                    docente.setCedula(txtCedula.getText().toString());
                    docente.setApellidos(txtApellidos.getText().toString());
                    docente.setNombres(txtNombres.getText().toString());
                    helper.insertar(docente);
                    limpiar();
                    break;
            case R.id.btnModificarBD:
                    docente.setCedula(txtCedula.getText().toString());
                    docente.setApellidos(txtApellidos.getText().toString());
                    docente.setNombres(txtNombres.getText().toString());
                    helper.modificar(docente);
                    limpiar();
                    break;
            case R.id.btnEliminarUnoBD:
                    helper.eliminarUno(txtCedula.getText().toString());
                break;
            case R.id.btnEliminarTodosBD:
                    helper.eliminarTodos();
                break;
            case R.id.btnBuscarUnoBD:
                    lblInfo.setText(helper.mostrarUno(txtCedula.getText().toString()));
                break;
            case R.id.btnBuscarTodosBD:
                    lblInfo.setText(helper.mostrarTodos());
                break;

        }
    }

    private void limpiar(){
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
    }

}