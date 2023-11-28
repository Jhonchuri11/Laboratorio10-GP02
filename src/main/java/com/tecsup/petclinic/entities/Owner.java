package com.tecsup.petclinic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "owners")
@Data
public class Owner {

    // Campos Tabla
    // id
    // first_name
    // last_name
    // address
    // city
    // telephone
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    public Owner() {

    }

    public Owner(int id, String first_name, String last_name, String address, String city, String telephone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

}
