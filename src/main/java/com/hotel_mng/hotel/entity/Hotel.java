package com.hotel_mng.hotel.entity;

// import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    private HotelContact contact;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Meal> meals = new HashSet<>();

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

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeal(Meal meal) {
        this.meals.add(meal);
    }

    @Override
    public String toString() {
        return "Hotel [address=" + address + ", contact=" + contact + ", id=" + id + ", name=" + name + "]";
    }

}
