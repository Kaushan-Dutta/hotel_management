package com.hotel_mng.hotel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_mng.hotel.dto.HotelContactDto;
import com.hotel_mng.hotel.dto.HotelDto;
import com.hotel_mng.hotel.dto.MealDto;
import com.hotel_mng.hotel.entity.Meal;
import com.hotel_mng.hotel.services.HotelSer;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelSer hotelSer;

    public HotelController(HotelSer hotelSer) {
        this.hotelSer = hotelSer;
    }

    @GetMapping(path = "/{id}")
    public HotelDto getHotel(@PathVariable("id") int hotelId) {
        return hotelSer.getHotelById(hotelId);
    }

    @PostMapping(path = "")
    public HotelDto createHotel(@RequestBody HotelDto hotelDto) {
        System.out.println("Hotel Dto" + hotelDto);
        return hotelSer.createHotel(hotelDto);
    }

    @PostMapping(path = "/{id}/contact")
    public Object updateContact(@PathVariable int id, @RequestBody HotelContactDto contact) {
        System.out.println("Contact is" + contact);
        return hotelSer.updateContact(id, contact);
    }

    @PostMapping("/{id}/meal")
    public List<MealDto> createMeal(@PathVariable int id, @RequestBody MealDto mealDto) {
        System.out.println("Meal is " + mealDto);
        return hotelSer.createMeal(id, mealDto);
    }

    // @GetMapping("/{id}/meal")
    // public List<Meal> getMeals(@PathVariable String hotelId) {
    //     System.out.println("Hotel is " + hotelId);
    //     return hotelSer.getMeal(hotelId);
    // }
}
