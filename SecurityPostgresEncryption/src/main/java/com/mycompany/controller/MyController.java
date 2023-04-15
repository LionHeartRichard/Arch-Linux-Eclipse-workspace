package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/")
	public String getAllEmployees() {
		return "view_all_employee";
	}

	@GetMapping("/hr_info")
	public String getInfoSalaryForEmployees() {
		return "hr_info";
	}

	@GetMapping("/manager_info")
	public String getInfoPerformanceEmployees() {
		return "manager_info";
	}
}
