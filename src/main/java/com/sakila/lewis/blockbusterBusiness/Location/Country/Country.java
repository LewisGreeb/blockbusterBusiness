package com.sakila.lewis.blockbusterBusiness.Location.Country;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {

    // Identifier attribute.
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Country attributes.
    private String country;

    // Default constructor.
    public Country(){}
    // Parameter constructor.
    public Country(String country){
        this.country = country;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
