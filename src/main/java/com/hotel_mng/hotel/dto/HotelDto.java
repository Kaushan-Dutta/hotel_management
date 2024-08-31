package com.hotel_mng.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private int id;
    private String name;
    private String address;

    private HotelContactDto contact;

    public HotelDto(int id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public HotelDto(int id, HotelContactDto contact) {
        this.contact = contact;
        this.id = id;
    }
}
