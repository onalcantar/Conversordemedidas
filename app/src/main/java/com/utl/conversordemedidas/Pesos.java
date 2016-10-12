package com.utl.conversordemedidas;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Pesos extends AppCompatActivity {

    Spinner listPeso1;
    Spinner listPeso2;
    ImageButton switcher;
    TextView cantidad;
    TextView resultado;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesos);

        listPeso1 = (Spinner)findViewById(R.id.spinnerPeso);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pesos_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listPeso1.setAdapter(adapter);

        listPeso2 = (Spinner)findViewById(R.id.spinnerPeso2);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listPeso2.setAdapter(adapter);

        resultado = (TextView)findViewById(R.id.txtResultado);
        cantidad = (TextView)findViewById(R.id.txtPesoIN);

        listPeso1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realizaConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listPeso2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String pesoFrom = listPeso1.getSelectedItem().toString();
        String pesoTo = listPeso2.getSelectedItem().toString();

        if ((counter % 2) == 1){
            pesoFrom = listPeso2.getSelectedItem().toString();
            pesoTo = listPeso1.getSelectedItem().toString();
        }

        String peso  = cantidad.getText().toString();

        String result = "0";

        if(!peso.equals("")){
            Double cantidad = Double.parseDouble(peso);
            PesosConversiones conversiones = new PesosConversiones();
            result = conversiones.realizaConversion(pesoFrom, pesoTo, cantidad);
        }

        resultado.setText(result + " " + pesoTo);

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
        float posX = listPeso1.getX();
        float posY = listPeso1.getY();

        float posX2 = listPeso2.getX();
        float posY2 = listPeso2.getY();

        listPeso1.setX(posX2);
        listPeso1.setY(posY2);

        listPeso2.setX(posX);
        listPeso2.setY(posY);

    }

}
