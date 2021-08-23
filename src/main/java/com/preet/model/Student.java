package com.preet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    long id;
    private String firstName;
    private String lastName;
    private long departmentId;


}
