package com.masai.team6.Services;

import java.util.List;

import com.masai.team6.Entities.Lecture;
import com.masai.team6.Exception.LectureException;

public interface LectureService {

	public Lecture registerNewLecture(Lecture lecture);

	public Lecture deleteLectureById(Integer lectureId) throws LectureException;

	public Lecture updateLecture(Lecture lecture) throws LectureException;

	public List<Lecture> getAllLectures() throws LectureException;
	
	public Lecture getLectureById(Integer id);
	
	public List<Lecture> searchlecture(Lecture lecture);
	

	public List<Lecture> getLectureByUserBatchandSection(Integer batchId , Integer sectionId);


}
