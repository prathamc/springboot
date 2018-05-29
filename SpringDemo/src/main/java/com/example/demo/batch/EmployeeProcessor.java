package com.example.demo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.mongo.model.MongoEmployee;

@Component
public class EmployeeProcessor implements ItemProcessor<MongoEmployee, Employee> {

	@Override
	public Employee process(MongoEmployee mongoEmp) throws Exception {
		Employee emp = new Employee();
		emp.setName(mongoEmp.getName());
		return emp;
	}

}
