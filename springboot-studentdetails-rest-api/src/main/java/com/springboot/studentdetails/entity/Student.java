package com.springboot.studentdetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Student", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "DOB", nullable = false)
    private String DOB;

    @Column(name = "DOJ", nullable = false)
    private String DOJ;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Address> address = new HashSet<>();

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Department> departments  = new HashSet<>();
}
