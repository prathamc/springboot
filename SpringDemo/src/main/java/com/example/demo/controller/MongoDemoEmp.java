package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mongo.model.MongoEmployee;
import com.example.demo.mongo.repository.EmployeeRepository;

@Controller
public class MongoDemoEmp {

	@Autowired
	EmployeeRepository empRepo ;

	@RequestMapping("/findAll")
	public @ResponseBody String findAllEmployees() {
		List<MongoEmployee> findAll = empRepo.findAll();
		return findAll.toString();
	}

	@RequestMapping("/del/{id}")
	public @ResponseBody String deleteEmp(@PathVariable("id") String id) {
		empRepo.deleteById(id);
		List<MongoEmployee> findAll = empRepo.findAll();
		return findAll.toString();
	}


}
