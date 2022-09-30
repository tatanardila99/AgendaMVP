package com.semillero.agendatatan.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.semillero.agendatatan.Model.db.MainInterfaces;
import com.semillero.agendatatan.Model.db.LoginIntercatorModel;
import com.semillero.agendatatan.Presenter.PresenterMain;
import com.semillero.agendatatan.R;

public class crearUsuarioMain extends AppCompatActivity implements MainInterfaces.crearUsuarioView, View.OnClickListener {

    Button btnRegresarInicio, btnCrearUsu;
    EditText tvnombre, tvTelefono, tvCorreo, tvContrasena;
    private MainInterfaces.CrearUsuarioPresenter crearUsuario;
    private  MainInterfaces.LoginView loginView;
    private  MainInterfaces.crearContactoView crearContactoView;
    private MainInterfaces.VerContactoView verContactoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_crear_cuenta_usuario );

        tvnombre = findViewById( R.id.tvnombre );
        tvTelefono = findViewById( R.id.tvTelefono );
        tvCorreo = findViewById( R.id.tvCorreo );
        tvContrasena = findViewById( R.id.contraseñaLogin );
        btnRegresarInicio = findViewById(R.id.btnRegresarInicio);
        btnRegresarInicio.setOnClickListener(this);
        btnCrearUsu = findViewById(R.id.btnCrearUsu);
        btnCrearUsu.setOnClickListener(this);

        crearUsuario = new PresenterMain( verContactoView, loginView,this, crearContactoView, new LoginIntercatorModel(this), this);
    }


    //IMPLEMENTACION DE LOS METODOS DE LA INTERFAZ VIEW CREAR USUARIO

    @Override
    public void setUsuarioNombreError() {
        tvnombre.setError("Ingresar un nombre");

    }

    @Override
    public void setUsuarioContrasenaError() {
        tvContrasena.setError("Ingresar una contraseña");

    }

    @Override
    public void setUsuarioTelefonoError() {
        tvTelefono.setError("Ingresar un telefono");
    }

    @Override
    public void setUsuarioCorreoError() {
        tvCorreo.setError("Ingresar un Correo");

    }


    @Override
    public void creacionUsuarioCorrecta() {
        Toast.makeText( crearUsuarioMain.this, "USUARIO GUARDADO", Toast.LENGTH_LONG).show();
    }



    //METODO ONCLICK DE LA CLASE VIEW CREAR USUARIO

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCrearUsu:
                crearUsuario.validarRegistrarUsu( this, tvnombre.getText().toString(),tvTelefono.getText().toString(),tvCorreo.getText().toString(),tvContrasena.getText().toString());
                break;

            case R.id.btnRegresarInicio:
                Intent intentdos = new Intent(this, LoginMain.class);
                startActivity(intentdos);
                break;
        }
    }
}





























































