package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.EmployeeService;
import com.example.demo.model.Employee;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {
	
	@Autowired
	EmployeeService empService;
		
	@Override
	public void write(List<? extends Employee> employeeList) throws Exception {
		empService.saveAll(employeeList);
	}

}
