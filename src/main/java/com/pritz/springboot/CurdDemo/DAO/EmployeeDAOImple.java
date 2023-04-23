package com.pritz.springboot.CurdDemo.DAO;

import com.pritz.springboot.CurdDemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImple implements EmployeeDAO{

    private EntityManager entityManager;
@Autowired
    public EmployeeDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
    //createQuery
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class) ;
//execute query return result list
return theQuery.getResultList();
}

    @Override
    public Employee findBYId(int id) {
        Employee employee= entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
     Employee employee1= entityManager.merge(employee);
        return employee1;
    }

    @Override
    public void deleteById(int id) {
        Employee employee= entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }


}
