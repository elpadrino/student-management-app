package com.elpadriiino.studentmanagementapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 35)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 35)
    private String lastName;

    @Column(name = "age", nullable = false, length = 2)
    private Integer age;

    @Column(name="dob",nullable = false)
    private Date dob;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "address",nullable = false,length = 70)
    private String address;



}
