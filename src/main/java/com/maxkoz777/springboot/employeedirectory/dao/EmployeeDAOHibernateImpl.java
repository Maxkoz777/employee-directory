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
    @Transactional
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

}
