package com.semillero.agendatatan.Model.db;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.semillero.agendatatan.Databases.DbContactos;
import com.semillero.agendatatan.Databases.DbHelper;
import com.semillero.agendatatan.Entidades.Contactos;
import com.semillero.agendatatan.Entidades.Spreferences;
import com.semillero.agendatatan.Entidades.Usuario;
import com.semillero.agendatatan.View.LoginMain;
import com.semillero.agendatatan.View.MainActivity;

public class LoginIntercatorModel extends DbHelper implements MainInterfaces.LoginInteractor{

    DbContactos dbhelperU;
    Spreferences spreferences;
    Context contextdb;
    Contactos contacto;
    int id = 0;




    public LoginIntercatorModel( @Nullable Context context) {
        super(context, "agenda.db", null, 1);
        this.contextdb = context;
    }


    //METODO PARA VALIDAR SI EL USUARIO EXITSE EN BASE DE DATOS

    @Override
    public void validarUsuario(Context context, final String username, final String password, final MainInterfaces.LoginInteractor.finalLoginListener listener) {
        try {
            dbhelperU = new DbContactos(context);
            Cursor cursor = dbhelperU.ConsultarUsuPass(username, password);
            spreferences = new Spreferences( context );

            if (cursor.getCount() > 0) {
                listener.activarIngresoCorrecto();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                spreferences.setCorreologin(username); // si valida correctamente, guarda el correo en el preference

                }else{
                    listener.activarUsuarioError();
                    listener.activarContrasenaEror();
                    Toast.makeText(context,"Usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();


                    }
        } catch (
                SQLException e){
                e.printStackTrace();
        }

    }



    //METODO PARA VALIDAR SI EL USUARIO FUE CREADO EN LA  BASE DE DATOS

    @Override
    public void validarCreacionUsuario( final Context context, final String nombre, final String telefono, final String correo, final String contrasena, final finalCrearUsuarioListener usuarioListener) {

        DbContactos dbContactos = new DbContactos( context );
        Usuario usuario = new Usuario();

        if (TextUtils.isEmpty( nombre ) || TextUtils.isEmpty( telefono ) || TextUtils.isEmpty( contrasena ) || TextUtils.isEmpty( correo )) {
            usuarioListener.nombreCrearError();
            usuarioListener.telefonoCrearError();
            usuarioListener.correoCrearError();
            usuarioListener.ContrasenaCrearError();
        } else {
            Intent intent = new Intent( context, LoginMain.class );
            context.startActivity( intent );

            usuario.setNombre( nombre );
            usuario.setTelefono( telefono );
            usuario.setCorreo_Electronico( correo );
            usuario.setContrasena( contrasena );

            long id = dbContactos.insertarUsuarios( usuario );
            usuarioListener.activarCreacionUsuario();

            }
        }





    //METODO PARA VALIDAR SI EL CONTACTO FUE CREADO EN LA  BASE DE DATOS

    @Override
    public void validarCrearContacto(final Context context, final String nombre, final String telefono,final  String correo, final finalCrearContactoListener crearContactoListener) {

        if (TextUtils.isEmpty( nombre ) || TextUtils.isEmpty( telefono ) || TextUtils.isEmpty( correo )) {
            crearContactoListener.activarNombreContactoError();
            crearContactoListener.activarTelefonoContactoEror();
            crearContactoListener.activarCorreoContactoEror();
            crearContactoListener.activarIngresoContactoInCorrecto();

        } else {
            DbContactos dbContactos = new DbContactos(context);
            spreferences = new Spreferences(context);
            long id = dbContactos.insertarContactos( nombre, telefono, correo, spreferences.getCorreologin() );

            if (id > 0) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
               crearContactoListener.activarIngresoContactoCorrecto();
            }
        }

    }



    //METODO PARA VALIDAR LA OPCION EN VER CONTACTO Y REALIZAR LA ACTUALIZACION DEL ESTADO DEL CONTACTO (EDITAR O ELIMINAR)

    @Override
    public void validarActualizarContacto(final Context context, final String nombre, final String telfono, final String correo, final finalVerContactoListener verContactoListener) {
              //  verContactoListener.activarActualizarContacto();
    }


}













































































