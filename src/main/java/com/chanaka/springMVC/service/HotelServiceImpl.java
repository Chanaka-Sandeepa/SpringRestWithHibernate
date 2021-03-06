package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.dao.HotelDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chanaka.springMVC.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelDAO hotelDAO;

    public void setHotelDAO(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    @Transactional
    public void addHotel(Hotel p) {
        this.hotelDAO.addHotel(p);
    }

    @Override
    @Transactional
    public void updateHotel(Hotel p) {
        this.hotelDAO.updateHotel(p);
    }

    @Override
    @Transactional
    public List<Hotel> listHotels() {
        return this.hotelDAO.listHotels();
    }

    @Override
    @Transactional
    public Hotel getHotelById(int id) {
        return this.hotelDAO.getHotelById(id);
    }

    @Override
    @Transactional
    public void removeHotel(int id) {
        this.hotelDAO.removeHotel(id);
    }

}
