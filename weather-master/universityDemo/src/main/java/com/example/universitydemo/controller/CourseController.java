package com.example.universitydemo.controller;

import com.example.universitydemo.entity.Course;
import com.example.universitydemo.entity.Student;
import com.example.universitydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable int id){
        return courseService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable int id, @RequestBody String name){
        return courseService.update(id, name);
    }

    @GetMapping("/{id}/students")
    public List<Student> findAllStudentsByCourseId(@PathVariable int id){
        return courseService.findAllStudentsByCourseId(id);
    }
}
