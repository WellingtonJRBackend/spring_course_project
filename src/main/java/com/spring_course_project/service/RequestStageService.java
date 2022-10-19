package com.spring_course_project.service;

import com.spring_course_project.domain.RequestStage;
import com.spring_course_project.enums.RequestState;
import com.spring_course_project.repository.RequestRepository;
import com.spring_course_project.repository.RequestStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {
	@Autowired
	RequestStageRepository repository;
	
	@Autowired
	RequestRepository requestRepository;
	
	public RequestStage save (RequestStage stage){
		stage.setRealizationDate(new Date());
		RequestStage createdStage = repository.save(stage);
		Long requestId =stage.getRequest().getId();
		RequestState state = stage.getState();
		requestRepository.updateStatus(requestId,stage);
		return createdStage;
	}
	
	public RequestStage getById (Long id){
		Optional<RequestStage> result = repository.findById(id);
		return result.get();
	}
	public RequestStage listAllByRequestId(Long requestId){
		List<RequestStage> stages = repository.findAllByRequestId(requestId);
		return (RequestStage) stages;
	}
	
}
