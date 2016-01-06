package com.dc.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dc.test.dao.impl.UserDao;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	public String list() {
		return JSON.toJSONString(userDao.list());
	}
}
