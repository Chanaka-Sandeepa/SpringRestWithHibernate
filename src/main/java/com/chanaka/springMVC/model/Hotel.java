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
@Table(name="CW_HOTEL")
public class Hotel {

    @Id
    @Column(name = "HOTEL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CW_HOTEL_SEQ")
    @SequenceGenerator(name = "CW_HOTEL_SEQ", sequenceName = "CW_HOTEL_SEQ", allocationSize = 1, initialValue = 3)
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="CITY")
    private String city;

    @Column(name="COUNTRY")
    private String country;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="CONTRACT_ID")
    private List<Contract> contracts;

    public List<RoomType> getRoom_types() {
        return room_types;
    }

    public void setRoom_types(List<RoomType> room_types) {
        this.room_types = room_types;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="ROOM_TYPE_ID")
    private List<RoomType> room_types;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country;
    }
}
