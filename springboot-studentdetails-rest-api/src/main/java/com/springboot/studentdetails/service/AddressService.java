package com.springboot.studentdetails.service;

import com.springboot.studentdetails.payload.AddressDto;

public interface AddressService {
    AddressDto createAddress (long studentId, AddressDto addressDto);
}
