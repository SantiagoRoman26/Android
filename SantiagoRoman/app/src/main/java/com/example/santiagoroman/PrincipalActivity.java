package com.example.santiagoroman;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PrincipalActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionFragmentos:
                intent = new Intent(PrincipalActivity.this, FragmentosActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionDialogos:
                Dialog dialogoLogin = new Dialog(PrincipalActivity.this);
                dialogoLogin.setContentView(R.layout.dlg_login);

                EditText txtUser = dialogoLogin.findViewById(R.id.txtUsuarioDlg);
                EditText txtPassword = dialogoLogin.findViewById(R.id.txtClaveDlg);
                Button botonDlg = dialogoLogin.findViewById(R.id.btnIngresarDlg);
                botonDlg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PrincipalActivity.this,
                                txtUser.getText().toString() + " " +
                                        txtPassword.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
                dialogoLogin.show();
                break;
            case R.id.opcionMemoriaInterna:
                intent = new Intent(PrincipalActivity.this, ActivityMemoriaInterna.class);
                startActivity(intent);
                break;
            case R.id.opcionMemoriaPorgrama:
                intent = new Intent(PrincipalActivity.this, ActivityMemoriaPrograma.class);
                startActivity(intent);
                break;
            case R.id.opcionMemoriaExterna:
                intent = new Intent(PrincipalActivity.this, ActivityMemoriaExterna.class);
                startActivity(intent);
                break;
            case R.id.opcionAcademia:
                intent = new Intent(PrincipalActivity.this, ActivityBDocentes.class);
                startActivity(intent);
                break;
            case R.id.opcionAlumnoWS:
                intent = new Intent(PrincipalActivity.this, ActivityVolleyAlumno.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}