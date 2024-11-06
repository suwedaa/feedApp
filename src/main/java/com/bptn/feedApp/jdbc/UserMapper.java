package com.bptn.feedApp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bptn.feedApp.jpa.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		/* Create a UserBean object */
		User user = new User();

		/* Populates the UserBean object with data from the resultSet */
		user.setUserId(rs.getInt("userId"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));
		user.setEmailId(rs.getString("emailId"));
		user.setEmailVerified(rs.getBoolean("emailVerified"));
		user.setCreatedOn(rs.getTimestamp("createdOn"));

		/* Return the populated UserBean object */
		return user;
	}
}
