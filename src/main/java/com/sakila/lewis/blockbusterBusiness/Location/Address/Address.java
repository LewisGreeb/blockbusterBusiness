package com.sakila.lewis.blockbusterBusiness.Location.Address;


import com.sakila.lewis.blockbusterBusiness.Location.City.City;
import com.sakila.lewis.blockbusterBusiness.Location.Country.Country;
import com.sakila.lewis.blockbusterBusiness.Store.Staff.Staff;
import com.sakila.lewis.blockbusterBusiness.Store.Store;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="address")
public class Address {

    // Identifier attribute.
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Address attributes.
    private String address;
    private String district;
    @Column(name = "city_id")
    private int cityID;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;

    private byte[] location;

    // Linking attribute - city.
    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    // Linking attribute - store.
    @OneToOne(mappedBy = "address")
    private Store store;

    // Linking attribute - staff.
    @OneToOne(mappedBy = "address")
    private Staff staff;

    // Default constructor.
    public Address(){}
    // Parameter constructor.
    public Address(String address, String district, int cityID, String postalCode, String phone){
        this.address = address;
        this.district = district;
        this.cityID = cityID;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
