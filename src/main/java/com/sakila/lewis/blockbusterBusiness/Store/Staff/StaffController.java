package com.sakila.lewis.blockbusterBusiness.Store.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    // Add new staff.
    @PostMapping("/AddStaff")
    public @ResponseBody String addStaff(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int addressID,
                                         @RequestParam String email, @RequestParam int storeID, @RequestParam int active,
                                         @RequestParam String username, @RequestParam String password){
        Staff staff = new Staff(firstName, lastName, addressID, email, storeID, active, username, password);
        staffRepository.save(staff);
        return "success";
    }

    // Get all staff.
    @GetMapping("/AllStaff")
    public @ResponseBody Iterable<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    // Get staff by ID.
    @GetMapping("/GetStaffByID")
    public @ResponseBody Optional<Staff> getStaffByID(@RequestParam int id){
        return staffRepository.findById(id);
    }

    // Update staff name.
    @PatchMapping("/UpdateStaffName")
    public @ResponseBody Staff updateStaffName(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Staff staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No store exists with that id."));
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        return staffRepository.save(staff);
    }

    // Update staff address ID.
    @PatchMapping("/UpdateStaffAddress")
    public @ResponseBody Staff updateStaffAddress(@RequestParam int id, @RequestParam int addressID){
        Staff staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No store exists with that id."));
        staff.setAddressID(addressID);
        return staffRepository.save(staff);
    }

    // Update staff email.
    @PatchMapping("/UpdateStaffEmail")
    public @ResponseBody Staff updateStaffEmail(@RequestParam int id, @RequestParam String email){
        Staff staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No store exists with that id."));
        staff.setEmail(email);
        return staffRepository.save(staff);
    }

    // Delete staff.
    @DeleteMapping("/DeleteStaffByID")
    public @ResponseBody String deleteStaffById(@RequestParam int id){
        staffRepository.deleteById(id);
        return "success";
    }


}
