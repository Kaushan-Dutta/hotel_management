package com.hotel_mng.hotel.dto;

import com.hotel_mng.hotel.entity.Meal.MealType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {

    private int id;
    private String name;
    private int cost;
    private MealType mealType;
    private int hotelId;
}
