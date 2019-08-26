package com.dev.dao;

import com.dev.beans.User;

public interface UserDAO {

	public Boolean createProfile(User user);

	public User searchUser(Integer userID);

	public Boolean updatePassword(Integer userID, String oldPassword, String newPassword);

	public Boolean deleteUser(Integer userID, String password);

	public User login(Integer userID, String password);
	

	
	
	
	
	

}
