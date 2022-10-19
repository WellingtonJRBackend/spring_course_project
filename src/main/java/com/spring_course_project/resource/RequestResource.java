package com.spring_course_project.resource;

import com.spring_course_project.domain.Request;
import com.spring_course_project.domain.RequestStage;
import com.spring_course_project.service.RequestService;
import com.spring_course_project.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

	@Autowired
	RequestService service;
	
	@Autowired
	RequestStageService requestStageService;
	
	@PostMapping
	public ResponseEntity<Request> save (@RequestBody Request request){
		Request createdRequest = service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Request> update (@PathVariable Long id,@RequestBody Request request){
		request.setId(id);
		Request updateRequest = service.update(request);
		return ResponseEntity.ok(updateRequest);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Request> getById (@PathVariable Long id){
		Request request = service.getById(id);
		return ResponseEntity.ok(request);
	}
	@GetMapping
	public ResponseEntity<List<Request>> listAll(){
		List<Request> requests = service.listAll();
		return ResponseEntity.ok(requests);
	}
	
	@GetMapping("/{id}/request-stage")
	public ResponseEntity<List<RequestStage>> listAllStageById (@PathVariable Long id){
	List<RequestStage> stages = (List<RequestStage>) requestStageService.listAllByRequestId(id);
	return ResponseEntity.ok(stages);
	}
}
