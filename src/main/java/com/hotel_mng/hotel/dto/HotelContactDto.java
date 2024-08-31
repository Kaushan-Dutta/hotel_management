package com.hotel_mng.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelContactDto {

    private String email;
    private String website;
    private String phone;

}
