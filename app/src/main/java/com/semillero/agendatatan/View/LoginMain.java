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
import com.semillero.agendatatan.Databases.DbContactos;

public class LoginMain extends AppCompatActivity implements MainInterfaces.LoginView, View.OnClickListener {

    EditText etCorreo, etContrasena;
    Button btnCrear, btnIniciar;
    DbContactos dbhelperU;
    private MainInterfaces.LoginPresenter presenter;
    private MainInterfaces.crearUsuarioView crearUsuarioViewMain;
    private MainInterfaces.crearContactoView crearContactoViewMain;
    private MainInterfaces.VerContactoView verContactoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_main );
        etCorreo = findViewById( R.id.tvCorreo );
        etContrasena = findViewById(R.id.tvContrasena);
        btnCrear = findViewById(R.id.btnCrearCuenta);
        btnCrear.setOnClickListener(this);
        btnIniciar = findViewById(R.id.btnIniciarSesion);
        btnIniciar.setOnClickListener(this);

        presenter = new PresenterMain(verContactoView, this,crearUsuarioViewMain,crearContactoViewMain,new LoginIntercatorModel(this), this );

    }



    //IMPLEMENTACION DE METODOS DE LA INTERFAZ DEL VIEW

    @Override
    public void setUsuarioError() {
        etCorreo.setError("Debe ingresar un correo");
    }

    @Override
    public void setContrasenaError() {
        etContrasena.setError("Debe ingresar una contraseña");

    }

    @Override
    public void setErrorIngreso() {
        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();

    }

    @Override
    public void navegacionPrincipal() {
        Toast.makeText(getApplicationContext(), "BIENVENIDO A TU AGENDA, CRACK :')", Toast.LENGTH_LONG).show();

    }

    @Override
    public void creacionUsuario() {

    }


    //METODO ONCLICK DE LA VISTA LOGIN

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIniciarSesion:
                    presenter.validarIngreso(this, etCorreo.getText().toString(), etContrasena.getText().toString());
                    finish();
                    break;

            case R.id.btnCrearCuenta:
                    Intent intentdos = new Intent(this, crearUsuarioMain.class);
                    startActivity(intentdos);
                    break;
        }

    }











}

