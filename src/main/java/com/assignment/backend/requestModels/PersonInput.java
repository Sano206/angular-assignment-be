package com.assignment.backend.requestModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInput {

    private String name;
    private String username;
    private String email;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String phone;
    private String website;
    private String companyName;
    private String catchPhrase;
    private String bs;
    private String lat;
    private String lng;

    public PersonInput(String name, String username, String email, String street, String suite, String city, String zipcode, String phone, String website, String companyName, String catchPhrase, String bs, String lat, String lng) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
        this.companyName = companyName;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
        this.lat = lat;
        this.lng = lng;
    }

    public PersonInput() {

    }
}

