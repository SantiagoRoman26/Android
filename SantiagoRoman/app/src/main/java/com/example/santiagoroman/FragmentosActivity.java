package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentosActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonFrg1, botonFrg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentos);
        botonFrg1 = findViewById(R.id.btnFrg1);
        botonFrg2 = findViewById(R.id.btnFrg2);
        botonFrg1.setOnClickListener(this);
        botonFrg2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFrg1:
                FrgUno fragmentoUno = new FrgUno();
                FragmentTransaction transactionUno = getSupportFragmentManager().beginTransaction();
                transactionUno.replace(R.id.contenedor, fragmentoUno);
                transactionUno.commit();
                break;
            case R.id.btnFrg2:
                FrgDos fragmentoDos = new FrgDos();
                FragmentTransaction transactionDos = getSupportFragmentManager().beginTransaction();
                transactionDos.replace(R.id.contenedor, fragmentoDos);
                transactionDos.commit();
                break;
            default:
        }
    }
}