package com.example.universitydemo.controller;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Student;
import com.example.universitydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/delete/{id}")
    public void deleteStu(@PathVariable int id){
        studentService.deleteStu(id);
    }


    @GetMapping("/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody String name, @RequestBody int age){
        return studentService.updateStu(id, age, name);
    }

    @GetMapping("/{id}/courses")
    public List<Course> findAllCoursesByStudentId(@PathVariable int id){
        return studentService.findAllCoursesByStudentId(id);
    }
}
