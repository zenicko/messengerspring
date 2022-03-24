package ru.zenicko.messengerspring.examples;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTests {
    static public void main(String arg[]) throws JsonProcessingException, ParseException {
        //SimpleDateFormat formatter = new SimpleDateFormat("E L d H:m:s z y");
        //String d = "Wed Mar 23 06:02:15 MSK 2022";
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d H:m:s z y", Locale.ENGLISH);
        // E L d H:m:s z Y
        // java/text/SimpleDateFormat.java
        String d = "Wed Mar 23 06:02:15 MSK 2022";



        Date d1 = formatter.parse(d);
        System.out.println(d1.toString());

    }
}
