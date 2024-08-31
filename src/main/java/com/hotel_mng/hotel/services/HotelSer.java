package com.hotel_mng.hotel.services;

import org.springframework.stereotype.Service;

import com.hotel_mng.hotel.dto.HotelContactDto;
import com.hotel_mng.hotel.dto.HotelDto;
import com.hotel_mng.hotel.entity.Hotel;
import com.hotel_mng.hotel.entity.HotelContact;
import com.hotel_mng.hotel.repositories.HotelRepo;

@Service
public class HotelSer {

    final HotelRepo hotelRepo;

    public HotelSer(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
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
}
