package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/")
	public String getAllEmployee() {
		return "view_all_employee";
	}

	@GetMapping("/hr_info")
	public String getInfoOnlyForHR() {
		return "hr_info";
	}

	@GetMapping("/manager_info")
	public String getInfoOnlyForManager() {
		return "manager_info";
	}
}
