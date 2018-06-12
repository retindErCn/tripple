package com.tripple.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.tripple.Entity.user;
/**
 * 获取当前用户
 * @author Administrator
 *
 */
public class userUtil {

	public static user getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth == null || !auth.isAuthenticated())
			return null;
		return (user) auth.getPrincipal();

	}
}
