package com.example.universitydemo.service;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void deleteStu(int stuId);
    Student updateStu(int stuId, int age, String name);
    Student findById(int stuId);
    List<Student> findAll();

    List<Course> findAllCoursesByStudentId(int stuId);
}
