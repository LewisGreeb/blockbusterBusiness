package com.sakila.lewis.blockbusterBusiness.Rental;

import javax.persistence.*;

@Entity
@Table(name="rental")
public class Rental {

    // Identifier attribute.
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes for rental.
    @Column(name = "rental_date")
    private String rentalDate;
    @Column(name = "inventory_id")
    private int inventoryID;
    @Column(name = "customer_id")
    private int customerID;
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "staff_id")
    private int staffID;

    // Default constructor.
    public Rental(){}
    // Parameter constructor.
    public Rental(String rentalDate, int inventoryID, int customerID, String returnDate, int staffID){
        this.rentalDate = rentalDate;
        this.inventoryID = inventoryID;
        this.customerID = customerID;
        this.returnDate = returnDate;
        this.staffID = staffID;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
}
