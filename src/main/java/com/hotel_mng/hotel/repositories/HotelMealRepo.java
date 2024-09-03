package com.hotel_mng.hotel.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel_mng.hotel.entity.Meal;

@Repository
public interface HotelMealRepo extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m order by name")
    public Set<Meal> findAllMeals();
}
