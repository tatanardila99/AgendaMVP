package com.semillero.agendatatan.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.semillero.agendatatan.R;
import com.semillero.agendatatan.Entidades.Spreferences;
import com.semillero.agendatatan.adaptadores.listaContactosAdapter;
import com.semillero.agendatatan.Databases.DbContactos;
import com.semillero.agendatatan.Entidades.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList <Contactos> listaArrayContactos;
    Spreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        listaContactos = findViewById(R.id.listaContacto);
        sharedPreferences = new Spreferences (MainActivity.this);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        DbContactos dbContactos = new DbContactos(MainActivity.this);

        listaArrayContactos = new ArrayList<>();

        listaContactosAdapter adapter = new listaContactosAdapter(dbContactos.mostrarContactosUsuario(sharedPreferences.getCorreologin()));
        listaContactos.setAdapter(adapter);
    }


  public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoContactoMain.class);
        startActivity(intent);
        finish();
    }




}