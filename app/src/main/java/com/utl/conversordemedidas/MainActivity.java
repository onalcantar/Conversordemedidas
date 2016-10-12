package com.utl.conversordemedidas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Redirige a una nueva actividad dependiendo de la elección del usuario
    public void onClickRbtnOpcion(View v){
        Intent intent;

        switch (v.getId()){
            case R.id.btnTemperatura:
                intent = new Intent(this, Temperaturas.class);
                break;
            case R.id.btnDistancia:
                intent = new Intent(this,  Distancias.class);
                break;
            case R.id.btnPeso:
                intent = new Intent(this, Pesos.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
                break;
        }

        startActivity(intent);
    }
}
