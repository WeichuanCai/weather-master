package com.example.universitydemo.service.impl;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Relation;
import com.example.universitydemo.entity.Student;
import com.example.universitydemo.repository.CourseRepository;
import com.example.universitydemo.repository.RelationRepository;
import com.example.universitydemo.repository.StudentRepository;
import com.example.universitydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public void deleteStu(int stuId) {
        Student stu = findById(stuId);
        if(stu != null) studentRepository.delete(stu);
    }

    @Override
    public Student updateStu(int stuId, int age, String name) {
        Student stu = findById(stuId);
        stu.setStuName(name);
        stu.setAge(age);
        studentRepository.save(stu);
        return stu;
    }

    @Override
    public Student findById(int stuId) {
        return (Student) studentRepository.findById(stuId).get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> findAllCoursesByStudentId(int stuId) {
        Student stu = findById(stuId);
        if(stu == null) return null;
        return relationRepository.findAllCourseByStudent(stu)
                .stream()
                .map(Relation::getCourse)
                .collect(Collectors.toList());

    }
}
