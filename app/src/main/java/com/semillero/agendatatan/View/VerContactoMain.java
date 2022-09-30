package com.semillero.agendatatan.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.semillero.agendatatan.Entidades.Contactos;
import com.semillero.agendatatan.Model.db.LoginIntercatorModel;
import com.semillero.agendatatan.Model.db.MainInterfaces;
import com.semillero.agendatatan.Presenter.PresenterMain;
import com.semillero.agendatatan.R;
import com.semillero.agendatatan.Databases.DbContactos;

public class VerContactoMain extends AppCompatActivity implements MainInterfaces.VerContactoView, View.OnClickListener {


    //Referecnias

    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuarda;
    FloatingActionButton fbEditar, fabEliminar;
    private MainInterfaces.verContactoPresenter verContactoPresenter;
    private MainInterfaces.LoginView loginView;
    private MainInterfaces.crearUsuarioView crearUsuarioView;
    private MainInterfaces.crearContactoView crearContactoView;
    private MainInterfaces.CrearContactoPresenter crearContactoPresenter;
    Contactos contacto;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ver );

        txtNombre = findViewById( R.id.textNombreVer );
        txtTelefono = findViewById( R.id.txtTelefonoVer );
        txtCorreo = findViewById( R.id.txtCorreoElectronicoVer );
        btnGuarda = findViewById( R.id.btnGuardaVer );
        btnGuarda.setOnClickListener( this );
        fbEditar = findViewById( R.id.fbEeditar );
        fbEditar.setOnClickListener( this );
        fabEliminar = findViewById( R.id.fabEliminar );
        fabEliminar.setOnClickListener( this );

        verContactoPresenter = new PresenterMain( this, loginView, crearUsuarioView, crearContactoView, new LoginIntercatorModel( this ), this );


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt( String.valueOf( id ) );
            } else {
                id = extras.getInt( "ID" );
            }
        } else {
            id = (int) savedInstanceState.getSerializable( "ID" );
        }

        DbContactos dbContactos = new DbContactos( VerContactoMain.this );
        contacto = dbContactos.verContactos( id );


        if (contacto != null) {
            txtNombre.setText( contacto.getNombre() );
            txtTelefono.setText( contacto.getTelefono() );
            txtCorreo.setText( contacto.getCorreo_Electronico() );
            btnGuarda.setVisibility( View.INVISIBLE );

            txtNombre.setInputType( InputType.TYPE_NULL );
            txtTelefono.setInputType( InputType.TYPE_NULL );
            txtCorreo.setInputType( InputType.TYPE_NULL );
        }
    }

    //METODOS DE LA INTERFAZ DEL VIEW -- EDITAR CONTACTO

    @Override
    public void editarContactoselect() {
        Intent intent = new Intent( VerContactoMain.this, EditarActivityMain.class );
        intent.putExtra( "ID", id );
        startActivity( intent );
        finish();
    }

    @Override
    public void eliminarContactoselect() {
        Toast.makeText( this, "CONTACTO ELIMINADO", Toast.LENGTH_LONG ).show();
        Intent intent = new Intent( VerContactoMain.this, MainActivity.class );
        startActivity( intent );
        finish();


    }


    //METODO ONCLICK DE LA CLASE VIEW EDITAR USUARIO

    @Override
    public void onClick(View view) {

        DbContactos dbContactos = new DbContactos( VerContactoMain.this );
        contacto = dbContactos.verContactos( id );

        switch (view.getId()) {

            case R.id.fbEeditar:
                verContactoPresenter.validarEditarcontacto( this, txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString() );
                editarContactoselect();
                finish();
                break;

            case R.id.fabEliminar:
                AlertDialog.Builder builder = new AlertDialog.Builder( VerContactoMain.this );
                builder.setMessage( "¿Desea eliminar este contacto?" )
                        .setPositiveButton( "SI", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (dbContactos.eliminarContactos( id )) {
                                    eliminarContactoselect();
                                }
                            }
                        } )
                        .setNegativeButton( "NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        } ).show();
                break;


        }
    }
}






















































