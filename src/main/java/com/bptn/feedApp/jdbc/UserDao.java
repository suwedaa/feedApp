package com.bptn.feedApp.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bptn.feedApp.jpa.User;

@Repository
public class UserDao {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> listUsers() {
		String sql = "SELECT * FROM \"user\"";
		return this.jdbcTemplate.query(sql, new UserMapper());
	}

	public User findByUsername(String username) {
		String sql = "SELECT * FROM \"user\" WHERE username = ?";
		List<User> users = this.jdbcTemplate.query(sql, new UserMapper(), username);
		/*
		 * Returns null if users is empty; otherwise, returns the first element in the
		 * list
		 */
		return users.isEmpty() ? null : users.get(0);
	}

	public void createUser(UserBean user) {
		String sql = "INSERT INTO \"user\" (\"firstName\", \"lastName\", username, phone, \"emailId\", password, \"emailVerified\", \"createdOn\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		logger.debug("Insert Query: {}", sql);

		/* Executes the Insert Statement */
		this.jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPhone(),
				user.getEmailId(), user.getPassword(), user.getEmailVerified(), user.getCreatedOn());
	}
}
