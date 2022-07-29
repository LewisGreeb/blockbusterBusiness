package com.sakila.lewis.blockbusterBusiness.Location.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    // Add new city.
    @PostMapping("/AddCity")
    public @ResponseBody String addCity(@RequestParam String city, @RequestParam int countryID){
        City cityObj = new City(city, countryID);
        cityRepository.save(cityObj);
        return "success";
    }

    // Get all cities.
    @GetMapping("/AllCities")
    public @ResponseBody Iterable<City> getAllCities(){
        return cityRepository.findAll();
    }

    // Get city by ID.
    @GetMapping("/GetCityByID")
    public @ResponseBody Optional<City> getCityById(@RequestParam int id){
        return cityRepository.findById(id);
    }

    // Update city name.
    @PatchMapping("/UpdateCityName")
    public @ResponseBody City updateCityName(@RequestParam int id, @RequestParam String name){
        City cityObj = cityRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No city exists with that id."));
        cityObj.setCity(name);
        return cityRepository.save(cityObj);
    }

    // Delete city name.
    @DeleteMapping("/DeleteCityByID")
    public @ResponseBody String deleteCity(@RequestParam int id){
        cityRepository.deleteById(id);
        return "success";
    }

}
