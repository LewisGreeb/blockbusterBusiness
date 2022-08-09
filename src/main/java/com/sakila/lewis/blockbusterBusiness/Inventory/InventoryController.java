package com.sakila.lewis.blockbusterBusiness.Inventory;

import com.sakila.lewis.blockbusterBusiness.Location.Address.Address;
import com.sakila.lewis.blockbusterBusiness.Store.Staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    // Add inventory.
    @PostMapping("/AddInventory")
    public @ResponseBody String addInventory(@RequestParam int filmID, @RequestParam int storeID){
        Inventory inventory = new Inventory(filmID, storeID);
        inventoryRepository.save(inventory);
        return "success";
    }

    // Get all inventory.
    @GetMapping("/AllInventory")
    public @ResponseBody Iterable<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    // Get inventory by ID.
    @GetMapping("/InventoryByID")
    public @ResponseBody Optional<Inventory> getInventoryByID(@RequestParam int id){
        return inventoryRepository.findById(id);
    }

    // Get inventory by film ID.
    @GetMapping("/InventoryByFilmID")
    public @ResponseBody List<Inventory> getInventoryByFilmID(@RequestParam int id){
        return inventoryRepository.findByFilmID(id);
    }

    // Update inventory.
    @PatchMapping("/UpdateInventoryByID")
    public @ResponseBody Inventory updateInventory(@RequestParam int id, @RequestParam int filmID, @RequestParam int storeID){
        Inventory inv = inventoryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No inventory entry exists with that id."));
        inv.setFilmID(filmID);
        inv.setStoreID(storeID);
        return inventoryRepository.save(inv);
    }

    // Delete inventory.
    @DeleteMapping("/DeleteInventory")
    public @ResponseBody String deleteInventory(@RequestParam int id){
        inventoryRepository.deleteById(id);
        return "success";
    }
}
