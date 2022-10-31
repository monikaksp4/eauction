package com.ebidingapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ebidingapp.entity.UserRegistration;
import com.ebidingapp.repository.UserRegistrationRepository;


@Service
public class RegistrationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRegistrationRepository userRegistrationRepository;
		public String saveUserRegistration(UserRegistration registration) throws Exception {
			logger.info("Entered into save user method");
			UserRegistration user=userRegistrationRepository.findByLoginIdAndEmail(registration.loginId, registration.email);
			boolean existingUser=user==null?true:false;
			logger.info("Checking UserAlready Exist"+existingUser);
			if(!existingUser) {
				throw new Exception("LoginId and EmailId already Exist");
				}
			else {
				userRegistrationRepository.save(registration);
				
			}
			
		
		 return "saved";
		
	}
		public UserRegistration getUser(String username) {
			logger.info("Enter into get user method");
			return userRegistrationRepository.findByLoginId(username);
		}

			public List<UserRegistration> getAllUser(){
				logger.info("Enter into get user method");
				return userRegistrationRepository.findAll();
			}
			
			public String updatePassword(String loginId,String oldPassword,String newPassword) throws Exception {
				logger.info("Enter into update password method");
				boolean valid=userRegistrationRepository.existsByLoginIdAndPassword(loginId,oldPassword);
				if(valid) {
					UserRegistration user=userRegistrationRepository.findByLoginId(loginId);
					user.setPassword(newPassword);
					userRegistrationRepository.save(user);
				}
				else {
					throw new Exception("Old password incorrect");
				}
				return "updated";
			}
			public String forgetPassword(String loginId,String newPassword) throws Exception {
				logger.info("Enter into forget password method");
				boolean valid=userRegistrationRepository.existsByLoginId(loginId);
				if(valid) {
					UserRegistration user=userRegistrationRepository.findByLoginId(loginId);
					user.setPassword(newPassword);
					userRegistrationRepository.save(user);
				}
				else {
					throw new Exception("incorrect loginId");
				}
				return "updated";
			}

}
