package com.tripple.suite.service;

import java.util.List;

import lombok.Data;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tripple.Entity.suiteToStep;
import com.tripple.Entity.user;
import com.tripple.Repos.suiteToStepRepo;
import com.tripple.Repos.userRepo;
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.api.pojo.userDto;

@Component
@Data
public class userService {
	@Autowired
	userRepo userRepo;

	/**
	 * 注册
	 */
	public void signUP(userDto userDto) {
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
		user s = user.builder().Email(userDto.getEmail())
				.userName(userDto.getUserName())
				.userPwd(cryptPasswordEncoder.encode(userDto.getUserPwd()))
				.signupDate(new DateTime()).upDateTime(new DateTime()).build();
		userRepo.save(s);
	}

	/**
	 * 修改密码
	 */
	public Boolean modifyPwd(String userName, String newPwd) {
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

		user s = userRepo.findByUserName(userName);
		newPwd = cryptPasswordEncoder.encode(newPwd);
		if (s.getPassword() == newPwd) {
			return false;
		} else {
			s.setUserPwd(newPwd);
			s.setUpDateTime(new DateTime());
			userRepo.save(s);
			return true;
		}

	}

	/**
	 * 修改邮箱
	 */
	public void modifyEmail(String userName, String email) {

		user s = userRepo.findByUserName(userName);
		s.setUpDateTime(new DateTime());
		s.setEmail(email);
		userRepo.save(s);

	}

	public user getUserByUserName(String username) {
		return userRepo.findByUserName(username);
	}

}
