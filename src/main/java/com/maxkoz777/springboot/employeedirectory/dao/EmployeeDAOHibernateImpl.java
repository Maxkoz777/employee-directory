package com.maxkoz777.springboot.employeedirectory.dao;

import com.maxkoz777.springboot.employeedirectory.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    // define field for entityManager

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        // execute query
        List<Employee> employees = query.getResultList();

        // return result
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get
        Employee employee = currentSession.get(Employee.class, id);

        // return result
        return employee;

    }

    @Override
    public void save(Employee employee) {

        // get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {

        // get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // query
        Query<Employee> query = currentSession.createQuery("delete from Employee where id =: empId");

        // set id to query
        query.setParameter("empId", id);

        query.executeUpdate();

    }

}
