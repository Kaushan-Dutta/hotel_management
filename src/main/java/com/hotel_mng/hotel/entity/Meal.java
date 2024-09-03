package com.hotel_mng.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "meal_name")
    private String name;
    private int cost;

    public enum MealType {
        BREAKFAST,
        LUNCH,
        DINNER
    }

    private MealType mealType;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Meal() {
    }

    public Meal(String name, int cost, MealType mealType, Hotel hotel) {
        this.name = name;
        this.cost = cost;
        this.mealType = mealType;
        this.hotel = hotel;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Meal [cost=" + cost + ", id=" + id + ", mealType=" + mealType + ", name=" + name + "]";
    }
}
