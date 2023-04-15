package restmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restmvc.controller.service.EmployeeService;
import restmvc.model.Employee;
import restmvc.myexception.NoSuchEmloyeeException;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> showAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

	@GetMapping("/employees/{myId}")
	public Employee getEmployee(@PathVariable long myId) {
		Employee employee = employeeService.getEmployee(myId);

		if (employee == null) {
			throw new NoSuchEmloyeeException("There is no employee with ID = " + myId + " in DATABASE");
		}

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee empl) {
		employeeService.saveEmployee(empl);
		return empl;
	}

	@PutMapping("/employees")
	public Employee changeEmployee(@RequestBody Employee empl) { // TODO void
		employeeService.saveEmployee(empl);
		return empl;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id) {

		Employee employee = employeeService.getEmployee(id);

		if (employee.equals(null)) {
			throw new NoSuchEmloyeeException("There is no employee with ID = " + id + " in DATABASE!!!");
		}

		employeeService.deleteEmployee(employee);

		return "Employee with ID = " + id + " was deleted";
	}

}
