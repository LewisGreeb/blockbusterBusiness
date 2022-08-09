package com.sakila.lewis.blockbusterBusiness.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // Create new customer.
    @PostMapping("/AddCustomer")
    public @ResponseBody String addCustomer(@RequestParam int storeID, @RequestParam String firstName,
                                            @RequestParam String lastName, @RequestParam String email,
                                            @RequestParam int addressID, @RequestParam int active,
                                            @RequestParam String createDate){
        Customer cust = new Customer(storeID, firstName, lastName, email, addressID, active, createDate);
        customerRepository.save(cust);
        return "success";
    }

    // Get all customers.
    @GetMapping("/AllCustomers")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    // Get customer by ID.
    @GetMapping("/GetCustomerByID")
    public @ResponseBody Optional<Customer> getCustomerByID(@RequestParam int id){
        return customerRepository.findById(id);
    }

    // Get customer by first name and last name.
    @GetMapping("/GetCustomerByName")
    public @ResponseBody List<Customer> getCustomerByName(@RequestParam String firstName, @RequestParam String lastName){
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Update customer name.
    @PatchMapping("/UpdateCustomerName")
    public @ResponseBody Customer updateCustomer(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Customer cust = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No customer exists with that id."));
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        return customerRepository.save(cust);
    }

    // Delete customer by ID.
    @DeleteMapping("/DeleteCustomer")
    public @ResponseBody String deleteCustomer(@RequestParam int id){
        customerRepository.deleteById(id);
        return "success";
    }

}