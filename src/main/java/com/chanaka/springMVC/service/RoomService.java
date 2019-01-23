package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.model.Room;

public interface RoomService {

    public void addRoom(Room p);
    public void updateRoom(Room p);
    public List<Room> listRooms();
    public Room getRoomById(int id);
    public void removeRoom(int id);

}