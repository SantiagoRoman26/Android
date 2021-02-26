package com.example.santiagoroman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NombresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombres);
        TextView lblNombres = findViewById(R.id.lblNombres);
        TextView lblApellidos = findViewById(R.id.lblApellidos);
        Bundle bundle = this.getIntent().getExtras();
        lblNombres.setText(bundle.getString("nombres"));
        lblApellidos.setText(bundle.getString("apellidos"));
    }
}