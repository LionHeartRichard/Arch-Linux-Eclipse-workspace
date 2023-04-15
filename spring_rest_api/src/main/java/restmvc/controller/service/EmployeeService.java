package restmvc.controller.service;

import java.util.List;

import restmvc.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(long id);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Employee employee);
}
