package com.spring_course_project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestStage {
	
	private Long id ;
	private String description;
	private Date realizationDate;
	
	private RequestState state;
	private Request request;
	private User user;
}

