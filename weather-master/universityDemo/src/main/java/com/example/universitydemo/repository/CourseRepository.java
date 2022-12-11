package com.example.universitydemo.repository;

import com.example.universitydemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
//    void insert(Course course);
}
