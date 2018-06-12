package com.tripple.user.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.api.pojo.userDto;
import com.tripple.common.restResult;
import com.tripple.suite.service.userService;

@RestController
@RequestMapping(value = "/")
public class userController {

	@Autowired
	userService userService;

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public void usersignUP(userDto userDto) {
		userService.signUP(userDto);
		
	}

	//@RequestMapping(value = "login", method = RequestMethod.POST)
	public String userlogin(userDto userDto) {
		return null;
	}

}
