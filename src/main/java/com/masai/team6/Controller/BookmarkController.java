package com.masai.team6.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.team6.Entities.Bookmark;
import com.masai.team6.Entities.Lecture;
import com.masai.team6.Payloads.ApiResponse;
import com.masai.team6.Services.BookmarkService;
import com.masai.team6.Services.LectureService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

	@Autowired
	private LectureService lectService;
	
	@Autowired
    private BookmarkService bookmarkService;
	

	 @PreAuthorize("hasRole('NORMAL')")
	@PostMapping("/")
	public ResponseEntity<String> saveBookmark(@RequestParam Integer userId , @RequestParam Integer lectureId){
		
		Bookmark bookmark = new Bookmark();
		bookmark.setUserId(userId);
		bookmark.setLectureId(lectureId);
		
		Bookmark bookmarkNew = this.bookmarkService.saveBookmark(bookmark);
		
		return new ResponseEntity<String>("Lecture Added In Bookmark", HttpStatus.OK);
	}
	

	 @PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/MyBookmarks/{userid}")
	public ResponseEntity<Set<Lecture>> getAllBook(@PathVariable Integer userid){
		
		Set<Lecture> setLecture = new HashSet<>();
		List<Integer> bookmark= this.bookmarkService.lectureByUserId(userid);
		for(int i=0;i<bookmark.size();i++) {
			Lecture lect =this.lectService.getLectureById(bookmark.get(i));
			setLecture.add(lect);
		}
		
		return new ResponseEntity<Set<Lecture>>(setLecture,HttpStatus.OK);
	}
	

	 @PreAuthorize("hasRole('NORMAL')")
	@DeleteMapping("/{userId}/{lectureId}")
	public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer userId,@PathVariable Integer lectureId){

		 this.bookmarkService.deleteLectureFromBookMark(userId , lectureId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Lecture removed", true), HttpStatus.OK);
	}
}
