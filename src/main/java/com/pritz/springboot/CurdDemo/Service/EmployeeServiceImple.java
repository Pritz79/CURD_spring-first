package com.pritz.springboot.CurdDemo.Service;

import com.pritz.springboot.CurdDemo.DAO.EmployeeDAO;
import com.pritz.springboot.CurdDemo.DAO.EmployeeDAOImple;
import com.pritz.springboot.CurdDemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImple implements EmployeeService{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImple(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }



    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override

    public Employee findById(int id) {
        return employeeDAO.findBYId(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }


}
