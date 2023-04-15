package org.mvc.firstmodel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.mvc.firstmodel.myvalidate.CheckEmail;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Size(min = 2, max = 20, message = "name must be min 2 symbol, max 20")
	private String name;
	@Size(min = 2, max = 20, message = "surname must be min 2 symbol, max 20")
	private String surname;
	@NotBlank(message = "department is requered field")
	private String department;
	@Min(value = 100, message = "field must be greater than value 99")
	@Max(value = 1000000, message = "field must be less than value 10000001")
	private long salary;
	@Pattern(regexp = "\\d{3}-\\d{2}", message = "Please use pattern XXX-XX")
	private String phone;
	@CheckEmail
	private String email;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", department=" + department + ", salary=" + salary
				+ "]";
	}

}
