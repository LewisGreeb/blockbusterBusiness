package com.sakila.lewis.blockbusterBusiness.Store;

import com.sakila.lewis.blockbusterBusiness.Inventory.Inventory;
import com.sakila.lewis.blockbusterBusiness.Location.Address.Address;
import com.sakila.lewis.blockbusterBusiness.Store.Staff.Staff;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="store")
public class Store {

    // Identifier attribute.
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Store attributes.
    @Column(name = "manager_staff_id")
    private int managerStaffID;
    @Column(name = "address_id")
    private int addressID;

    // Linking attribute - staff.
    @OneToMany
    @JoinColumn(name = "store_id")
    private Set<Staff> staff;

    // Linking attribute - inventory.
    @OneToMany
    @JoinColumn(name = "store_id")
    private Set<Inventory> inventory;

    // Linking attribute - address.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    // Default constructor.
    public Store(){}
    // Parameter constructor.
    public Store(int managerStaffID, int addressID){
        this.managerStaffID = managerStaffID;
        this.addressID = addressID;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(int managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Inventory> inventory) {
        this.inventory = inventory;
    }
}
