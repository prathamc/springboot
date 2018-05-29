package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@RequestMapping("test")
	public String test(Model model) {
		List<Employee> employees = new ArrayList<>();
		empService.findAll().forEach(emp -> employees.add(emp));
		model.addAttribute("employees", employees);
		return "index";
	}
}
