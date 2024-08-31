package com.hotel_mng.hotel.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class HotelContact {

    private String phone;
    private String email;
    private String website;

    public HotelContact() {
    }

    public HotelContact(String phone, String email, String website) {
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "HotelContact [email=" + email + ", phone=" + phone + ", website=" + website + "]";
    }
}
