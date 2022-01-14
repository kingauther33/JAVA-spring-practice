package com.example.javaspringpractice01.service;

import com.example.javaspringpractice01.entity.Employee;
import com.example.javaspringpractice01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean delete(Employee employee) {
        employeeRepository.delete(employee);
        return true;
    }

//    @Override
//    public Employee searchEmployee(String name, int age, double salary) {
//        return employeeRepository.findEmployee(name, age, salary);
//    }
}
