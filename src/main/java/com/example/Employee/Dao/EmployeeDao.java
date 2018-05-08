package com.example.Employee.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.Employee.Model.Employee;

@Repository
public class EmployeeDao {
	
	private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}

		
		public void addEmployee(Employee e) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(e);
			//logger.info("Person saved successfully, Person Details="+p);
		}

		
		public void updateEmployee(Employee e) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(e);
			//logger.info("Person updated successfully, Person Details="+p);
		}

		
		public List<Employee> listEmployees() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Employee> empsList = session.createQuery("from Employee").list();
			for(Employee p : empsList){
				//logger.info("Person List::"+p);
			}
			return empsList;
		}

		
		public Employee getEmployeeById(int id) {
			Session session = this.sessionFactory.getCurrentSession();		
			Employee e = (Employee) session.load(Employee.class, new Integer(id));
			//logger.info("Person loaded successfully, Person details="+p);
			return e;
		}

		
		public void removeEmployee(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Employee p =(Employee)session.load(Employee.class, new Integer(id));
			if(null != p){
				session.delete(p);
			}
			//logger.info("Person deleted successfully, person details="+p);
		}

	}



