package com.sakila.lewis.blockbusterBusiness.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    // Add new store.
    @PostMapping("/AddStore")
    public @ResponseBody String addStore(@RequestParam int managerStaffID, @RequestParam int addressID){
        Store store = new Store(managerStaffID, addressID);
        storeRepository.save(store);
        return "success";
    }

    // Get all stores.
    @GetMapping("/AllStores")
    public @ResponseBody Iterable<Store> getAllStores(){
        return storeRepository.findAll();
    }

    // Get store by ID.
    @GetMapping("/GetStoreByID")
    public @ResponseBody Optional<Store> getStoreById(@RequestParam int id){
        return storeRepository.findById(id);
    }

    @PatchMapping("/ChangeManagerID")
    public @ResponseBody Store changeManagerID(@RequestParam int id, @RequestParam int managerID){
        Store store = storeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No store exists with that id."));
        store.setManagerStaffID(managerID);
        return storeRepository.save(store);
    }

    @PatchMapping("/ChangeStoreLocation")
    public @ResponseBody Store changeStoreLocation(@RequestParam int id, @RequestParam int addressID){
        Store store = storeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No store exists with that id."));
        store.setAddressID(addressID);
        return storeRepository.save(store);
    }

    @DeleteMapping("/DeleteStore")
    public @ResponseBody String deleteStore(@RequestParam int id){
        storeRepository.deleteById(id);
        return "success";
    }
}
