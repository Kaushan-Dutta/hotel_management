package com.hotel_mng.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotel_mng.hotel.interfaces.SwitchMode;

@SpringBootApplication
public class HotelManagementApplication implements CommandLineRunner {

    @Autowired
    private SwitchMode mode;

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementApplication.class, args);
        System.out.println("Server is running on port 8080");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(mode.getMode());
    }
}
