package com.semillero.agendatatan.Entidades;

import android.content.Context;
import android.content.SharedPreferences;

public class Spreferences {

    SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;

    public Spreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("bd_login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void  setCorreologin(String guardarCorreo){
        editor.putString("datoGuardarCorreo", guardarCorreo);
        editor.apply();

    }


    public String getCorreologin(){
        return sharedPreferences.getString("datoGuardarCorreo", "No encontrado");
    }

}
