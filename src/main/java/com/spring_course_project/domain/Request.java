package com.spring_course_project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
	
	private Long id;
	private String subject;
	private String description;
	private Date creationDate;
	
	private RequestState state;
	private User user;
	List<RequestStage> stages = new ArrayList<>();
}
