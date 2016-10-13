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

public class Temperaturas extends AppCompatActivity {

    Spinner listTemp1;
    Spinner listTemp2;
    ImageButton switcher;
    TextView cantidad;
    TextView resultado;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperaturas);

        listTemp1 = (Spinner)findViewById(R.id.spinnerTemp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperaturas_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listTemp1.setAdapter(adapter);

        listTemp2 = (Spinner)findViewById(R.id.spinnerTemp2);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listTemp2.setAdapter(adapter);

        resultado = (TextView)findViewById(R.id.txtResultadoTemp);
        cantidad = (TextView)findViewById(R.id.txtTempIN);

        listTemp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realizaConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listTemp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String tempFrom = listTemp1.getSelectedItem().toString();
        String tempTo = listTemp2.getSelectedItem().toString();

        if ((counter % 2) == 1){
            tempFrom = listTemp2.getSelectedItem().toString();
            tempTo = listTemp1.getSelectedItem().toString();
        }

        String peso  = cantidad.getText().toString();

        String result = "0";

        if(!peso.equals("")){
            Double cantidad = Double.parseDouble(peso);
            TemperaturaConversiones conversiones = new TemperaturaConversiones();
            result = conversiones.realizaConversion(tempFrom, tempTo, cantidad);
        }

        resultado.setText(result + " " + tempTo);

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
        float posX = listTemp1.getX();
        float posY = listTemp1.getY();

        float posX2 = listTemp2.getX();
        float posY2 = listTemp2.getY();

        listTemp1.setX(posX2);
        listTemp1.setY(posY2);

        listTemp2.setX(posX);
        listTemp2.setY(posY);

    }
}
