package com.example.search.service;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class StudentServiceImpl implements StudentService{
    private final ExecutorService pool;
    private final RestTemplate ribbonRestTemplate;
    @Autowired
    public StudentServiceImpl(ExecutorService pool, RestTemplate ribbonRestTemplate){
        this.pool = pool;
        this.ribbonRestTemplate = ribbonRestTemplate;
    }
    @Override
    public List<?> fetchALlStudents() {
        return ribbonRestTemplate.getForObject("http://student-service/student", ObjectList.class);
    }
}
