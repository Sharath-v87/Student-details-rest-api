package com.springboot.studentdetails.service;

import com.springboot.studentdetails.entity.Department;
import com.springboot.studentdetails.payload.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(long studentid, DepartmentDto departmentDto);
}
