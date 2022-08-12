package com.springboot.studentdetails.repository;

import com.springboot.studentdetails.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
