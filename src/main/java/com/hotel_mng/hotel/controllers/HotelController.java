package com.hotel_mng.hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_mng.hotel.dto.HotelContactDto;
import com.hotel_mng.hotel.dto.HotelDto;
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

    @PostMapping(path = "/")
    public HotelDto createHotel(@RequestBody HotelDto hotelDto) {
        // System.out.println(hotelDto);
        return hotelSer.createHotel(hotelDto);
    }

    @PostMapping(path = "/{id}/contact")
    public Object updateContact(@PathVariable int id, @RequestBody HotelContactDto contact) {
        System.out.println("Contact is" + contact);
        return hotelSer.updateContact(id, contact);
    }

}
