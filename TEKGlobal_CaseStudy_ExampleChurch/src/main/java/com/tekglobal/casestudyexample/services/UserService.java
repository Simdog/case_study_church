package com.tekglobal.casestudyexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekglobal.casestudyexample.models.User;
import com.tekglobal.casestudyexample.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void saveUser(User user) {
		userRepository.save(user);
		
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}
	public User findUserByUsername(String username ) {
		return userRepository.findUserByUsername(username);
	}
}
