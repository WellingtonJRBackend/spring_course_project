package com.spring_course_project.repository;

import com.spring_course_project.domain.Request;
import com.spring_course_project.domain.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestStageRepository extends JpaRepository<RequestStage,Long> {
	
	public List<RequestStage> findAllByRequestId( Long id);
}
