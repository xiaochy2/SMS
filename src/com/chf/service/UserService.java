package com.chf.service;

import java.util.List;

import com.chf.dao.UserDao;
import com.chf.entity.User;

public class UserService {
	private UserDao userDao = new UserDao();

	public List<User> findUser(String userName)
	{
		List<User> list= userDao.findByName(userName);
		
		return list;
	}
    public List<User> findUsers()
    {
        List<User> list= userDao.findUserAll();

        return list;
    }
	public void addUser(User auser){
		this.userDao.insert(auser);
	}
	public void deleteUser(User duser){
		this.userDao.delete(duser);
	}
	public User findUserByUserName(String userName){
		User user=userDao.findByUserName(userName);
		return user;
	}
	public void updateUser(User uuser){
		this.userDao.update(uuser);
	}
}
