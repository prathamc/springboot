package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public interface EmployeeService extends CrudRepository<Employee, Long> {

}
