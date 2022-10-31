package com.ebidingapp.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebidingapp.entity.UserRegistration;
import com.ebidingapp.repository.UserRegistrationRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	public BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserRegistration userRegistration=userRegistrationRepository.findByLoginId(username); 
		return User.withUsername(username).password(passwordEncoder.encode(userRegistration.getPassword())).authorities(Collections.emptyList())
				.accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).build();
	}

}
