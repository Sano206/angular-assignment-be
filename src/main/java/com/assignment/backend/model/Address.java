package com.assignment.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int address_id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "geo_id")
    private Geo geo;


//    @OneToOne
//    @JoinColumn(name = "geo_id", nullable = true)
//    public Geo getGeo() {
//        return geo;
//    }

    public Address() {
        this.geo = new Geo();
    }

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}

