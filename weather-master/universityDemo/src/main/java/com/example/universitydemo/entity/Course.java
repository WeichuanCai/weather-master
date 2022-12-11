package com.example.universitydemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;

    @Column(name= "c_Name")
    private String cName;


}
