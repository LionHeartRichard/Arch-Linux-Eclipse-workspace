package restmvc.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import restmvc.model.Employee;

@Repository
public class EmployeeDaoImplements implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
	}

	@Override
	public Employee getEmployee(long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee empl = session.get(Employee.class, id);
		return empl;
	}

}
