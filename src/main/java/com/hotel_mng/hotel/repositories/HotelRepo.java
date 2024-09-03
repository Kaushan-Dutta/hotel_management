package com.hotel_mng.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel_mng.hotel.entity.Hotel;
import com.hotel_mng.hotel.entity.HotelContact;

import jakarta.transaction.Transactional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Hotel h SET h.contact = :contact WHERE h.id = :id")
    Object updateHotelContact(int id, HotelContact contact);

    // @Modifying
    // @Transactional
    // @Query("UPDATE Hotel h SET h.meal = :meal WHERE h.id = :id")
    // Object updateHotelMeal(int id, Meal meal);
}
