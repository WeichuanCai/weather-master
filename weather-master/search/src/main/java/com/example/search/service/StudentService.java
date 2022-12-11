package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<?> fetchALlStudents();
}
