package com.sakila.lewis.blockbusterBusiness.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="customer")
public class Customer {

    // Identifier attribute.
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Customer attributes.
    @Column(name = "store_id")
    private int storeID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "address_id")
    private int addressID;
    private int active;
    @Column(name = "create_date")
    private String createDate;

    // Default constructor.
    public Customer(){}
    // Parameter constructor.
    public Customer(int storeID, String firstName, String lastName, String email,
                    int addressID, int active, String createDate){
        this.storeID = storeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressID = addressID;
        this.active = active;
        this.createDate = createDate;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
