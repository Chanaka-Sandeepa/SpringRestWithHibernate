package com.chanaka.springMVC.Util;

import com.chanaka.springMVC.model.ResultRoomObject;
import com.chanaka.springMVC.model.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {

    public static double MARKUP = 0.2;

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

    public static List<ResultRoomObject> formatToResultObjects(List<Room> resultRooms){
        List<ResultRoomObject> resultRoomObjects = new ArrayList<ResultRoomObject>();
        for(Room r : resultRooms){
            ResultRoomObject resultRoomObject = new ResultRoomObject();
            resultRoomObject.setHotelName(r.getContract().getHotel().getName());
            resultRoomObject.setRoomType(r.getRoomType().getName());
//            resultRoomObject.setMarkedUpPrice(calculateMarkup(r.getPrice()));
            resultRoomObject.setMarkedUpWithCurrency(String.valueOf(calculateMarkup(r.getPrice()))+" "+r.getContract().getCurrency());
            resultRoomObject.setAvailability("Available now");
            resultRoomObjects.add(resultRoomObject);
        }
        return resultRoomObjects;
    }

    public static double calculateMarkup(double price){
        return (price + price*MARKUP);
    }

}
