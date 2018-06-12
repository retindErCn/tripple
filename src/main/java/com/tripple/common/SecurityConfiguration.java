package com.tripple.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity
@Order(99)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 简单定义网页的一些基本权限
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/about").permitAll()
				.antMatchers("/admin/**", "/test/**").hasRole("ADMIN")
				.regexMatchers("/testsuite/(.+?)/.*")
				.access("testsuitePermissionRegex('/testsuite/(.+?)/.*')")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				// .loginPage("/login")
				.defaultSuccessUrl("/index").failureUrl("/login?error")
				.permitAll().and().rememberMe().tokenValiditySeconds(1209600)
				.key("trippleid")
				// rememberme设置为14天
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/index")
				.permitAll();
		http.csrf().disable();
	}

	/**
	 * 用户实际的登录认证
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(new myUserDetailsService()).passwordEncoder(
				new BCryptPasswordEncoder());
	}

}
