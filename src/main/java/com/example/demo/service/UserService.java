package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll(){
		
		return (List<User>) userRepository.findAll();
		
	}
	
	public void saveUser(User user) {
		
		 userRepository.save(user);
	}
	
	public User getUser(Integer id) throws UserNotFoundException {
		
		Optional<User> result = userRepository.findById(id);
	
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException();
	}
	
	public void deleteUser(Integer id) throws UserNotFoundException {
		
		Long count =userRepository.countById(id);
		
		if(count==null || count==0) {
			throw new UserNotFoundException();
		}
		
		userRepository.deleteById(id);
	}
	
}
