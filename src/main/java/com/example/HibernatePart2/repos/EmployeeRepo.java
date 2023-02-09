package com.example.HibernatePart2.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernatePart2.entities.employee.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
