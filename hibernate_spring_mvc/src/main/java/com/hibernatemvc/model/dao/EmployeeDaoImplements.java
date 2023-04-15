package com.hibernatemvc.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernatemvc.model.Employee;

@Repository
public class EmployeeDaoImplements implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
		return allEmployees;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);

	}

	@Override
	public Employee getEmployee(long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee empl = session.get(Employee.class, id);
		return empl;
	}

	@Override
	public void deleteEmployee(long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee e = session.get(Employee.class, id);
		session.delete(e);
	}

}
