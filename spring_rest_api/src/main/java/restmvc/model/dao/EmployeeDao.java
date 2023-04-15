package restmvc.model.dao;

import java.util.List;

import restmvc.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	public Employee getEmployee(long id);
}
