package com.ad.dao;

import java.util.List;

import com.ad.bean.Employee;

/**
 * 
 * @author Adnaan
 *
 *
 */

public interface EmployeeDAO {

	public boolean addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public boolean deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeid);
}
