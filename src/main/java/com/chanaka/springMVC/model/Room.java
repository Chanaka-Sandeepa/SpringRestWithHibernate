package com.chanaka.springMVC.model;

import javax.persistence.*;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author chanakaw
 *
 */
@Entity
@Table(name="CW_ROOM")
public class Room {

    @EmbeddedId
    private RoomID roomID;

    @ManyToOne
    @JoinColumn(name="CONTRACT_ID")
    @MapsId("contractID")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="ROOM_TYPE_ID")
    @MapsId("roomTypeID")
    private RoomType roomType;

    @Column(name="NO_OF_ROOMS")
    private String noOfRooms;

    @Column(name="PRICE")
    private String price;

    public RoomID getRoomID() {
        return roomID;
    }

    public void setRoomID(RoomID roomID) {
        this.roomID = roomID;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
