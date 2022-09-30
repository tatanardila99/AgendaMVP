package com.semillero.agendatatan.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.semillero.agendatatan.Entidades.Spreferences;
import com.semillero.agendatatan.Entidades.Usuario;
import com.semillero.agendatatan.Entidades.Contactos;

import java.util.ArrayList;

public class DbContactos extends DbHelper {



    Spreferences spreferences;
    Context context;

    public DbContactos( @Nullable Context context) {
        super(context, "agenda.db", null, 1);
        this.context = context;
    }




    // // METODO PARA GUARDAR CONTACTOS

    public long insertarContactos(String nombre, String telefono, String Correo_Electronico, String correo ) {

        long id = 0;

        try {
            spreferences = new Spreferences(context);
            DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("Correo_Electronico", Correo_Electronico);
            values.put("UsuarioCreador", spreferences.getCorreologin());

            id = db.insert(TABLE_CONTACTOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


    // METODO PARA INSETAR USUARIO

    public long insertarUsuarios(Usuario usuario) {
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(nombreUsuario, usuario.getNombre());
            values.put(telefonoUsuario, usuario.getTelefono());
            values.put(contrasenaUsuario, usuario.getContrasena());
            values.put(Correo_ElectronicoUsuario, usuario.getCorreo_Electronico());
            id = db.insert(TABLE_USUARIOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


    // METODO DE VALIDACION DE USUARIO

    public Cursor ConsultarUsuPass (String usuario, String contrasena) throws SQLException{
        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        Cursor mCursor = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        mCursor = db.rawQuery("SELECT * FROM " + TABLE_USUARIOS + " WHERE " +Correo_ElectronicoUsuario+ " = '" + usuario + "' AND " + contrasenaUsuario + " = '" + contrasena +"'",null);
        return mCursor;
    }



    // METODO PARA MOSTRAR CONTACTOS

    public ArrayList<Contactos> mostrarContactos(){
        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null);

        if (cursorContactos.moveToFirst()){
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_Electronico(cursorContactos.getString(3));

                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return listaContactos;

    }


    // METODO PARA MOSTRAR CONTACTOS DE USUARIO

    public ArrayList<Contactos> mostrarContactosUsuario(String correo){
        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;
        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS + " WHERE UsuarioCreador = '" + correo + "'", null);

        if (cursorContactos.moveToFirst()){
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_Electronico(cursorContactos.getString(3));
                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();
        return listaContactos;

    }



    // METODO PARA VER CONTACTOS

    public Contactos verContactos(int id){
        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Contactos contacto = null;
        Cursor cursorContactos;
        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS +  " WHERE id = "  + id + " LIMIT 1",  null);

        if (cursorContactos.moveToFirst()){
            contacto = new Contactos();
            contacto.setId(cursorContactos.getInt(0));
            contacto.setNombre(cursorContactos.getString(1));
            contacto.setTelefono(cursorContactos.getString(2));
            contacto.setCorreo_Electronico(cursorContactos.getString(3));
        }
        cursorContactos.close();
        return contacto;

    }


    // METODO PARA EDITAR CONTACTOS

    public boolean editarContactos ( int id,  String nombre, String telefono, String Correo_Electronico){
        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_CONTACTOS +  " SET nombre = '"+ nombre + "', telefono = '" + telefono + "',Correo_Electronico = '" + Correo_Electronico + "' WHERE id='" + id + "' ");

           correcto = true;

        } catch (Exception ex){
            ex.toString();
            correcto = false;

        } finally {
            db.close();
        }

        return correcto;
    }




    // METODO PARA ELIMINAR CONTACTOS

    public boolean eliminarContactos ( int id) {
        boolean correcto = false;
        DbHelper dbHelper = new DbHelper(context, "agenda.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_CONTACTOS + " WHERE id = '" + id + "'");
            correcto = true;

            } catch (Exception ex){
                ex.toString();
                correcto = false;

            } finally {
                    db.close();
                    }
        return correcto;
    }


}






































































