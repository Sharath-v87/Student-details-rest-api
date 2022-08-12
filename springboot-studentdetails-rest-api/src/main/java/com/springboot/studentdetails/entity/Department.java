package com.springboot.studentdetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="DepartmentDetails")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="student_id", nullable = false)
    private Student student;
}
