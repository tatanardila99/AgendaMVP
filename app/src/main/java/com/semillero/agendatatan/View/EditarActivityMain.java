package com.semillero.agendatatan.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.semillero.agendatatan.Entidades.Contactos;
import com.semillero.agendatatan.R;
import com.semillero.agendatatan.Databases.DbContactos;

public class EditarActivityMain extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuarda;
    FloatingActionButton fbEditar, fabEliminar;
    Contactos contacto;
    boolean correcto = false;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_ver);


        txtNombre = findViewById(R.id.textNombreVer);
        txtTelefono = findViewById(R.id.txtTelefonoVer);
        txtCorreo = findViewById(R.id.txtCorreoElectronicoVer);
        btnGuarda = findViewById(R.id.btnGuardaVer);
        fbEditar = findViewById(R.id.fbEeditar);
        fbEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        fabEliminar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            } else{
                id = extras.getInt("ID");
            }
        } else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbContactos dbContactos = new DbContactos( EditarActivityMain.this);
        contacto = dbContactos.verContactos(id);

        if (contacto != null){
            txtNombre.setText(contacto.getNombre());
            txtTelefono.setText(contacto.getTelefono());
            txtCorreo.setText(contacto.getCorreo_Electronico());


        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNombre.getText().toString().equals("") && !txtNombre.getText().toString().equals("")){
                    correcto = dbContactos.editarContactos(id, txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());

                    if (correcto){
                     Toast.makeText( EditarActivityMain.this, "REGISTRO MODIFICADO", Toast.LENGTH_LONG).show();
                        verRegistro();

                    } else{
                        Toast.makeText( EditarActivityMain.this, " ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText( EditarActivityMain.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verRegistro(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
        finish();
    }


}
