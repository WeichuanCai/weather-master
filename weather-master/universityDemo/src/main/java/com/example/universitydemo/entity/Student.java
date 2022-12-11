package com.example.universitydemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name= "stu_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;

    @Column(name= "stu_Name")
    private String stuName;

    @Column(name="age")
    private Integer age;


}
