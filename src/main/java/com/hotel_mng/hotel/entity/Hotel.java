package com.hotel_mng.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    private HotelContact contact;

    public Hotel() {
    }

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and Setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter methods for contact
    public HotelContact getContact() {
        return contact;
    }

    public void setContact(HotelContact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Hotel [address=" + address + ", contact=" + contact + ", id=" + id + ", name=" + name + "]";
    }

}
