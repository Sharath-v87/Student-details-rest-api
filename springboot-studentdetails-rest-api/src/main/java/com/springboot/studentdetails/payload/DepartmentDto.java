package com.springboot.studentdetails.payload;

import lombok.Data;

@Data
public class DepartmentDto {
    private long id;
    private String name;
    private String description;
}
