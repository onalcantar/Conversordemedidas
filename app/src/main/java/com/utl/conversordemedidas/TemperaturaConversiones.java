package com.utl.conversordemedidas;

/**
 * Created by noealcantar on 16-10-12.
 */

public class TemperaturaConversiones {

    private static String[] temperaturas_array = {"Centígrados",
            "Fahrenheit",
            "Kelvin",
            "Rankine"};


    public String realizaConversion(String tempFrom, String tempTo, Double temp){
        String res = "";

        switch (tempFrom){
            case "Centígrados":
                res = CentigradosA(tempTo, temp);
                break;
            case "Fahrenheit":
                res = FahrenheitA(tempTo, temp);
                break;
            case "Kelvin":
                res = KelvinA(tempTo, temp);
                break;
            case "Rankine":
                res = RankineA(tempTo, temp);
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        return res;
    }

    //Realiza todas las conversiones de kilogramos a otra medida
    public String CentigradosA(String tempTo, Double temp){
        Double result = 0.0;
        String res = "";

        switch (tempTo){
            case "Centígrados":
                result = temp;
                break;
            case "Fahrenheit":
                result = (temp * 9/5) + 32;
                break;
            case "Kelvin":
                result = temp + 273.15;
                break;
            case "Rankine":
                result = (temp + 273.15) * 9/5 ;
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

    //Realiza todas las conversiones de libras a otra medida
    public String FahrenheitA(String tempTo, Double temp){
        Double result = 0.0;
        String res = "";

        switch (tempTo){
            case "Centígrados":
                result = (temp - 32) * 5/9;
                break;
            case "Fahrenheit":
                result = temp;
                break;
            case "Kelvin":
                result = (temp + 459.67) * 5/9;
                break;
            case "Rankine":
                result = temp + 459.67;
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
    public String KelvinA(String tempTo, Double temp){
        Double result = 0.0;
        String res = "";

        switch (tempTo){
            case "Centígrados":
                result = temp - 273.15;
                break;
            case "Fahrenheit":
                result = (temp * 9/5) - 459.67;
                break;
            case "Kelvin":
                result = temp;
                break;
            case "Rankine":
                result = temp * 9/5;
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
    public String RankineA(String tempTo, Double temp){
        Double result = 0.0;
        String res = "";

        switch (tempTo){
            case "Centígrados":
                result = (temp - 491.67) * 5/9;
                break;
            case "Fahrenheit":
                result = temp - 459.67;
                break;
            case "Kelvin":
                result = temp * 5/9;
                break;
            case "Rankine":
                result = temp;
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
