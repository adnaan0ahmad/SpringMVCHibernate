package com.ad.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ad.bean.Employee;
import com.ad.dao.EmployeeDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext cont = new FileSystemXmlApplicationContext("//Users//adnaan//eclipse-workspace-JAVA//SpringJDBCTemplates//src//main//java//spring-servlet.xml");
		EmployeeDAOImpl eDAO = (EmployeeDAOImpl) cont.getBean("employeeDAO");
		
		Employee e1 = new Employee(1, "Monkey", "M@gmail", "Pune", "1028XXXX");
		Employee e2 = new Employee(2, "Ox", "O@gmail", "Pune", "2023XXXX");
		Employee e3 = new Employee(3, "Goat", "G@gmail", "Pune", "3026XXXX");
		Employee e4 = new Employee(4, "Tiger", "T@gmail", "Mumbai", "4029XXXX");
		Employee e5 = new Employee(5, "Lion", "L@gmail", "Pune", "5029XXXX");
		
		//eDAO.addEmployee(e5);
		/*System.out.println(eDAO.getEmployee(4));
		System.out.println(eDAO.updateEmployee(e4));*/
		eDAO.deleteEmployee(5);
		
	}

}
