package com.framgia.fitm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framgia.fitm.model.User;
import com.framgia.fitm.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User login () {
		
		User user = new User();
		
		try{
			user = userService.login(user);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
}
