package com.example.akkodis.application.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tools {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static boolean isValidDateFormat(String date) {
        try {
            LocalDateTime.parse(date, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDateTime convertToDate(String date) {
        return LocalDateTime.from(FORMATTER.parse(date));
    }
}