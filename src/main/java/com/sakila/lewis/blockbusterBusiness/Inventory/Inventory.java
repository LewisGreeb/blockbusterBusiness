package com.sakila.lewis.blockbusterBusiness.Inventory;

import com.sakila.lewis.blockbusterBusiness.Store.Store;

import javax.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    // Identifier attribute.
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes stored in inventory.
    @Column(name = "film_id")
    private int filmID;
    @Column(name = "store_id")
    private int storeID;


    // Linking attribute - store.
    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    // Default constructor.
    public Inventory(){}
    // Parameter constructor.
    public Inventory(int filmID, int storeID){
        this.filmID = filmID;
        this.storeID = storeID;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
}
