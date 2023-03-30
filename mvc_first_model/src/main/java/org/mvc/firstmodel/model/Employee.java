package org.mvc.firstmodel.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Size;

@Component
public class Employee {
	@Size(min = 2, max = 20, message = "name min be 2 symbol, max 20")
	private String name;
	private String surname;
	private String department;
	private long salary;

	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", department=" + department + ", salary=" + salary
				+ "]";
	}

}
