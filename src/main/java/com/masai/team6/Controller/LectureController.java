package com.masai.team6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.team6.Entities.Lecture;
import com.masai.team6.Exception.LectureException;
import com.masai.team6.Services.LectureService;

@RestController
@RequestMapping("/api/lecture/")
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addLecture")
	public ResponseEntity<String> registerLectureHandler(@RequestBody Lecture lecture) {
		
		Lecture addLecture = lectureService.registerNewLecture(lecture);
		if(addLecture !=null)
		return new ResponseEntity<String>("Lecture Added Successfully",HttpStatus.ACCEPTED);
		else {
			return new ResponseEntity<String>("Lecture Not Added ",HttpStatus.FORBIDDEN);
			
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/removeLecture/{lectureId}")
	public ResponseEntity<Lecture> deleteLectureHandler(@PathVariable("lectureId") Integer lectureId) throws LectureException {
		
		Lecture lecture= lectureService.deleteLectureById(lectureId);
		
		return new ResponseEntity<Lecture>(lecture,HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/lectures")
	public ResponseEntity<Lecture> updateLectureEntityHandler(@RequestBody Lecture lecture) throws LectureException{
		
		Lecture updateLecture = lectureService.updateLecture(lecture);
		
		return new ResponseEntity<Lecture>(updateLecture,HttpStatus.ACCEPTED);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/lectures")
	public ResponseEntity<List<Lecture>> getAllLecturesHandler() throws LectureException{
		
		List<Lecture> lectures = lectureService.getAllLectures();
	
		return new ResponseEntity<List<Lecture>>(lectures,HttpStatus.OK);
	}
	
	
	@PostMapping("/search")
	public List<Lecture> getLectureByTitle(@RequestBody Lecture lecture){
		
		
		List<Lecture> lect = this.lectureService.searchlecture(lecture);
		
		return lect;
	}

	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/{batchId}/{sectionId}")
	public List<Lecture> getLectureByUserBatchAndSection(@PathVariable Integer batchId ,@PathVariable Integer sectionId){
		List<Lecture> lectureByUserBatchandSection = this.lectureService.getLectureByUserBatchandSection(batchId, sectionId);
		return lectureByUserBatchandSection;
	}
	

}
