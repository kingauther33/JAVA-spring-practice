package com.example.javaspringpractice01.service;

import com.example.javaspringpractice01.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    Employee save(Employee employee);

    Employee update(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(int id);

    boolean delete(Employee employee);

    List<Employee> searchEmployee(String name, int age, double salary);
}
