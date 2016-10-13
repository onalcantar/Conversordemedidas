package com.utl.conversordemedidas;

/**
 * Created by noealcantar on 16-10-12.
 */

public class DistanciaConversiones {
    private static String[] temperaturas_array = {"Metros",
            "Kilometros",
            "Millas",
            "Pulgadas"};


    public String realizaConversion(String distFrom, String distTo, Double dist){
        String res = "";

        switch (distFrom){
            case "Metros":
                res = MetrosA(distTo, dist);
                break;
            case "Kilometros":
                res = KilometrosA(distTo, dist);
                break;
            case "Millas":
                res = MillasA(distTo, dist);
                break;
            case "Pulgadas":
                res = PulgadasA(distTo, dist);
                break;
            default:
                res = "La conversión no ha podido ser realizada";
                break;
        }

        return res;
    }

    //Realiza todas las conversiones de kilogramos a otra medida
    public String MetrosA(String distTo, Double dist){
        Double result = 0.0;
        String res = "";

        switch (distTo){
            case "Metros":
                result = dist;
                break;
            case "Kilometros":
                result = dist * 0.001;
                break;
            case "Millas":
                result = dist * 0.000621371;
                break;
            case "Pulgadas":
                result = dist * 39.3701;
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
    public String KilometrosA(String distTo, Double dist){
        Double result = 0.0;
        String res = "";

        switch (distTo){
            case "Metros":
                result = dist * 1000;
                break;
            case "Kilometros":
                result = dist;
                break;
            case "Millas":
                result = dist * 0.621371;
                break;
            case "Pulgadas":
                result = dist * 39370.1;
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
    public String MillasA(String distTo, Double dist){
        Double result = 0.0;
        String res = "";

        switch (distTo){
            case "Metros":
                result = dist * 1609.34;
                break;
            case "Kilometros":
                result = dist * 1.60934;
                break;
            case "Millas":
                result = dist;
                break;
            case "Pulgadas":
                result = dist * 63360;
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
    public String PulgadasA(String distTo, Double dist){
        Double result = 0.0;
        String res = "";

        switch (distTo){
            case "Metros":
                result = dist * 0.0254;
                break;
            case "Kilometros":
                result = dist * 2.54E-5;
                break;
            case "Millas":
                result = dist * 1.5783E-5;
                break;
            case "Pulgadas":
                result = dist;
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
