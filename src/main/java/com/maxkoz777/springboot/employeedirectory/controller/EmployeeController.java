package com.maxkoz777.springboot.employeedirectory.controller;

import com.maxkoz777.springboot.employeedirectory.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {

        Employee employee1 = new Employee(1, "a", "b", "ab@ba");
        Employee employee2 = new Employee(2, "c", "d", "cd@dc");
        Employee employee3 = new Employee(3, "e", "f", "ef@fe");

        employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employees);

        return "list-employees";

    }

}
