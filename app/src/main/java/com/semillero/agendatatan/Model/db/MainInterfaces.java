package com.semillero.agendatatan.Model.db;

import android.content.Context;

public interface MainInterfaces {



//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//
    //        IMPLEMENTACION DE LOS PRESENTADORES EN LA INTERFAZ PRINCIPAL        //
//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//



    //  INTERFAZ DEL VIEW -- LOGIN

    public interface LoginView {

        void setUsuarioError();

        void setContrasenaError();

        void setErrorIngreso();

        void navegacionPrincipal();

        void creacionUsuario();
    }



    //  INTERFAZ DEL VIEW  -- CREACION DE USUARIO

    public interface crearUsuarioView {

        void setUsuarioNombreError();

        void setUsuarioContrasenaError();

        void setUsuarioTelefonoError();

        void setUsuarioCorreoError();

        void creacionUsuarioCorrecta();
    }


    //  INTERFAZ DEL VIEW  -- CREAR CONTACTO

    public interface crearContactoView {

        void setContactoNombreError();

        void setContactoTelefonoError();

        void setContactoCorreoError();

        void creacionUsuarioCorrecta();

        void creacionUsuarioInCorrecta();
    }

    //  INTERFAZ DEL VIEW  -- VER CONTACTO

    public interface VerContactoView {

        void editarContactoselect();

        void eliminarContactoselect();
    }





//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//
    //        IMPLEMENTACION DE LOS PRESENTADORES EN LA INTERFAZ PRINCIPAL        //
//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//





    //INTERFAZ DEL PRESENTADOR -- LOGIN

    public interface LoginPresenter {

        void validarIngreso(Context context, String usuario, String contrasena);

        void  salirAplicacion();
    }




    //INTERFAZ DEL PRESENTADOR -- CREAR USUARIO

    public interface CrearUsuarioPresenter {

        void validarRegistrarUsu(Context context, String nombre,String telefono,String correo,String contrasena);

        void  salirAplicacion();

    }


    //INTERFAZ DEL PRESENTADOR -- CREAR CONTACTO

    public interface CrearContactoPresenter {

        void validarRegistrocontacto(Context context, String nombre, String telefono, String correo);

        void  salirAplicacion();

    }


    //INTERFAZ DEL PRESENTADOR -- VER CONTACTO

    public interface verContactoPresenter {

        void validarEliminarcontacto(Context context, String nombre, String telefono, String correo);

        void  validarEditarcontacto(Context context, String nombre, String telefono, String correo);
    }






//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//
    //        IMPLEMENTACION DEL MDOELO  EN LA INTERFAZ PRINCIPAL        //
//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//



    //INTERFAZ  DEL MODELO


    public interface LoginInteractor {



        interface  finalLoginListener{

            void activarUsuarioError();

            void activarContrasenaEror();

            void activarIngresoCorrecto();


        }

        interface  finalCrearUsuarioListener{

            void nombreCrearError();

            void telefonoCrearError();

            void correoCrearError();

            void ContrasenaCrearError();

            void activarCreacionUsuario();


        }


        interface  finalCrearContactoListener{

            void activarNombreContactoError();

            void activarTelefonoContactoEror();

            void activarCorreoContactoEror();

            void activarIngresoContactoCorrecto();

            void activarIngresoContactoInCorrecto();

        }



        interface  finalVerContactoListener{

            void activarEditarContacto();

            void activarEliminarContacto();

            void activarActualizarContacto();


        }


        void validarUsuario(Context context, String username, String password, MainInterfaces.LoginInteractor.finalLoginListener listener);

        void validarCreacionUsuario(Context context, String nombre,String telfono, String correo, String contrasena, MainInterfaces.LoginInteractor.finalCrearUsuarioListener usuarioListener);

        void validarCrearContacto(Context context, String nombre, String telefono, String correo, MainInterfaces.LoginInteractor.finalCrearContactoListener crearContactoListener);

        void validarActualizarContacto(Context context, String nombre,String telfono, String correo, MainInterfaces.LoginInteractor.finalVerContactoListener verContactoListener );
    }




}
