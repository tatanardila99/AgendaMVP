package com.semillero.agendatatan.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.semillero.agendatatan.Model.db.MainInterfaces;
import com.semillero.agendatatan.Model.db.LoginIntercatorModel;
import com.semillero.agendatatan.Presenter.PresenterMain;
import com.semillero.agendatatan.R;

public class NuevoContactoMain extends AppCompatActivity implements MainInterfaces.crearContactoView, View.OnClickListener {

    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuarda;
    private MainInterfaces.CrearContactoPresenter crearContactoPresenter;
    private MainInterfaces.crearUsuarioView crearUsuario;
    private  MainInterfaces.LoginView loginView;
    private  MainInterfaces.VerContactoView  verContactoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_nuevo );

        txtNombre = findViewById( R.id.textNombre );
        txtTelefono = findViewById( R.id.txtTelefono );
        txtCorreoElectronico = findViewById( R.id.txtCorreoElectronico );
        btnGuarda = findViewById( R.id.btnGuarda );
        btnGuarda.setOnClickListener( this );
        crearContactoPresenter = new PresenterMain( verContactoView, loginView,crearUsuario,this, new LoginIntercatorModel(this), this);

    }



    //METODOS DE LA INTERFAZ DEL VIEW -- CREAR CONTACTO

    @Override
    public void setContactoNombreError() {
        txtNombre.setError("Ingrese un nombre");
    }

    @Override
    public void setContactoTelefonoError() {
        txtTelefono.setError("Ingrese un telefono");

    }

    @Override
    public void setContactoCorreoError() {
        txtCorreoElectronico.setError("Ingrese un correo");
    }

    @Override
    public void creacionUsuarioCorrecta() {
        Toast.makeText( this, "CONTACTO GUARDADO", Toast.LENGTH_LONG).show();

    }

    @Override
    public void creacionUsuarioInCorrecta() {
        Toast.makeText( this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

    }


    //METODO ONCLICK DE LA CASE VIEW CREAR CONTACTO

    @Override
    public void onClick(View view) {
        crearContactoPresenter.validarRegistrocontacto( this, txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString());
    }
}