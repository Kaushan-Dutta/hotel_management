package com.hotel_mng.hotel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    @RequestMapping("/")
    @ResponseBody
    public String handle() {
        return "Welcome to Hotel Management System";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String handletest() {
        return "Test Body";
    }
}
