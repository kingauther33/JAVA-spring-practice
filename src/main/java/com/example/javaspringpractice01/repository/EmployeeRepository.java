package com.example.javaspringpractice01.repository;

import com.example.javaspringpractice01.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(
            value = "SELECT e FROM Employee e where e.name = :name and e.age = :name and e.salary = :salary",
            nativeQuery = true)
    Employee findEmployee(String name, int age, double salary);
}
