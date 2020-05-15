package com.infy.employee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SecurityConfiguration  {
//extends WebSecurityConfigurerAdapter
	/* @Autowired */
/*	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin"))
				.authorities("ROLE_USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/securityNone").permitAll().anyRequest().authenticated().and().httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and().csrf().disable();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

}
