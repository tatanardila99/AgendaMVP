package com.semillero.agendatatan.Presenter;

import android.content.Context;

import com.semillero.agendatatan.Model.db.MainInterfaces;
import com.semillero.agendatatan.Model.db.LoginIntercatorModel;

public class PresenterMain implements MainInterfaces.LoginPresenter,MainInterfaces.CrearUsuarioPresenter, MainInterfaces.LoginInteractor.finalLoginListener, MainInterfaces.LoginInteractor.finalCrearUsuarioListener, MainInterfaces.LoginInteractor.finalCrearContactoListener, MainInterfaces.CrearContactoPresenter, MainInterfaces.verContactoPresenter, MainInterfaces.LoginInteractor.finalVerContactoListener {


    //DECLARANDO INTERFACES
    private MainInterfaces.LoginView loginView;
    private MainInterfaces.LoginInteractor loginInteractor;
    private MainInterfaces.crearUsuarioView crearUsuView;
    private MainInterfaces.crearContactoView crearContactoView;
    private  MainInterfaces.VerContactoView verContactoView;


    public PresenterMain( MainInterfaces.VerContactoView verContactoView, MainInterfaces.LoginView loginView, MainInterfaces.crearUsuarioView crearUsuView, MainInterfaces.crearContactoView crearContactoView ,MainInterfaces.LoginInteractor loginInteractor, Context context) {
        this.loginView = loginView;
        this.crearUsuView = crearUsuView;
        this.crearContactoView = crearContactoView;
        this.verContactoView = verContactoView;
        this.loginInteractor = new LoginIntercatorModel( context );
    }


    //METODOS DEL PRESENTADOR -- LOGIN

    @Override
    public void validarIngreso(Context context, String usuario, String contrasena) {
        loginInteractor.validarUsuario( context, usuario, contrasena, this );
    }


    @Override
    public void salirAplicacion() {
    }


    //METODO DEL PRESENTADOR -- CREAR USUARIO

    @Override
    public void validarRegistrarUsu(Context context, String nombre, String telefono, String correo, String contrasena) {

        loginInteractor.validarCreacionUsuario( context, nombre, telefono, correo, contrasena, this );

    }




    //METODO DEL PRESENTADOR -- CREAR CONTACTO

    @Override
    public void validarRegistrocontacto(Context context, String nombre, String telefono, String correo) {
        loginInteractor.validarCrearContacto(context, nombre, telefono, correo,this);

    }


    //METODO DEL PRESENTADOR -- EDITAR CONTACTO

    @Override
    public void validarEliminarcontacto(Context context, String nombre, String telefono, String correo) {

    }

    @Override
    public void validarEditarcontacto(Context context, String nombre, String telefono, String correo) {

    }




    //METODOS DEL MODELO - finalLoginListener

    @Override
    public void activarUsuarioError() {
        loginView.setUsuarioError();

    }


    @Override
    public void activarContrasenaEror() {
        loginView.setContrasenaError();

    }

    @Override
    public void activarIngresoCorrecto() {
        loginView.navegacionPrincipal();

    }


    //METODOS DEL MODELO - finalCrearUsuarioListener

    @Override
    public void nombreCrearError() {
        crearUsuView.setUsuarioNombreError();

    }

    @Override
    public void telefonoCrearError() {
        crearUsuView.setUsuarioTelefonoError();
        ;
    }

    @Override
    public void correoCrearError() {
        crearUsuView.setUsuarioCorreoError();

    }

    @Override
    public void ContrasenaCrearError() {
        crearUsuView.setUsuarioContrasenaError();
    }


    @Override
    public void activarCreacionUsuario() {
        crearUsuView.creacionUsuarioCorrecta();


    }


    //METODOS DEL MODELO - finalCrearContactoListener

    @Override
    public void activarNombreContactoError() {
        crearContactoView.setContactoNombreError();

    }

    @Override
    public void activarTelefonoContactoEror() {
        crearContactoView.setContactoTelefonoError();

    }

    @Override
    public void activarCorreoContactoEror() {
        crearContactoView.setContactoCorreoError();

    }

    @Override
    public void activarIngresoContactoCorrecto() {
        crearContactoView.creacionUsuarioCorrecta();

    }

    @Override
    public void activarIngresoContactoInCorrecto() {
        crearContactoView.creacionUsuarioInCorrecta();

    }



    //METODOS DEL MODELO - finalVerContactoListener

    @Override
    public void activarEditarContacto() {
        verContactoView.editarContactoselect();


    }

    @Override
    public void activarEliminarContacto() {
        verContactoView.eliminarContactoselect();


    }

    @Override
    public void activarActualizarContacto() {

    }
}
