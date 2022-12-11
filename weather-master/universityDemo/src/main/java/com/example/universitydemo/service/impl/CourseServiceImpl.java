package com.example.universitydemo.service.impl;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Relation;
import com.example.universitydemo.entity.Student;
import com.example.universitydemo.repository.CourseRepository;
import com.example.universitydemo.repository.RelationRepository;
import com.example.universitydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Autowired
    private RelationRepository relationRepository;

//    @Override
//    public void insert(Course course) {
//        courseRepository.insert(course);
//    }

    @Override
    public void delete(int id) {
        Course course = findById(id);
        if(course != null) courseRepository.delete(course);
    }

    @Override
    public Course update(int id, String name) {
        Course course = findById(id);
        course.setCName(name);
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        return (Course) courseRepository.findById(id).get();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsByCourseId(int cId) {

        Course course = findById(cId);
        if(course == null)return null;
        return relationRepository.findAllStudentByCourse(course)
                .stream()
                .map(Relation::getStudent)
                .collect(Collectors.toList());
    }
}
