package com.todoapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entity.User;
import com.todoapp.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
		
	public String registerUser(String username, String password) {
		if(userRepo.findByUsername(username).isPresent()) {
			return "User already registerd";
		}
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepo.save(user);
		return "User register successfully";
	}
	
	public Optional<User> loginUser(String username, String password) {
	    Optional<User> user = userRepo.findByUsername(username);
	    
	    if (user.isPresent() && user.get().getPassword().equals(password)) {
	        return user;  // Valid login
	    }
	    
	    return Optional.empty();  // Invalid login
	}
}
