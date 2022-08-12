package com.springboot.studentdetails.repository;

import com.springboot.studentdetails.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
