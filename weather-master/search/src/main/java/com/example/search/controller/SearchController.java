package com.example.search.controller;

import com.example.search.service.EmployeeService;
import com.example.search.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SearchController {

    Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final EmployeeService employeeService;
    private final StudentService studentService;
    public SearchController(EmployeeService employeeService, StudentService studentService) {
        this.employeeService = employeeService;
        this.studentService = studentService;
    }

    @GetMapping("/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }

    @GetMapping("/search/students")
    public ResponseEntity<?> getStuInfo(){
        logger.info("fetch student information");
        return new ResponseEntity<>(studentService.fetchALlStudents(), HttpStatus.OK);
    }

    @GetMapping("/search/multithread")
    public void multithread(@RequestParam List<Integer> ages) throws Exception{
        Thread empThread = new Thread(() ->{
            try{
                employeeService.fetchAllEmployeesByAges(ages);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        Thread stuThread = new Thread(() -> {
            try {
                studentService.fetchALlStudents();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        empThread.start();
        stuThread.start();
        empThread.join();
        stuThread.join();
    }
}
