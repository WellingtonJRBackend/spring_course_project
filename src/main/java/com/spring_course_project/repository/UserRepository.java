package com.spring_course_project.repository;

import com.spring_course_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("SELECT FROM User WHERE email = ?1 AND password = ?2")
	public Optional<User> login (String email,String password);
}
