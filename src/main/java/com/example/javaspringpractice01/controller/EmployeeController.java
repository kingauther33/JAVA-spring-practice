package com.example.javaspringpractice01.controller;

import com.example.javaspringpractice01.entity.Employee;
import com.example.javaspringpractice01.repository.EmployeeRepository;
import com.example.javaspringpractice01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // FIND ALL
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        if (employeeList.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Employee employee) {
        employeeService.save(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // GET DETAIL
    @RequestMapping(method = RequestMethod.GET, path="{id}")
    public ResponseEntity<Object> create(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isPresent()) {
            return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);

        // trường hợp = null trả 404.
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            employee.setSalary(updatedEmployee.getSalary());
            employeeService.save(employee);

            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Optional<Employee> optionalFood = employeeService.findById(id);

        // trường hợp = null trả 404.
        if (optionalFood.isPresent()) {
            employeeService.delete(optionalFood.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, path="search")
    public ResponseEntity<Object> searchEmployee(
            @RequestParam(defaultValue = "Nhân viên 1") String name,
            @RequestParam(defaultValue = "26") int age,
            @RequestParam(defaultValue = "30000") double salary) {

            List<Employee> employee = employeeService.searchEmployee(name, age, salary);
            if (employee.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
