package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Hotel;

@Repository
public class HotelDAOImpl implements HotelDAO {

    private static final Logger logger = LoggerFactory.getLogger(HotelDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addHotel(Hotel h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(h);
        logger.info("Hotel saved successfully, Hotel Details="+h);
    }

    @Override
    public void updateHotel(Hotel h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(h);
        logger.info("Hotel updated successfully, Hotel Details="+h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> listHotels() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Hotel> hotelList = session.createQuery("from Hotel").list();
        for(Hotel h : hotelList){
            logger.info("Hotel List::"+h);
        }
        return hotelList;
    }

    @Override
    public Hotel getHotelById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Hotel p = (Hotel) session.load(Hotel.class, new Integer(id));
        logger.info("Hotel loaded successfully, Hotel details="+p);
        return p;
    }

    @Override
    public void removeHotel(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Hotel p = (Hotel) session.load(Hotel.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Hotel deleted successfully, hotel details="+p);
    }

}
