package com.masai.team6.Entities;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lectureID;
	private String title;
	private String createdBy;
	private String updatedBy;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private LocalDateTime startTime;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private LocalDateTime concludeTime;
	

	@URL
	private String zoomLink;
	private Integer typeId;
	private Integer batchId;
	private Integer categoryId;
	private Integer tagId;
    private Integer sectionId;
    

    private boolean optional;
    private boolean hideVideo;
    private String video;
    private String copyLectureFrom;
    @Column(length = 6000)
    private String notes;
    
  
	
	
	
}

