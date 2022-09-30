package com.semillero.agendatatan.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.semillero.agendatatan.R;

public class BienvenidaLogin extends AppCompatActivity {

    Button btnEntrarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        setContentView( R.layout.activity_bienvenida_login1);

        btnEntrarLogin = findViewById(R.id.btnEntrarLogin);

        btnEntrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bienvenidaLogin();
            }
        });
    }




    private void bienvenidaLogin(){
        Intent intent = new Intent(this, LoginMain.class);
        startActivity(intent);
    }



}