package com.semillero.agendatatan.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NOMBRE= "agenda.db";
    public static final String TABLE_CONTACTOS = "t_contactos";
    public static  final String TABLE_USUARIOS = "t_usuarios";
    public static  final String idUsuario= "idUsuario";
    public static  final String nombreUsuario= "nombreUsuario";
    public static  final String telefonoUsuario = "telefonoUsuario";
    public static  final String contrasenaUsuario = "contrasenaUsuario";
    public static  final String Correo_ElectronicoUsuario = "Correo_ElectronicoUsuario";



    public DbHelper(@Nullable Context context, String s, Object o, int i) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "Correo_Electronico TEXT NOT NULL," +
                "UsuarioCreador TEXT)");


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIOS + "(" +
                idUsuario + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                nombreUsuario + " TEXT NOT NULL," +
                telefonoUsuario + " TEXT NOT NULL," +
                contrasenaUsuario + " TEXT NOT NULL," +
                Correo_ElectronicoUsuario + " TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);

    }

}
