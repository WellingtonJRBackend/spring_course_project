package com.spring_course_project.resource;

import com.spring_course_project.domain.Request;
import com.spring_course_project.domain.User;
import com.spring_course_project.dto.UserLoginDTO;
import com.spring_course_project.service.RequestService;
import com.spring_course_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	UserService service;
	
	@Autowired
	RequestService requestService;
	
	@PostMapping
	public ResponseEntity<User>save (@RequestBody User user){
		User createdUser = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> update (@PathVariable Long id,@RequestBody User user){
	user.setId(id);
	User updateUser = service.update(user);
	return ResponseEntity.ok(updateUser);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getById (@PathVariable Long id){
		User user = service.getById(id);
		return ResponseEntity.ok(user);
	}
	@GetMapping
	public ResponseEntity<List<User>> listAll(){
		List<User> users = service.listAll();
		return ResponseEntity.ok(users);
	}
	@PostMapping("/login")
	public ResponseEntity<User> login (@RequestBody UserLoginDTO user){
		User loggedUser = service.login(user.getEmail(),user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}
	@GetMapping("/{id}/requests")
	public  ResponseEntity<List<Request>> listAllRequestById(@PathVariable Long id){
	List<Request> request = requestService.listAllByOwnerId(id);
	return ResponseEntity.ok(request);
	}
}
