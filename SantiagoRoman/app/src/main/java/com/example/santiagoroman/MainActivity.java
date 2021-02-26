package com.example.santiagoroman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtNombres = findViewById(R.id.txtNombres);
        EditText txtApellidos = findViewById(R.id.txtApellidos);
        Button boton = findViewById(R.id.btnIngresar);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NombresActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nombres",txtNombres.getText().toString());
                bundle.putString("apellidos",txtApellidos.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.main, menu);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionFragmentos:
                intent = new Intent(MainActivity.this, FragmentosActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionDialogos:
                Dialog dialogoLogin = new Dialog(MainActivity.this);
                dialogoLogin.setContentView(R.layout.dlg_login);

                EditText txtUser = dialogoLogin.findViewById(R.id.txtUsuarioDlg);
                EditText txtPassword = dialogoLogin.findViewById(R.id.txtClaveDlg);
                Button botonDlg = dialogoLogin.findViewById(R.id.btnIngresarDlg);
                botonDlg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                                txtUser.getText().toString() + " " +
                                        txtPassword.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
                dialogoLogin.show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    };
}