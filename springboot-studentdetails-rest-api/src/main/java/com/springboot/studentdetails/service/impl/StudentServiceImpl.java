package com.springboot.studentdetails.service.impl;

import com.springboot.studentdetails.entity.Student;
import com.springboot.studentdetails.exceptions.ResourceNotFoundException;
import com.springboot.studentdetails.payload.StudentDTO;
import com.springboot.studentdetails.repository.StudentRepository;
import com.springboot.studentdetails.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository,ModelMapper mapper ) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;

    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        // convert DTO to entity
        Student student = mapToEntity(studentDTO);
        Student newStudent=studentRepository.save(student);

        // convert entity to DTO
        StudentDTO studentResponse = mapToDto(newStudent);
        return studentResponse;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(student);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, long id) {
        // get post by id from the database
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));

        student.setName(studentDTO.getName());
        student.setDOJ(studentDTO.getDOJ());
        student.setDOB(studentDTO.getDOB());

        Student updatedStudent = studentRepository.save(student);
        return mapToDto(updatedStudent);
    }

    @Override
    public void deleteStudent(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        studentRepository.delete(student);
    }

    // entity to DTO
    private StudentDTO mapToDto(Student student){
        StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
//        studentDTO.setId(student.getId());
//        studentDTO.setName(student.getName());
//        studentDTO.setDOB(student.getDOB());
//        studentDTO.setDOJ(student.getDOJ());

        return  studentDTO;
    }

    private Student mapToEntity(StudentDTO studentDTO){
        Student student = mapper.map(studentDTO, Student.class);
//        student.setName(studentDTO.getName());
//        student.setDOB(studentDTO.getDOB());
//        student.setDOJ(studentDTO.getDOJ());
        return student;
    }
}
