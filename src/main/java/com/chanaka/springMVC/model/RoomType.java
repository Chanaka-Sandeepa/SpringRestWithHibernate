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
@Table(name="CW_ROOM_TYPE")
public class RoomType {

    @Id
    @Column(name = "ROOM_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CW_ROOM_TYPE_SEQ")
    @SequenceGenerator(name = "CW_ROOM_TYPE_SEQ", sequenceName = "CW_ROOM_TYPE_SEQ", allocationSize = 1, initialValue = 3)
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="MAX_ADULTS")
    private int max_adults;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false, foreignKey = @ForeignKey(name="CW_ROOM_TYPE_HOTEL_FK"))
    private Hotel hotel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_adults() {
        return max_adults;
    }

    public void setMax_adults(int max_adults) {
        this.max_adults = max_adults;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

//    @Override
//    public String toString(){
//        return "id="+id+", name="+name+", country="+country;
//    }
}
