package com.example.universitydemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "relation")
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reId;

    @ManyToOne
    @JoinColumn(name = "stu_Id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "c_Id")
    private Course course;



}

