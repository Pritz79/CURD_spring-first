package com.pritz.springboot.CurdDemo.Service;

import com.pritz.springboot.CurdDemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
