package com.ad.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Adnaan
 *
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rset, int i) throws SQLException {
		
		Employee e = new Employee();
		e.setId(rset.getInt("id"));
		e.setName(rset.getString("name"));
		e.setEmail(rset.getString("email"));
		e.setAddress(rset.getString("address"));
		e.setTelephone(rset.getString("telephone"));	
		return e;
	}

}
	