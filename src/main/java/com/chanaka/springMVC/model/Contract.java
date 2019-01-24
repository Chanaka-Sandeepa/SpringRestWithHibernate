package com.chanaka.springMVC.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author chanakaw
 *
 */
@Entity
@Table(name="CW_CONTRACT")
public class Contract {

    @Id
    @Column(name = "CONTRACT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CW_CONTRACT_SEQ")
    @SequenceGenerator(name = "CW_CONTRACT_SEQ", sequenceName = "CW_CONTRACT_SEQ", allocationSize = 1, initialValue = 3)
    private int id;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false, foreignKey = @ForeignKey(name="CW_CONTRACT_HOTEL_FK"))
    private Hotel hotel;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;

    @Column(name="CURRENCY")
    private String currency;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString(){
        return "id="+id+", hotel="+hotel+", country="+startDate+", end date="+endDate+", currency="+currency;
    }
}
