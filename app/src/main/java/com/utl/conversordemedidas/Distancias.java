package com.utl.conversordemedidas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Distancias extends AppCompatActivity {

    Spinner listDist1;
    Spinner listDist2;
    ImageButton switcher;
    TextView cantidad;
    TextView resultado;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancias);

        listDist1 = (Spinner)findViewById(R.id.spinnerDist);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.distancias_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listDist1.setAdapter(adapter);

        listDist2 = (Spinner)findViewById(R.id.spinnerDist2);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listDist2.setAdapter(adapter);

        resultado = (TextView)findViewById(R.id.txtResultadoDist);
        cantidad = (TextView)findViewById(R.id.txtDistIN);

        listDist1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realizaConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listDist2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realizaConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                realizaConversion();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        switcher = (ImageButton)findViewById(R.id.btnSwitch);

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switcher.startAnimation(rotate());
                counter++;
                System.out.println(counter);
                realizaConversion();
            }
        });
    }

    //Realiza el calculo de la conversion
    //Regresa el total obtenido de la aplicacion
    public void realizaConversion(){

        String distFrom = listDist1.getSelectedItem().toString();
        String distTo = listDist2.getSelectedItem().toString();

        if ((counter % 2) == 1){
            distFrom = listDist2.getSelectedItem().toString();
            distTo = listDist1.getSelectedItem().toString();
        }

        String peso  = cantidad.getText().toString();

        String result = "0";

        if(!peso.equals("")){
            Double cantidad = Double.parseDouble(peso);
            DistanciaConversiones conversiones = new DistanciaConversiones();
            result = conversiones.realizaConversion(distFrom, distTo, cantidad);
        }

        resultado.setText(result + " " + distTo);

    }

    //Realiza la rotaciôn de una imagen
    //Define la duracion en que el boton rotara
    public RotateAnimation rotate(){
        //Define el tipo de rotacion del boton
        RotateAnimation ra =new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        //DEfina la duracion
        ra.setDuration(200);

        //Hace llamdo a la funcion que intercambia las posiciones de las listas
        swapPositions();

        return ra;
    }

    //Intercambia las posiciones de las dos listas de elementos
    //Toma las posiciones X y Y de cada elemento para despues
    //intercambiarlas
    public void swapPositions(){
        float posX = listDist1.getX();
        float posY = listDist1.getY();

        float posX2 = listDist2.getX();
        float posY2 = listDist2.getY();

        listDist1.setX(posX2);
        listDist1.setY(posY2);

        listDist2.setX(posX);
        listDist2.setY(posY);

    }
}
