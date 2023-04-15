package com.hibernatemvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernatemvc.controller.service.EmployeeService;
import com.hibernatemvc.model.Employee;
import com.hibernatemvc.model.dao.EmployeeDao;

@Controller
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String showAllEmployees(Model model) {

		List<Employee> allEmployees = employeeService.getAllEmployees();
		model.addAttribute("allEmps", allEmployees);

		return "all-employees";
	}

	@RequestMapping("/addNewEmployee")
	public String addNewEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "employee-info";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);

		return "redirect:/";
	}

	@RequestMapping("/updateInfo")
	public String updateEmployee(@RequestParam("empId") long id, Model model) {

		Employee empl = employeeService.getEmployee(id);
		model.addAttribute("employee", empl);

		return "employee-info";
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empId") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
