package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.mongo.model.MongoEmployee;
import com.example.demo.mongo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Controller
public class SpringBatchController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@RequestMapping("/batch")
	public String getEmployeesData(Model model) {
		List<Employee> h2employees = new ArrayList<>();
		empService.findAll().forEach(emp -> h2employees.add(emp));
		model.addAttribute("h2employees", h2employees);
		
		List<MongoEmployee> mongoEmployees = empRepo.findAll();
		model.addAttribute("mongoEmployees", mongoEmployees);
		return "employee";
	}
}
