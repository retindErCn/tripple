package com.tripple.common;

import org.springframework.data.domain.AuditorAware;

import com.tripple.Entity.user;

public class userAuditor implements AuditorAware<user> {

	@Override
	public user getCurrentAuditor() {
		// TODO Auto-generated method stub
		return null;
	}

}
