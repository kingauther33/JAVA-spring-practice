package com.example.javaspringpractice01.repository;

import com.example.javaspringpractice01.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e from Employee e where e.name = :name and e.age = :age and e.salary = :salary")
    List<Employee> findEmployee(String name, int age, double salary);

    List<Employee> findByName(String name);
}
