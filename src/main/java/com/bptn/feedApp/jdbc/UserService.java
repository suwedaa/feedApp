package com.bptn.feedApp.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bptn.feedApp.jpa.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> listUsers() {
		return this.userDao.listUsers();
	}

	public User findByUsername(@PathVariable String username) {
		return this.userDao.findByUsername(username);
	}

	public void createUser(UserBean user) {
		this.userDao.createUser(user);
	}
}
