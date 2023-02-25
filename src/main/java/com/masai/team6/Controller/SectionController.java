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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.team6.Entities.Section;
import com.masai.team6.Payloads.ApiResponse;
import com.masai.team6.Payloads.SectionDto;
import com.masai.team6.Services.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {

	@Autowired
    private SectionService sectionService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<SectionDto> saveSection(@RequestBody SectionDto section){
		
		SectionDto sectionNew = this.sectionService.saveSection(section);
		
		return new ResponseEntity<SectionDto>(sectionNew, HttpStatus.CREATED);
	}
	
	@GetMapping("/MySections")
	public ResponseEntity<List<SectionDto>> Mysections(){

		List<SectionDto> section= this.sectionService.MySections();
		return new ResponseEntity<List<SectionDto>>(section,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer id){

		this.sectionService.deleteSection(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Section deleted successfully", true), HttpStatus.OK);
	}
}
