package com.springboot.studentdetails.controller;

import com.springboot.studentdetails.payload.StudentDTO;
import com.springboot.studentdetails.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    // create student details
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        return  new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    // get all students from rest api
    @GetMapping
    public List<StudentDTO> getAllPosts(){
        return studentService.getAllStudents();
    }

    //get students by id
    @GetMapping("/{student_id}")
    public ResponseEntity<StudentDTO> getPostById(@PathVariable(name = "student_id") long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    // update student
    @PutMapping("/{student_id}")
    public  ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable(name = "student_id") long id){

        StudentDTO studentResponse = studentService.updateStudent(studentDTO, id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    // delete student
    @DeleteMapping("/{student_id}")
    public ResponseEntity <String> deleteStudent(@PathVariable(name = "student_id") long id){

        studentService.deleteStudent(id);

        return new ResponseEntity<>("student details deleted successfully", HttpStatus.OK);

    }
}
