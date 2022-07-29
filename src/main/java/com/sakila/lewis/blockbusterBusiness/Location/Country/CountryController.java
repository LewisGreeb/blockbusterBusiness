package com.sakila.lewis.blockbusterBusiness.Location.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    // Add new country.
    @PostMapping("/AddCountry")
    public @ResponseBody String addCountry(@RequestParam String country){
        Country countryObj = new Country(country);
        countryRepository.save(countryObj);
        return "success";
    }

    // Get all countries.
    @GetMapping("/AllCountries")
    public @ResponseBody Iterable<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    // Get country by ID.
    @GetMapping("/GetCountryByID")
    public @ResponseBody Optional<Country> getCountryById(@RequestParam int id){
        return countryRepository.findById(id);
    }

    // Update country.
    @PatchMapping("/UpdateCountryName")
    public @ResponseBody Country updateCountryById(@RequestParam int id, @RequestParam String name){
        Country countryObj = countryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No city exists with that id."));
        countryObj.setCountry(name);
        return countryRepository.save(countryObj);
    }

    @DeleteMapping("/DeleteCountryByID")
    public @ResponseBody String deleteCountryByID(@RequestParam int id){
        countryRepository.deleteById(id);
        return "success";
    }

}