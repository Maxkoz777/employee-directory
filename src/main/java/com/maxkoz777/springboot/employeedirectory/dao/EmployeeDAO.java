package com.maxkoz777.springboot.employeedirectory.dao;

import com.maxkoz777.springboot.employeedirectory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
