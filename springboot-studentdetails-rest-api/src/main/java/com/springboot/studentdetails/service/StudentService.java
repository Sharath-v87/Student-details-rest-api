package com.springboot.studentdetails.service;

import com.springboot.studentdetails.payload.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(long id);

    StudentDTO updateStudent(StudentDTO studentDTO, long id);

    void deleteStudent(long id);
}
