package com.example.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Dao.EmployeeDao;
import com.example.Employee.Model.Employee;



@RestController
@RequestMapping(value="/Employees/")
public class EmployeeController {
	
		
		 @Autowired
		 EmployeeDao empDao;
		 
		 
		 @RequestMapping(method = RequestMethod.GET)
		 public  List<Employee> listEmployees() {
		  return new EmployeeDao().listEmployees();
		 }
		 
		 @RequestMapping(value="/{empId}" ,method=RequestMethod.GET)
			 public Employee getEmployeeById(@PathVariable("empId")int empId){
				 return new EmployeeDao().getEmployeeById(empId);
			 }
		 
		 
		 @RequestMapping(value="/{empId}" ,method=RequestMethod.DELETE)
		 public void removeEmployee(@PathVariable("empId")int empId){
			 new EmployeeDao().removeEmployee(empId);
		 }
	 
		 
		 @RequestMapping(value="/add",method = RequestMethod.POST)
		 public  void addEmployee(@RequestBody Employee emp) {
		   new EmployeeDao().addEmployee(emp) ;
		 }
		 
		 @RequestMapping(value="/update/{empid}",method = RequestMethod.PUT)
		 public  void updateOrder(@RequestBody Employee emp) {
		   new EmployeeDao().updateEmployee(emp) ;
		 }
		 
		}
