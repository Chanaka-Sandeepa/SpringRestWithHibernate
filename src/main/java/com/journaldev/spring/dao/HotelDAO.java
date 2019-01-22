package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Hotel;

public interface HotelDAO {

    public void addHotel(Hotel h);
    public void updateHotel(Hotel h);
    public List<Hotel> listHotels();
    public Hotel getHotelById(int id);
    public void removeHotel(int id);
}