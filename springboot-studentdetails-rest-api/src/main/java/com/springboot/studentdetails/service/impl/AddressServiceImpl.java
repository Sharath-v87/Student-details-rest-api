package com.springboot.studentdetails.service.impl;

import com.springboot.studentdetails.entity.Address;
import com.springboot.studentdetails.entity.Student;
import com.springboot.studentdetails.exceptions.ResourceNotFoundException;
import com.springboot.studentdetails.payload.AddressDto;
import com.springboot.studentdetails.repository.AddressRepository;
import com.springboot.studentdetails.repository.StudentRepository;
import com.springboot.studentdetails.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private StudentRepository studentRepository;

    public AddressServiceImpl(AddressRepository addressRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public AddressDto createAddress(long studentId, AddressDto addressDto) {

        Address address = mapToEntity(addressDto);

        Student student =  studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","id",studentId));
        address.setStudent(student);
        Address newaddress = addressRepository.save(address);
        return mapToDto(newaddress);
    }

    private AddressDto mapToDto (Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setAddress(address.getAddress());
        return addressDto;
    }

    private  Address mapToEntity(AddressDto addressDto){
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddress(address.getAddress());
        return address;
    }

}
