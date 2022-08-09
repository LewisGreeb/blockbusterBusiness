package com.sakila.lewis.blockbusterBusiness.Location.City;

import com.sakila.lewis.blockbusterBusiness.Location.Address.Address;
import com.sakila.lewis.blockbusterBusiness.Location.Country.Country;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="city")
public class City {

    // Identifier attribute.
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // City attributes.
    private String city;
    @Column(name = "country_id")
    private int countryID;

    // Linking attribute - country.
    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    // Linking attribute - address.
    @OneToMany
    @JoinColumn(name = "city_id")
    private Set<Address> addresses;

    // Default constructor.
    public City(){}
    // Parameter constructor.
    public City(String city, int country_id){
        this.city = city;
        this.countryID = country_id;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return countryID;
    }

    public void setCountry_id(int countryID) {
        this.countryID = countryID;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
