package com.assignment.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String username;
    private String email;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
    private String phone;
    private String website;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;

//    @OneToOne
//    @JoinColumn(name = "address_id", nullable = true)
//    public Address getAddress() {
//        return address;
//    }

//    @OneToOne
//    @JoinColumn(name = "company_id", nullable = true)
//    public Company getCompany() {
//        return company;
//    }

    public Person(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Person(int id, String name, String username, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public Person() {
        this.address = new Address();
        this.company = new Company();

    }
}

