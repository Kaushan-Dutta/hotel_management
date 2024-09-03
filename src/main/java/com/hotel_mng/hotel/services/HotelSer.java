package com.hotel_mng.hotel.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel_mng.hotel.dto.HotelContactDto;
import com.hotel_mng.hotel.dto.HotelDto;
import com.hotel_mng.hotel.dto.MealDto;
import com.hotel_mng.hotel.entity.Hotel;
import com.hotel_mng.hotel.entity.HotelContact;
import com.hotel_mng.hotel.entity.Meal;
import com.hotel_mng.hotel.entity.Meal.MealType;
import com.hotel_mng.hotel.repositories.HotelMealRepo;
import com.hotel_mng.hotel.repositories.HotelRepo;

@Service
public class HotelSer {

    final HotelRepo hotelRepo;
    final HotelMealRepo hotelMealRepo;

    public HotelSer(HotelRepo hotelRepo, HotelMealRepo hotelMealRepo) {
        this.hotelRepo = hotelRepo;
        this.hotelMealRepo = hotelMealRepo;
    }

    public HotelDto getHotelById(int hotelId) {
        Hotel hotel = hotelRepo.findById(hotelId).orElse(null);
        return new HotelDto(hotel.getId(), hotel.getName(), hotel.getAddress());
    }

    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel(hotelDto.getName(), hotelDto.getAddress());
        hotelRepo.save(hotel);
        return new HotelDto(hotel.getId(), hotel.getName(), hotel.getAddress());
    }

    public Object updateContact(int id, HotelContactDto contactDto) {
        HotelContact hotelContact = new HotelContact(contactDto.getEmail(), contactDto.getWebsite(), contactDto.getPhone());
        hotelRepo.updateHotelContact(id, hotelContact);
        return new HotelDto(id, contactDto);
    }

    private List<MealDto> filterMeals(List<Meal> allMeals) {
        return allMeals.stream()
                .map(m -> new MealDto(
                m.getId(),
                m.getName(),
                m.getCost(),
                m.getMealType(),
                m.getHotel().getId()
        ))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MealDto> createMeal(int id, MealDto mealDto) {
        Hotel hotel = hotelRepo.findById(id).orElse(null);
        Meal meal = new Meal(
                mealDto.getName(),
                mealDto.getCost(),
                mealDto.getMealType(),
                hotel
        );
        System.out.println("Meal is " + meal);
        hotelMealRepo.save(meal);

        hotel.setMeal(meal);
        System.out.println("Hotel is " + hotel.getMeals());

        hotelRepo.save(hotel);

        List<Meal> allMeals = hotelMealRepo.findAll();
        System.out.println("All meals are " + allMeals);
        return filterMeals(allMeals);
    }

    // public List<Meal> getMeal(String hotelId) {
    //     Hotel hotel = hotelRepo.findById(Integer.parseInt(hotelId)).orElse(null);
    //     return hotel.getMeals();
    // }
}
