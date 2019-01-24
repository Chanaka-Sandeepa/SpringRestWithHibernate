package com.chanaka.springMVC.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

    public static Date convertStringToDate(String date){
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date dateDate= df.parse(date);
            return dateDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date calculateCheckoutDate(Date stDate, String noOfNights){
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stDate);
        calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(noOfNights));
        System.out.println(calendar.getTime());
        return calendar.getTime();
    }
}
