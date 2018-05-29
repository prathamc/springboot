package com.example.demo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.batch.EmployeeProcessor;
import com.example.demo.batch.EmployeeReader;
import com.example.demo.batch.EmployeeWriter;
import com.example.demo.batch.listener.EmployeeListener;
import com.example.demo.model.Employee;
import com.example.demo.mongo.model.MongoEmployee;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private EmployeeReader employeeReader;

	@Autowired
	EmployeeProcessor employeeProcessor;

	@Autowired
	EmployeeWriter employeeWriter;

	@Autowired
	EmployeeListener employeeListener;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(employeeListener)
				.flow(orderStep1())
				.end()
				.build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1")
				.<MongoEmployee,Employee>chunk(10)
				.reader(employeeReader)
				.processor(employeeProcessor)
				.writer(employeeWriter).build();
	}

}
