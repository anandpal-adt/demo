package com.anand.service;

import com.anand.dao.UserDao;
import com.anand.dao.UserDaoImple;
import com.anand.entity.User;

public class UserServiceImple implements UserService {
   private UserDao userDao;
	public UserServiceImple() {
		userDao=new UserDaoImple();
	}

	@Override
	public boolean login(User user) {
		return userDao.login(user);
	}

}
