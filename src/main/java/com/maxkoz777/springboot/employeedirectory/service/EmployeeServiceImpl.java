package com.maxkoz777.springboot.employeedirectory.service;

import com.maxkoz777.springboot.employeedirectory.dao.EmployeeDAO;
import com.maxkoz777.springboot.employeedirectory.dao.EmployeeRepository;
import com.maxkoz777.springboot.employeedirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // EmployeeDAO employeeRepository;

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }
        else
            throw new RuntimeException("No employee with id: " + id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);

    }
}
