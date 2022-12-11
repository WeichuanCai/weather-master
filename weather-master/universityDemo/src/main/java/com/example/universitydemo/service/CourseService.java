package com.example.universitydemo.service;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
//    void insert(Course course);
    void delete(int id);
    Course update(int id, String name);
    Course findById(int id);
    List<Course> findAll();

    List<Student> findAllStudentsByCourseId(int cId);
}
