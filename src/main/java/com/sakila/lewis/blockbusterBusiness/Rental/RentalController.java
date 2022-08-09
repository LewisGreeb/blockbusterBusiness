package com.sakila.lewis.blockbusterBusiness.Rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    RentalRepository rentalRepository;

    public RentalController(RentalRepository rentalRepository){
        this.rentalRepository = rentalRepository;
    }

    // Add rental.


    // Get all rentals.


    // Get rental by ID.


}
