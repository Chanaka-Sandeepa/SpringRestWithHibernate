package com.chanaka.springMVC.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
