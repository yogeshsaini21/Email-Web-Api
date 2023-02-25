package com.masai.team6.Services;

import java.util.List;

import com.masai.team6.Entities.Bookmark;
import com.masai.team6.Entities.Lecture;

public interface BookmarkService {

	Bookmark saveBookmark(Bookmark bookmarks);
	
	List<Integer> lectureByUserId(Integer userId);
	
	void deleteLectureFromBookMark(Integer userId , Integer LectureId);
}
