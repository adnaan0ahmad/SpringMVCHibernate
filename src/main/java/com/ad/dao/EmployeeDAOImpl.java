package com.ad.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ad.bean.Employee;
import com.ad.bean.EmployeeMapper;

/**
 * 
 * @author Adnaan
 *
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
	
	/****************************************
	 * JDBC Template
	 ****************************************/

	@Override
	public boolean addEmployee(Employee e) {
		return jdbcTemplate.update("insert into EMP_TBL values (?,?,?,?,?)", e.getId(), e.getAddress(), e.getEmail(),
				e.getName(), e.getTelephone()) > 0;
	}

	@Override
	public Employee getEmployee(int employeeid) {
		return jdbcTemplate.queryForObject("select * from EMP_TBL where id =" + employeeid, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from EMP_TBL", new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		return jdbcTemplate.update("delete from EMP_TBL where id = ?", employeeId) > 0;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		jdbcTemplate.update("update EMP_TBL set address = ?, email = ?, name = ?, telephone  = ? where id = ?", e.getAddress(), e.getEmail(),
				e.getName(), e.getTelephone(), e.getId());
		return getEmployee(e.getId());
	}

	/****************************************
	 * Named JDBC Template
	 ****************************************/

/*	@Override
	public boolean addEmployee(Employee e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eId", e.getId());
		map.put("eAddress", e.getAddress());
		map.put("eEmail", e.getEmail());
		map.put("eName", e.getName());
		map.put("eTelephone", e.getTelephone());
		namedJdbcTemplate.update("INSERT INTO EMP_TBL (id, address, email, name, telephone) "
				+ "VALUES (:eId, :eAddress, :eEmail, :eName, :eTelephone)", map);
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return namedJdbcTemplate.query("select * from EMP_TBL", new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("empid", employeeId);		
		namedJdbcTemplate.update("delete from EMP_TBL where id = :empid", param);
		return true;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("eAdd", e.getAddress());
		param.put("eEmail", e.getEmail());
		param.put("eNm", e.getName());
		param.put("eTel", e.getTelephone());
		param.put("eID", e.getId());
		
		namedJdbcTemplate.update("update EMP_TBL set address = :eAdd, email = :eEmail, "
				+ "name = :eNm, telephone  = :eTel where id = :eID", param);
		return null;
	}

	@Override
	public Employee getEmployee(int employeeid) {
		Map<String, Object> param = new HashMap<String, Object>();
				param.put("empid", employeeid);		
		return (Employee) namedJdbcTemplate.queryForObject("select * from EMP_TBL where id = :empid", param, new EmployeeMapper());
	}*/
	
	/****************************************
	 * Simple JDBC Template
	 ****************************************/
	
	/*@Override
	public boolean addEmployee(Employee e) {
		return simpleJdbcTemplate.update("insert into EMP_TBL (id, address, email, name, telephone) values (?,?,?,?,?)", e.getId(), e.getAddress(), e.getEmail(),
				e.getName(), e.getTelephone()) > 0;
	}

	@Override
	public Employee getEmployee(int employeeid) {
		return simpleJdbcTemplate.queryForObject("select * from EMP_TBL where id =" + employeeid, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return simpleJdbcTemplate.query("select * from EMP_TBL", new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		return simpleJdbcTemplate.update("delete from EMP_TBL where id = ?", employeeId) > 0;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		simpleJdbcTemplate.update("update EMP_TBL set address = ?, email = ?, name = ?, telephone  = ? where id = ?", e.getAddress(), e.getEmail(),
				e.getName(), e.getTelephone(), e.getId());
		return getEmployee(e.getId());
	}*/

	
}