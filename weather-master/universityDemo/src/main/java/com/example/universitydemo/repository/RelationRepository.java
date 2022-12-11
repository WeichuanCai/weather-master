package com.example.universitydemo.repository;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Relation;
import com.example.universitydemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Integer> {
    List<Relation> findAllStudentByCourse(Course course);
    List<Relation> findAllCourseByStudent(Student student);
}
