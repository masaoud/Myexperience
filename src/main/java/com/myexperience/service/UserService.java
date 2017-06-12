package com.myexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.User;
import com.myexperience.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public User add(User user)	
	{
		String upperCaseName = user.getFirstName().toUpperCase();
		user.setFirstName(upperCaseName);
		
		// or we can do it this way
		user.setLastName(user.getLastName().toUpperCase());
		
		return this.userRepository.save(user);
	}
	
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}
	
	public User findUserByEmail(String email)
	{
		return this.userRepository.findByEmail(email);
	}
	
	public List<User> findUsersByLastName(String lastName)
	{
		return this.userRepository.findByLastName(lastName);
	}
	
	public List<User> findUsersByLastNameAndFistName(String lastName, String firstName)
	{
		return this.userRepository.findByLastNameAndFirstName(lastName, firstName);
	}
	
}
