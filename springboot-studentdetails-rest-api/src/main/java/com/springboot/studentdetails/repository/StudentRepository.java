package com.springboot.studentdetails.repository;

import com.springboot.studentdetails.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
