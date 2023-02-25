package com.masai.team6.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.team6.Entities.Lecture;
import com.masai.team6.Exception.LectureException;
import com.masai.team6.Repository.LectureDao;
import com.masai.team6.Services.LectureService;

@Service
public class LectureServiceImpl implements LectureService {

	@Autowired
	private LectureDao lectureDao;

	@Override
	public Lecture registerNewLecture(Lecture lecture) {
		return lectureDao.save(lecture);
	}

	@Override
	public Lecture deleteLectureById(Integer lectureId) throws LectureException {

		Lecture lecture = lectureDao.findById(lectureId)
				.orElseThrow(() -> new LectureException("Lecture does not exists or already deleted"));

		lectureDao.delete(lecture);

		return lecture;

	}

	@Override
	public Lecture updateLecture(Lecture lecture) throws LectureException {

		Optional<Lecture> opt = lectureDao.findById(lecture.getLectureID());

		if (opt.isPresent()) {
			return lectureDao.save(lecture);
		} else
			throw new LectureException("Invalid lecture details! ");
	}

	@Override
	public List<Lecture> getAllLectures() throws LectureException {

		List<Lecture> lectures = lectureDao.findAll();

		if (lectures.size() > 0) {
			return lectures;
		} else {
			throw new LectureException("There is no Lecture present!");
		}
	}


	@Override
	public Lecture getLectureById(Integer id) {
		return lectureDao.findById(id).get();
	}

	@Override
	public List<Lecture> searchlecture(Lecture lecture) {
		List<Lecture> getlecture = new ArrayList<>();
		List<Lecture> allLecture = lectureDao.findAll();
		String title = lecture.getTitle().toUpperCase();

		for (int i = 0; i < allLecture.size(); i++) {
			boolean ans = ((allLecture.get(i).getTitle().toUpperCase().contains(title))
					&& (lecture.getBatchId() != 0
							? allLecture.get(i).getBatchId() == lecture.getBatchId() ? true : false
							: true)
					&& (lecture.getSectionId() != 0
							? allLecture.get(i).getSectionId() == lecture.getSectionId() ? true : false
							: true));

			if (ans) {
				getlecture.add(allLecture.get(i));
			}

		}

		return getlecture;
	}


	@Override
	public List<Lecture> getLectureByUserBatchandSection(Integer batchId, Integer sectionId) {
		List<Lecture> lect = this.lectureDao.findByBatchIdAndSectionId(batchId, sectionId);
		
		return lect;
	}


}