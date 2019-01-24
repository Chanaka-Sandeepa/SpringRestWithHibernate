package com.chanaka.springMVC.model;

public class ResultRoomObject {
    private String hotelName;
    private String RoomType;
//    private double markedUpPrice;
    private String price;  // marked up price
    private String availability;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

//    public double getMarkedUpPrice() {
//        return markedUpPrice;
//    }
//
//    public void setMarkedUpPrice(double markedUpPrice) {
//        this.markedUpPrice = markedUpPrice;
//    }

    public String getMarkedUpWithCurrency() {
        return price;
    }

    public void setMarkedUpWithCurrency(String markedUpWithCurrency) {
        this.price = markedUpWithCurrency;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
