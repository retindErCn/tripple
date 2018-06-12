package com.tripple.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tripple.Repos.userRepo;
import com.tripple.suite.service.userService;

@Component("myUserDetailsService")
public class myUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		userService s = ApplicationContextHolder.getContext().getBean(
				userService.class);
		return s.getUserByUserName(username);

	}

}
