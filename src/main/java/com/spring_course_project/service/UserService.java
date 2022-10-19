package com.spring_course_project.service;

import com.spring_course_project.domain.User;
import com.spring_course_project.repository.UserRepository;
import com.spring_course_project.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User save(User user){
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	public User update (User user){
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		User updateUser = userRepository.save(user);
		return updateUser;
	}
	
	public User getById(Long id){
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}
	
	public List<User> listAll(){
		List<User> users = userRepository.findAll();
		return users;
	}
	public User login (String email,String passaword){
		passaword = HashUtil.getSecureHash(passaword);
		Optional<User> result = userRepository.login(email,passaword);
		return result.get();
	}
	
	
}
