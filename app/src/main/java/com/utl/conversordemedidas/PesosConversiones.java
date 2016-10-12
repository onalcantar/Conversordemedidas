package com.utl.conversordemedidas;

/**
 * Created by noealcantar on 16-10-12.
 */

public class PesosConversiones {

    private static String[] pesos_array = {"Kilogramos",
                "Libras",
                "Onzas",
                "Toneladas"};


    public String realizaConversion(String pesoFrom, String pesoTo, Double peso){
        String res = "";

        switch (pesoFrom){
            case "Kilogramos":
                res = KilogramosA(pesoTo, peso);
                break;
            case "Libras":
                res = LibrasA(pesoTo, peso);
                break;
            case "Onzas":
                res = OnzasA(pesoTo, peso);
                break;
            case "Toneladas":
                res = ToneladasA(pesoTo, peso);
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        return res;
    }

    //Realiza todas las conversiones de kilogramos a otra medida
    public String KilogramosA(String pesoTo, Double peso){
        Double result = 0.0;
        String res = "";

        switch (pesoTo){
            case "Kilogramos":
                result = peso;
                break;
            case "Libras":
                result = peso * 2.20462;
                break;
            case "Onzas":
                result = peso * 35.274;
                break;
            case "Toneladas":
                result = peso * 0.001;
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        //2 digitos
        result = round(result, 4);
        res = String.valueOf(result);

        return res;
    }

    //Realiza todas las conversiones de libras a otra medida
    public String LibrasA(String pesoTo, Double peso){
        Double result = 0.0;
        String res = "";

        switch (pesoTo){
            case "Kilogramos":
                result = peso * 0.453592;
                break;
            case "Libras":
                result = peso;
                break;
            case "Onzas":
                result = peso * 16;
                break;
            case "Toneladas":
                result = peso * 0.000453592;
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        //2 digitos
        result = round(result, 8);
        res = String.valueOf(result);

        return res;
    }

    //Realiza todas las conversiones de onzas a otra medida
    public String OnzasA(String pesoTo, Double peso){
        Double result = 0.0;
        String res = "";

        switch (pesoTo){
            case "Kilogramos":
                result = peso * 0.0283495;
                break;
            case "Libras":
                result = peso * 0.0625;
                break;
            case "Onzas":
                result = peso;
                break;
            case "Toneladas":
                result = peso * 2.835E-5;
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        //2 digitos
        result = round(result, 8);
        res = String.valueOf(result);

        return res;
    }

    //Realiza todas las conversiones de onzas a otra medida
    public String ToneladasA(String pesoTo, Double peso){
        Double result = 0.0;
        String res = "";

        switch (pesoTo){
            case "Kilogramos":
                result = peso * 1E+8;
                break;
            case "Libras":
                result = peso * 2.40462E+8;
                break;
            case "Onzas":
                result = peso * 3.5274E+9;
                break;
            case "Toneladas":
                result = peso;
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        //2 digitos
        result = round(result, 8);
        res = String.valueOf(result);

        return res;
    }

    //Delimita a 2 decimales despues del punto
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
