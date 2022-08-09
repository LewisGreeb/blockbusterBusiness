package com.sakila.lewis.blockbusterBusiness.Store.Staff;

import com.sakila.lewis.blockbusterBusiness.Location.Address.Address;
import com.sakila.lewis.blockbusterBusiness.Store.Store;

import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff {

    // Identifier attribute.
    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Staff attributes.
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address_id")
    private int addressID;
    private byte[] picture;
    private String email;
    @Column(name = "store_id")
    private int storeID;
    private int active;
    private String username;
    private String password;

    // Linking attribute - store.
    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    // Linking attribute - address.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    // Default constructor.
    public Staff(){}
    // Parameter constructor.
    public Staff(String firstName, String lastName, int addressID, String email, int storeID,
                 int active, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressID = addressID;
        this.email = email;
        this.storeID = storeID;
        this.active = active;
        this.username = username;
        this.password = password;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
/*
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
