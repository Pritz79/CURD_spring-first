package com.pritz.springboot.CurdDemo.DAO;

import com.pritz.springboot.CurdDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
public Employee findBYId(int id);
public Employee save(Employee employee);
public  void deleteById(int id);
}
