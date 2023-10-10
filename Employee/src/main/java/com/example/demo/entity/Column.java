package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_details")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String email;


}

