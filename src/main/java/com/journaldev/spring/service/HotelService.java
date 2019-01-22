package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Hotel;

public interface HotelService {

    public void addHotel(Hotel p);
    public void updateHotel(Hotel p);
    public List<Hotel> listHotels();
    public Hotel getHotelById(int id);
    public void removeHotel(int id);

}
