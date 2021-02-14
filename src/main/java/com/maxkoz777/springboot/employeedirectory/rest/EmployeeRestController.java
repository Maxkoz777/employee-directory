package com.maxkoz777.springboot.employeedirectory.rest;

import com.maxkoz777.springboot.employeedirectory.dao.EmployeeDAO;
import com.maxkoz777.springboot.employeedirectory.entity.Employee;
import com.maxkoz777.springboot.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();

    }

}
