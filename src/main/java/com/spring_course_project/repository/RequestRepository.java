package com.spring_course_project.repository;

import com.spring_course_project.domain.Request;
import com.spring_course_project.domain.RequestStage;
import com.spring_course_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
	
	public List<Request> findAllByOwnerId( Long id);
	
	@Query("UPDATE request SET stage = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestStage stage);
}
