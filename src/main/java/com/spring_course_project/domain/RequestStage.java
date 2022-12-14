package com.spring_course_project.domain;

import com.spring_course_project.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "request_stage")
public class RequestStage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name = "realization_date",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	
	@Column(length = 12,nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne
	@JoinColumn(name = "request_id",nullable = false)
	private Request request;
	
	@ManyToOne
	@JoinColumn(name = "owner_id",nullable = false)
	private User owner;
}

