package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.JDBCImpl;
import com.dev.dao.UserDAO;

public class UserServicesImpl implements UserServices {
	
	private UserDAO db = new JDBCImpl();

	@Override
	public Boolean createProfile(User user) {
		return db.createProfile(user);
	}

	@Override
	public User searchUser(Integer userID) {
		return db.searchUser(userID);
	}

	@Override
	public Boolean updatePassword(Integer userID, String oldPassword, String newPassword) {
		return db.updatePassword(userID, oldPassword, newPassword);
	}

	@Override
	public Boolean deleteUser(Integer userID, String password) {
		return db.deleteUser(userID, password);
	}

	@Override
	public User login(Integer userID, String password) {
		return db.login(userID, password);
	}

	

}