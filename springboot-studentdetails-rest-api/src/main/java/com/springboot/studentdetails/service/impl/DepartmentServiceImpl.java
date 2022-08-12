package com.springboot.studentdetails.service.impl;

import com.springboot.studentdetails.entity.Address;
import com.springboot.studentdetails.entity.Department;
import com.springboot.studentdetails.entity.Student;
import com.springboot.studentdetails.exceptions.ResourceNotFoundException;
import com.springboot.studentdetails.payload.AddressDto;
import com.springboot.studentdetails.payload.DepartmentDto;
import com.springboot.studentdetails.repository.AddressRepository;
import com.springboot.studentdetails.repository.DepartmentRepository;
import com.springboot.studentdetails.repository.StudentRepository;

public class DepartmentServiceImpl {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public DepartmentDto createAddress(long studentId, DepartmentDto departmentDto) {

        Department department = mapToEntity(departmentDto);

        Student student =  studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","id",studentId));
        department.setStudent(student);
        Department newDepartment = departmentRepository.save(department);
        return mapToDto(newDepartment);
    }

    private DepartmentDto mapToDto (Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        return departmentDto;
    }

    private  Department mapToEntity(DepartmentDto departmentDto){
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return department;
    }
}
