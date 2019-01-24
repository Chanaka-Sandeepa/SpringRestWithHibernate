package com.chanaka.springMVC.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import com.chanaka.springMVC.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAOImpl implements RoomDAO{

    private static final Logger logger = LoggerFactory.getLogger(RoomDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRoom(Room h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(h);
        logger.info("Room saved successfully, Room Details="+h);
    }

    @Override
    public void updateRoom(Room h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(h);
        logger.info("Room updated successfully, Room Details="+h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> listRooms() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Room> roomList = session.createQuery("from Room").list();
        for(Room h : roomList){
            logger.info("Room List::"+h);
        }
        return roomList;
    }

    @Override
    public Room getRoomById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Room p = (Room) session.load(Room.class, new Integer(id));
        logger.info("Room loaded successfully, Room details="+p);
        return p;
    }

    @Override
    public void removeRoom(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Room p = (Room) session.load(Room.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Room deleted successfully, room details="+p);
    }

    @Override
    public List<Room> searchRoom(String checkIn, String checkOut) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Room> roomList = session.createQuery("FROM Room AS r LEFT JOIN Contract as c ON r.contractID = c.id WHERE r.startDate AND r.endDate BETWEEN :stDate AND :edDate ")
                .setParameter("stDate", checkIn)
                .setParameter("edDate", checkOut)
                .list();
        for(Room h : roomList){
            logger.info("Room List::"+h);
        }
        return roomList;
    }
}
