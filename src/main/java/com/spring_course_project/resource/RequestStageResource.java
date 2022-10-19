package com.spring_course_project.resource;

import com.spring_course_project.domain.RequestStage;
import com.spring_course_project.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request-stage")
public class RequestStageResource {
	@Autowired
	RequestStageService service;
	
	@PostMapping
	public ResponseEntity<RequestStage> save (RequestStage stage){
		RequestStage createdStage = service.save(stage);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
	}
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById( @PathVariable Long id){
		RequestStage stage = service.getById(id);
		return ResponseEntity.ok(stage);
	}
}
