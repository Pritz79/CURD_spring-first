package com.pritz.springboot.CurdDemo.Rest;

import com.pritz.springboot.CurdDemo.DAO.EmployeeDAO;
import com.pritz.springboot.CurdDemo.DAO.EmployeeDAOImple;
import com.pritz.springboot.CurdDemo.Entity.Employee;
import com.pritz.springboot.CurdDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
@Autowired
    public EmployeeRestController(EmployeeService employeeService) {
       this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
public Employee getEmployee(@PathVariable int employeeId){
    Employee employee= employeeService.findById(employeeId);
    if(employee==null){
        throw new RuntimeException("Employee  not found"+ employeeId);
    }
    return employee;
    }
    //add post mapping for adding the employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody  Employee employee){
// in the case if employee id is not zero consider it zero
         // it is force to  save the emloyee rather than update it
        employee.setId(0);
      return  employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
    return employeeService.save(employee);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public String deleting(@PathVariable int employeeId){
    Employee employee= employeeService.findById(employeeId);
    if(employee==null){
        throw new RuntimeException("No student of this is id "+employeeId);
    }
employeeService.deleteById(employeeId);
    return "delete is successful";
    }
}
