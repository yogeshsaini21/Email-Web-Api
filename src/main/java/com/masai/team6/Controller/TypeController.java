package com.masai.team6.Controller;

import java.util.List;

import javax.validation.Valid;

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

import com.masai.team6.Payloads.ApiResponse;
import com.masai.team6.Payloads.TypeDto;
import com.masai.team6.Services.TypeService;

@RestController
@RequestMapping("/api/types")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<TypeDto> createType(@Valid @RequestBody TypeDto typeDto){
		
		TypeDto createType =  this.typeService.createType(typeDto);
		return new ResponseEntity<TypeDto>(createType, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{typeId}")
	public ResponseEntity<TypeDto> updateType(@Valid @RequestBody TypeDto typeDto,@PathVariable Integer typeId){
		
		TypeDto updatedtype =  this.typeService.updateType(typeDto, typeId);
		return new ResponseEntity<TypeDto>(updatedtype, HttpStatus.OK);
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{typeId}")
	public ResponseEntity<ApiResponse> DeleteType(@PathVariable Integer typeId){
		
		this.typeService.deleteType(typeId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Type is deleted successfully !! ", true) , HttpStatus.OK);
	}
	
	
	@GetMapping("/{typeId}")
	public ResponseEntity<TypeDto> getCategory(@PathVariable Integer typeId){
		TypeDto typeDto =  this.typeService.getType(typeId);
		return new ResponseEntity<TypeDto>(typeDto, HttpStatus.OK);

	}
	
	@GetMapping("/")
	public ResponseEntity<List<TypeDto>> getAllTypes(){
		List<TypeDto> AllTypeDto =  this.typeService.getTypes();
		return ResponseEntity.ok(AllTypeDto);
	}
	
	

	
}
