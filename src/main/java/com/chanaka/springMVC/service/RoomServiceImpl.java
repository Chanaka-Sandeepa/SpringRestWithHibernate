package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.dao.RoomDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chanaka.springMVC.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    @Transactional
    public void addRoom(Room p) {
        this.roomDAO.addRoom(p);
    }

    @Override
    @Transactional
    public void updateRoom(Room p) {
        this.roomDAO.updateRoom(p);
    }

    @Override
    @Transactional
    public List<Room> listRooms() {
        return this.roomDAO.listRooms();
    }

    @Override
    @Transactional
    public Room getRoomById(int id) {
        return this.roomDAO.getRoomById(id);
    }

    @Override
    @Transactional
    public void removeRoom(int id) {
        this.roomDAO.removeRoom(id);
    }

}
