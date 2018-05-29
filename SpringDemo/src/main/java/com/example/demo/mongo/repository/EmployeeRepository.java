package com.example.demo.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.demo.mongo.model.MongoEmployee;

@Service
public interface EmployeeRepository extends MongoRepository<MongoEmployee, String> {

}
