package com.example.employee.service;

import com.example.employee.domain.EmployeeDTO;
import com.example.employee.domain.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final RestTemplate restTemplate;

    @Value("${employee-endpoint}")
    private String url;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "FallBack")
    @Override
    public List<EmployeeDTO> fetchEmpAgeLargerThan(int age) {
        EmployeeResponseDTO employeeResponseDTO = restTemplate.getForObject(url, EmployeeResponseDTO.class);
        return employeeResponseDTO.getEmployees()
                    .stream()
                    .filter(e -> e.getEmployee_age() >= age)
                    .collect(Collectors.toList());
    }
    public List<EmployeeDTO> FllBack(int age){
        return null;
    }

}
