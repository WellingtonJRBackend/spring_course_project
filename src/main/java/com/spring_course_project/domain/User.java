package com.spring_course_project.domain;

import com.spring_course_project.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
		private Long id;
		private String name;
		private String email;
		private String password;
		private Role role;
		
		private List<Request> requests = new ArrayList<>();
		private List<RequestStage> stages = new ArrayList<>();
	}

