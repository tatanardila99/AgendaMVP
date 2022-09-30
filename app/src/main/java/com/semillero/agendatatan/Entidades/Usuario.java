package com.semillero.agendatatan.Entidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Usuario {

    private int id;
    private String nombre;
    private String telefono;
    private String Correo_Electronico;
    private String contrasena;


    public void Usuario(int id, String nombre, String telefono, String correo_Electronico, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.Correo_Electronico = correo_Electronico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        Correo_Electronico = correo_Electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}