package com.springboot.studentdetails.payload;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO  {
    private Long id;
    private String name;
    private String DOB;
    private String DOJ;
    private Set<AddressDto> address;
    private Set<DepartmentDto> department;
}
