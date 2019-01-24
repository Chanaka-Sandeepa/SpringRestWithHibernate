package com.chanaka.springMVC.dao;

import java.util.Date;
import java.util.List;

import com.chanaka.springMVC.model.Room;

public interface RoomDAO {

    public void addRoom(Room h);
    public void updateRoom(Room h);
    public List<Room> listRooms();
    public List<Room> searchRoom(Date checkIn, Date checkOut);
    public Room getRoomById(int id);
    public void removeRoom(int id);
}