package com.example.amaris.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tools {

    public static Boolean VerificationDateFormatt(String date){
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            formatoFecha.setLenient(false);
            formatoFecha.parse(date);
        } catch (ParseException e) {
            return false;
        }



        return true;
    }
}
