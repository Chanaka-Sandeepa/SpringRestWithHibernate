package com.chanaka.springMVC.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoomID implements Serializable{

    private Integer contractID;

    private Integer roomTypeID;

}
