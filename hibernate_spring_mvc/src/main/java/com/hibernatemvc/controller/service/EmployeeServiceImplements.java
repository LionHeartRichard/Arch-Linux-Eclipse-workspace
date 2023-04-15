package com.hibernatemvc.controller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernatemvc.model.Employee;
import com.hibernatemvc.model.dao.EmployeeDao;

@Service
public class EmployeeServiceImplements implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);

	}

	@Override
	@Transactional
	public Employee getEmployee(long id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(long id) {
		employeeDao.deleteEmployee(id);
	}

}
