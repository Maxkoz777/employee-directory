package com.maxkoz777.springboot.employeedirectory.service;

import com.maxkoz777.springboot.employeedirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}
