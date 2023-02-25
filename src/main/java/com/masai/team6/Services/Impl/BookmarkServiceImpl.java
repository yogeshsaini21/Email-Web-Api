package com.masai.team6.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.team6.Entities.Bookmark;
import com.masai.team6.Entities.Lecture;
import com.masai.team6.Repository.BookmarkRepo;
import com.masai.team6.Repository.LectureDao;
import com.masai.team6.Repository.UserRepo;
import com.masai.team6.Services.BookmarkService;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkRepo bookRepo;

	@Autowired
	private BookmarkRepo bookMarkRepo;

	@Override
	public Bookmark saveBookmark(Bookmark bookmarks) {

		return bookMarkRepo.save(bookmarks);
	}

	@Override
	public List<Integer> lectureByUserId(Integer userId) {
		List<Integer> lectureID = this.bookRepo.findByUserId(userId);
		return lectureID;
	}

	@Override
	public void deleteLectureFromBookMark(Integer userId, Integer LectureId) {
		Bookmark bookmark = this.bookMarkRepo.findByUserIdAndLectureId(userId, LectureId);
		System.out.println(bookmark);
		this.bookMarkRepo.delete(bookmark);
		
	}

}
