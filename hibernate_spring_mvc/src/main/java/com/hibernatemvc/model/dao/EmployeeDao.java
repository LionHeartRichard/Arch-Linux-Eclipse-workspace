package com.hibernatemvc.model.dao;

import java.util.List;

import com.hibernatemvc.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(long id);

	public void deleteEmployee(long id);
}
