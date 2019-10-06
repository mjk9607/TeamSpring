package com.test.springboard.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboard.dao.UserDAO;
import com.test.springboard.services.UserService;
import com.test.springboard.vo.UserVO;

@Service("loginService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.searchUser(userVO);
	}

}
