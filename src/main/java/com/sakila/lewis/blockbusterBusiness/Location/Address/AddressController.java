package com.sakila.lewis.blockbusterBusiness.Location.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    // Add new address.
    @PostMapping("/AddAddress")
    public @ResponseBody String addAddress(@RequestParam String address, @RequestParam String district, @RequestParam int cityID,
                                           @RequestParam String postalCode, @RequestParam String phone){
        Address addressObj = new Address(address, district, cityID, postalCode, phone);
        addressRepository.save(addressObj);
        return "success";
    }

    // Get all address.
    @GetMapping("/AllAddresses")
    public @ResponseBody Iterable<Address>getAllAddress(){
        return addressRepository.findAll();
    }

    // Get address by ID.
    @GetMapping("/AddressByID")
    public @ResponseBody Optional<Address> getAddressById(@RequestParam int id){
        return addressRepository.findById(id);
    }

    // Get address containing string.
    @GetMapping("/AddressContains")
    public @ResponseBody List<Address> getAddressContains(@RequestParam String address){
        return addressRepository.findByAddressContains(address);
    }

    // Update address field.
    @PatchMapping("/UpdateAddressLine")
    public @ResponseBody Address updateAddressLine(@RequestParam int id, @RequestParam String address){
        Address addressObj = addressRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No address exists with that id."));
        addressObj.setAddress(address);
        return addressRepository.save(addressObj);
    }

    // Delete address.
    @DeleteMapping("/DeleteAddress")
    public @ResponseBody String deleteAddress(@RequestParam int id){
        addressRepository.deleteById(id);
        return "success";
    }

}
