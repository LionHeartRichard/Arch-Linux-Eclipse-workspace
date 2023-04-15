package com.hibernatemvc.controller.service;

import java.util.List;

import com.hibernatemvc.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(long id);

	public void deleteEmployee(long id);
}
