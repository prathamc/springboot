package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mongo.model.MongoEmployee;
import com.example.demo.mongo.repository.EmployeeRepository;

@Component
public class EmployeeReader implements ItemReader<MongoEmployee> {
	
	@Autowired
	EmployeeRepository empRepo;
	
	private int count = 0;
	
	@Override
	public MongoEmployee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		 List<MongoEmployee> empList = empRepo.findAll();
		 if (count < empList.size()) {
			 return empList.get(count++);
		 } else {
			 return null;
		 }
	}

}
