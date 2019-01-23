package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.model.Hotel;

public interface HotelService {

    public void addHotel(Hotel p);
    public void updateHotel(Hotel p);
    public List<Hotel> listHotels();
    public Hotel getHotelById(int id);
    public void removeHotel(int id);

}
