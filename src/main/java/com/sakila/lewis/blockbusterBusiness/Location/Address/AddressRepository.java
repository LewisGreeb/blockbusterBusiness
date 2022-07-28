package com.sakila.lewis.blockbusterBusiness.Location.Address;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByAddressContains(String address);

}
